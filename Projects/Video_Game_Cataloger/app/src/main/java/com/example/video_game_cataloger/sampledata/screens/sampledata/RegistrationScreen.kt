package com.example.video_game_cataloger.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import kotlinx.coroutines.launch
import com.example.video_game_cataloger.R

@Composable
fun RegistrationPage() {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var showLoading by remember { mutableStateOf(false) }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost (snackbarHostState)},
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                // Background image
                Image(
                    painter = painterResource(R.drawable.register_bg),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                // Semi-transparent overlay
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.7f))
                )
                // Loading indicator
                if (showLoading) {
                    Dialog(onDismissRequest = {}) {
                        CircularProgressIndicator(color = Color.Blue)
                    }
                }
                // Registration form
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Card(
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF455A64)),
                        modifier = Modifier.padding(20.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Register",
                                color = Color.White,
                                fontSize = 32.sp,
                                modifier = Modifier
                                    .align(Alignment.Start)
                                    .padding(bottom = 20.dp)
                            )
                            OutlinedTextField(
                                value = username,
                                onValueChange = { cng -> username = cng },
                                label = { Text("Username", color = Color.Gray) },
                                leadingIcon = {
                                    Icon(Icons.Filled.Person, contentDescription = null, tint = Color.Gray)
                                },
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = Color.Gray,
                                    unfocusedBorderColor = Color.Gray,
                                    unfocusedTextColor = Color.Gray
                                ),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            OutlinedTextField(
                                value = email,
                                onValueChange = {cng -> email = cng },
                                label = { Text("Email address", color = Color.Gray) },
                                leadingIcon = {
                                    Icon(Icons.Filled.Email, contentDescription = null, tint = Color.Gray)
                                },
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = Color.Gray,
                                    unfocusedBorderColor = Color.Gray,
                                    unfocusedTextColor = Color.Gray
                                ),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            OutlinedTextField(
                                value = password,
                                onValueChange = { cng -> password = cng },
                                label = { Text("Password", color = Color.Gray) },
                                leadingIcon = {
                                    Icon(Icons.Filled.Lock, contentDescription = null, tint = Color.Gray)
                                },
                                visualTransformation = PasswordVisualTransformation(),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = Color.Gray,
                                    unfocusedBorderColor = Color.Gray,
                                    unfocusedTextColor = Color.Gray
                                ),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            OutlinedTextField(
                                value = confirmPassword,
                                onValueChange = { cng -> confirmPassword = cng },
                                label = { Text("Confirm Password", color = Color.Gray) },
                                leadingIcon = {
                                    Icon(Icons.Filled.Lock, contentDescription = null, tint = Color.Gray)
                                },
                                visualTransformation = PasswordVisualTransformation(),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = Color.Gray,
                                    unfocusedBorderColor = Color.Gray,
                                    unfocusedTextColor = Color.Gray
                                ),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Button(
                                onClick = {
                                    showLoading = true
                                    // Simulate registration process
                                    scope.launch {
                                        // Simulate delay
                                        kotlinx.coroutines.delay(2000)
                                        showLoading = false
                                        snackbarHostState.showSnackbar("Registration successful")
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF607D8B)),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                            ) {
                                Text("Create Account")
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                TextButton(onClick = { /* Navigate to login */ }) {
                                    Text("Log in", color = Color(0xFFB0BEC5))
                                }
                                TextButton(onClick = { /* Sign in as guest */ }) {
                                    Text("Sign in as guest", color = Color(0xFFB0BEC5))
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}
