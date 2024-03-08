package com.zekierciyas.document_scanner_mlkit.document_scanner

import com.google.mlkit.vision.documentscanner.GmsDocumentScanningResult

interface IDocumentScanner {
    fun init(): DocumentScanner

    fun result(result: (GmsDocumentScanningResult?) -> Unit): DocumentScanner

    fun start(exception: (Exception) -> Unit): DocumentScanner
}