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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() { //Класс MainActivity -подкласс класса ComponentActivity
    //реализует один метод onCreate(), который используется
    // для обеспечения связи между стартовой активностью и пользовательскими интерфейсами
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeDemoTheme { //composable функция
            }
        }
    }
}

@Composable // функция создает элемент на экране
fun DemoText(message: String, fontSize: Float) {
    Text(
        text = message,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold
    )
}


@Preview(showBackground = true, showSystemUi = true) //реализует предварительный просмотр
@Composable
fun DemoTextPreview() {
    ComposeDemoTheme {
        DemoText(message = "Welcome to Android", fontSize = 12f)
    }
}