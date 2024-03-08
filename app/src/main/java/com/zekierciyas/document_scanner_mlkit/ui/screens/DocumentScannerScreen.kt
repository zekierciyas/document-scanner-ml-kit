package com.zekierciyas.document_scanner_mlkit.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zekierciyas.document_scanner_mlkit.document_scanner.DocumentScanner


@Composable
fun DocumentScannerScreen(documentScanner: DocumentScanner) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                documentScanner.start {
                    it.printStackTrace()
                }
            }
        ) {
            Text(text = "Start Document Scanner")
        }
    }
}