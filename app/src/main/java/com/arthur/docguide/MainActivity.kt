package com.arthur.docguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arthur.docguide.ui.theme.DocGuideTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DocGuideTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    App()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    var process by remember {
        mutableStateOf("")
    }
    var documents: List<String>? by remember {
        mutableStateOf(listOf(""))
    }
    var text by remember {
        mutableStateOf("")
    }
    var expanded by remember {
        mutableStateOf(false)
    }
    val processList = Documents().getProcess()
    val clipboardManager: ClipboardManager = LocalClipboardManager.current
    Column(
        Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "DocGuide",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = it }) {
                TextField(
                    label = {
                        Text(text = "Processos")
                    },
                    value = process,
                    onValueChange = { process = it },
                    readOnly = true,
                    modifier = Modifier.menuAnchor(),
                    shape = RoundedCornerShape(20.dp),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                    )
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }) {
                    for (processItem: String in processList) {
                        DropdownMenuItem(
                            text = { Text(text = processItem) },
                            onClick = {
                                expanded = false
                                process = processItem
                                documents = Documents().getDocuments(process)
                                text = documents?.joinToString("\n") ?: ""
                            })
                    }
                }
            }
            TextField(
                value = text,
                onValueChange = { text = it },
                maxLines = 10,
                label = {
                    Text(text = "Documentos")
                },
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                )
            )
            Button(
                onClick = {
                    clipboardManager.setText(AnnotatedString(text))
                },
                enabled = text.isNotBlank(),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .width(275.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Copiar"
                )
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    DocGuideTheme {
        App()
    }
}
