package com.android.jetpackcomposedemo.login.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.android.jetpackcomposedemo.data.api.navigation.UserNavHost
import com.android.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()


                    Scaffold(topBar = {
                        TopAppBar(
                            title = { Text(text = "Home") },
                            colors = TopAppBarDefaults.largeTopAppBarColors(
                                containerColor = colorScheme.primary
                            ),
                            actions = {
                                IconButton(onClick = { /*TODO*/ }) {
                                }
                            }
                        )
                    }) {
                        UserNavHost(
                            navController = navController,
                            modifier = Modifier.padding(it)
                        )
                    }
                }
            }
        }
    }
}
