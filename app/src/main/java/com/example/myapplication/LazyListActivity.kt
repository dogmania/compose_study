package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class LazyListActivity : ComponentActivity() {
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

val phones = listOf("Apple iPhone 12", "Google Pixel 4", "Samsung Galaxy 6s",
    "Apple iPhone 7", "Google Pixel 6", "OnePlus 7", "OnePlus 9 Pro", "Samsung Galaxy Z Flip",
    "Apple iPhone 13", "Google Pixel 4a", "Apple iPhone 8")

@Composable
fun MyListItem(model: String) {
    Text(model, color = Color.White)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyColumnExample() {
    val groupedPhones = phones.groupBy {it.substringBefore(' ')}
    val listState = rememberLazyListState()

    LazyColumn(state = listState) {
        groupedPhones.forEach { (manufacturer, models) ->
            stickyHeader {
                Text(
                    text = manufacturer,
                    color = Color.White,
                    modifier = Modifier
                        .background(Color.Gray)
                        .padding(5.dp)
                        .fillMaxWidth()
                )
            }

            items(models) {model ->
                MyListItem(model)
            }
        }
    }
}

@Composable
fun LazyVerticalGridExample() {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 80.dp),
        state = rememberLazyGridState(),
        contentPadding = PaddingValues(10.dp)
    ) {
        items(30) { index ->
            Card(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxSize()
            ) {
                Text(
                    "$index",
                    fontSize = 35.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Blue),
                )
            }
        }
    }
}

@Composable
fun LazyVerticalGridExample2() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        state = rememberLazyGridState(),
        contentPadding = PaddingValues(10.dp)
    ) {
        items(30) { index ->
            Card(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxSize()
            ) {
                Text(
                    "$index",
                    fontSize = 35.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Blue),
                )
            }
        }
    }
}

@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(15.dp)
        ) {
            Text("Jetpack Compose", fontSize = 30.sp)
            Text("Card Example", fontSize = 20.sp)
        }
    }
}

@Preview
@Composable
fun LazyListPreview() {
    MyApplicationTheme {
        MyCard()
    }
}