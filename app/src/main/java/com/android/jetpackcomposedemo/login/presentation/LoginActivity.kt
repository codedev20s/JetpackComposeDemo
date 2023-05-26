package com.android.jetpackcomposedemo.login.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.jetpackcomposedemo.login.data.LoginRepositoryImpl
import com.android.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var variable:LoginRepositoryImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          setContent {
            JetpackComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                   // val viewModel by viewModels<LoginViewModel>()
                    val model = hiltViewModel<LoginViewModel>()
                    model.testLiveData.observe(this){
                        Log.i("LOGINACTIVITY", "onCreate: $it")
                    }

                    Log.i("LOGINACTIVITY 1", "onCreate: ${variable.xyz}")

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier,model: LoginViewModel = hiltViewModel<LoginViewModel>()) {

    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeDemoTheme {
        Greeting("Android")
    }
}