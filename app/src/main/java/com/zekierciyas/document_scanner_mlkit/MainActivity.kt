package com.zekierciyas.document_scanner_mlkit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.zekierciyas.document_scanner_mlkit.document_scanner.DocumentScanner
import com.zekierciyas.document_scanner_mlkit.ui.screens.DocumentScannerScreen
import com.zekierciyas.document_scanner_mlkit.ui.theme.DocumentscannermlkitTheme

class MainActivity : ComponentActivity() {
    private var documentScanner : DocumentScanner = DocumentScanner(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DocumentscannermlkitTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   DocumentScannerScreen(documentScanner = documentScanner)
                }
            }
        }
    }
}



