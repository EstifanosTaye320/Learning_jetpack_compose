package com.example.practice_area

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySnackbarDemo()        }
    }
}

@Composable
fun MySnackbarDemo() {
    var showSnackBar11 by remember { mutableIntStateOf(0) }

    val snackbarHostState  = remember { SnackbarHostState() }

    val cupertin = rememberCoroutineScope()

    Scaffold (modifier = Modifier.fillMaxSize(), snackbarHost = {
        SnackbarHost (hostState = snackbarHostState)
    }) {

        Column (modifier = Modifier
            .padding(it)
            .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

                    Button(onClick = {
                        showSnackBar11++
                        cupertin.launch {
                            snackbarHostState.showSnackbar("Estif did it he created snackbar Number $showSnackBar11")
                        }
                    }) {
                            Text("Show Snackbar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MySnackbarDemoPreview() {
    MySnackbarDemo()
}