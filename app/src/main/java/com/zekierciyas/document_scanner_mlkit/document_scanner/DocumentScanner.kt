package com.zekierciyas.document_scanner_mlkit.document_scanner

import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import com.google.mlkit.vision.documentscanner.GmsDocumentScannerOptions
import com.google.mlkit.vision.documentscanner.GmsDocumentScanning
import com.google.mlkit.vision.documentscanner.GmsDocumentScanningResult

class DocumentScanner(private val activity: ComponentActivity): IDocumentScanner {

    private var result: (GmsDocumentScanningResult?) -> Unit = {}

    private val options = GmsDocumentScannerOptions.Builder()
        .setGalleryImportAllowed(false)
        .setPageLimit(2)
        .setResultFormats(
            GmsDocumentScannerOptions.RESULT_FORMAT_JPEG,
            GmsDocumentScannerOptions.RESULT_FORMAT_PDF
        )
        .setScannerMode(GmsDocumentScannerOptions.SCANNER_MODE_FULL)
        .build()

    private val scanner = GmsDocumentScanning.getClient(options)
    private lateinit var scannerLauncher: ActivityResultLauncher<IntentSenderRequest>

    override fun init() = apply {
        scannerLauncher = activity
            .registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) {
                result ->
            run {
                if (result.resultCode == ComponentActivity.RESULT_OK) {
                    val resultData =
                        GmsDocumentScanningResult.fromActivityResultIntent(result.data)
                    this.result.invoke(resultData)
                }
            }
        }
    }

    override fun result(result: (GmsDocumentScanningResult?) -> Unit) = apply {
        this.result = result
    }

    override fun start(exception: (Exception) -> Unit) = apply {
        scanner.getStartScanIntent(activity)
            .addOnSuccessListener { intentSender ->
                scannerLauncher.launch(IntentSenderRequest.Builder(intentSender).build())
            }
            .addOnFailureListener {
                exception.invoke(it)
            }
    }
}
