package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

class ListDemoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

@Composable
fun MyList() {
    RowList()
}

@Composable
fun ColumnList() {
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        Row() {
            Button(onClick = {
                coroutineScope.launch {
                    scrollState.animateScrollTo(0)
                }
            },
                modifier = Modifier
                    .weight(0.5f)
                    .padding(2.dp)) {
                Text("Top")
            }

            Button(onClick = {
                coroutineScope.launch {
                    scrollState.animateScrollTo(scrollState.maxValue)
                }
            }, modifier = Modifier
                .weight(0.5f)
                .padding(2.dp)) {
                Text("Bottom")
            }
        }

        Column(Modifier.verticalScroll(scrollState)) {
            repeat(500) {
                Text(
                    "List Item $it",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(5.dp)
                )
            }
        }
    }
}

@Composable
fun RowList() {
    val scrollState = rememberScrollState()

    Row(Modifier.horizontalScroll(scrollState)) {
        repeat(50) {
            Text("List Item $it",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(5.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun previewList() {
    MyApplicationTheme {
        MyList()
    }
}