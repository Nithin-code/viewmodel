package com.nithin.viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nithin.viewmodel.ui.theme.ViewmodelTheme

class MainActivity : ComponentActivity() {
    
    // andriod way of creating view model then only this variable will not bound to activity
    private val viewModel by viewModels<HomeViewModel>()

    // worong way of declaring viewmodel (view model is bounded to activity life cycle)
    private val vm = HomeViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ViewmodelTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),
                        viewModel
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, viewModel: HomeViewModel) {
     Surface(
         modifier = Modifier.fillMaxSize()
             .padding(
                 100.dp
             ),
         shape = RoundedCornerShape(20.dp),
         color = viewModel.backgroundColor
     ) {

         Column(
             modifier = Modifier.fillMaxSize(),
             horizontalAlignment = Alignment.CenterHorizontally,
             verticalArrangement = Arrangement.Center
         ) {

             Button(onClick = {
                 viewModel.changeBackgroundColor()
             }) {
                 Text(text = "Change Color to ")
             }

         }

     }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ViewmodelTheme {
        Greeting("Android", viewModel = HomeViewModel())
    }
}