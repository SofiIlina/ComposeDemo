package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DemoScreen(modifier = Modifier.padding(innerPadding))
                }
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

@Composable
fun DemoSlider(sliderPosition: Float, onPositionChange: (Float) -> Unit ) {
    Slider(
        modifier = Modifier.padding(10.dp),
        valueRange = 20f..38f,
        value = sliderPosition,
        onValueChange = onPositionChange
    )
}

@Composable
fun DemoScreen(modifier: Modifier = Modifier) {
    var sliderPosition by remember { mutableFloatStateOf(20f) }
    //mutableFloatStateOf() — коробка с содержимым типа float
    //remember — запоминает значение, созданное в блоке между перерисовками
    val handlePositionChange = { position : Float -> //лямбда-функция, которая обновляет состояние слайдера
        sliderPosition = position
    }
    Column( //вертикальное расположение всех элементов по центру
        horizontalAlignment = Alignment.CenterHorizontally, //выравнивание по горизонтали
        verticalArrangement = Arrangement.Center, //выравнивание по вертикали
        modifier = Modifier.fillMaxSize() //занимает весь доступный размер
    ) {
        DemoText(message = "Welcome to Compose", fontSize = sliderPosition)
        Spacer(modifier = Modifier.height(150.dp)) //добавляет вертикальный отступ 150dp между элементами
        DemoSlider( //компонент для изменения значения
            sliderPosition = sliderPosition,
            onPositionChange = handlePositionChange
        )
        Text( //показывает текущее значение слайдера в sp
            style = MaterialTheme.typography.headlineMedium,
            text = sliderPosition.toInt().toString() + "sp"
        )
    }
}

@Preview(showBackground = true, showSystemUi = true) //реализует предварительный просмотр
@Composable
fun DemoTextPreview() {
    ComposeDemoTheme {
        //Scaffold - готовый каркас экрана со стандартными элементами Material Design
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            DemoScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}

//Данные переходят из функции DemoSlider в функцию DemoText через общее состояние sliderPosition в функции DemoScreen.