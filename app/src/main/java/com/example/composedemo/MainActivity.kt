package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() { //Класс MainActivity -подкласс класса ComponentActivity
    //реализует один метод onCreate(), который используется
    // для обеспечения связи между стартовой активностью и пользовательскими интерфейсами
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeDemoTheme { //composable функция
                //Scaffold — это встроенный элемент Compose, который предоставляет стандартную
                //структуру пользовательского интерфейса
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable // функция создает элемент на экране
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true) //функция предварительного просмотра
//содержимое, выдаваемое функцией, должно отображаться на панели предварительного просмотра
@Composable
fun GreetingPreview() {
    ComposeDemoTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Greeting("Compose", modifier = Modifier.padding(innerPadding))
        }
    }
}