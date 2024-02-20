package com.petter.uppgift2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.petter.uppgift2.ui.theme.Uppgift2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Uppgift2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    List()
                }
            }
        }
    }
}


@Composable
fun List() {
    val listState = remember { mutableStateOf(listOf<String>()) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(color = Color.Blue)
                .fillMaxWidth(1f)
                .padding(vertical = 20.dp)
        ) {
            ElevatedButton(onClick = { listState.value = listState.value + "X" }) {
                Text(text = "X")
            }
            Spacer(modifier = Modifier.width(20.dp))
            ElevatedButton(onClick = { listState.value = listState.value + "Y" }) {
                Text(text = "Y")
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            listState.value.forEach { item ->
                Text(text = item)
            }
        }

        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize(1f)
                .padding(bottom = 20.dp)
        ) {
            ElevatedButton(onClick = { listState.value = emptyList() }) {
                Text(text = "Reset")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ListPreview() {
    List()
}
