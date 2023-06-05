package com.android.jetpackcomposedemo.login.presentation

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.android.jetpackcomposedemo.data.DefaultErrorScreen
import com.android.jetpackcomposedemo.data.DefaultLoaderScreen
import com.android.jetpackcomposedemo.data.api.navigation.Routes
import com.android.jetpackcomposedemo.login.data.LoginResonse
import com.android.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme


 
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun CreateUI(
    loginViewModel: LoginViewModel ,
    onNavigationLoginSuccess: (data: LoginResonse) -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val errorMessage = "Text input too long"
    var isError by rememberSaveable { mutableStateOf(false) }

    val charLimit = 4

     val localKeyboard = LocalSoftwareKeyboardController.current

    //  var textFieldValueState by remember{ mutableStateOf() }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(value = username, onValueChange = { username = it },
                maxLines = 1, label = { Text(text = "User Name") })
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                label = { Text(text = "Password") },
                value = password,
                onValueChange = { password = it },
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                keyboardActions = KeyboardActions.Default
            )
        }

        val interactionSource = remember { MutableInteractionSource() }
        val isPressed by interactionSource.collectIsPressedAsState()



        Button(
            onClick = {
                localKeyboard?.hide()
                loginViewModel.callLoginAPI(username, password)
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            enabled = (username.isNotEmpty()) && (password.isNotEmpty()),
            interactionSource = interactionSource) {

            Row {
                Text(if (isPressed) "Login Pressed!" else " Login Not pressed")
            }
          //  Text(text = "Login")
        }
    }

    when (val pageUi = loginViewModel.pageState.value) {
        LoginPageUiState.LOADING -> DefaultLoaderScreen()
        is LoginPageUiState.SUCCESS -> {
            Log.i("TAG CreateUI: ", "HELLO")
            Toast.makeText(
                LocalContext.current,
                pageUi.userResponse.firstName,
                Toast.LENGTH_LONG
            ).show()
            onNavigationLoginSuccess(pageUi.userResponse)
        }
        is LoginPageUiState.FAILURE -> DefaultErrorScreen(msg = pageUi.msg)
        is LoginPageUiState.DONothing -> {}
    }
}