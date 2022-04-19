package com.example.proyecto.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyecto.R

private val messages:List<MyMessage> = listOf(
    MyMessage("Plan 1", "Te corto la barba moure"),
    MyMessage("Plan 2", "Te corto la barba moure"),
    MyMessage("Plan 3", "Te corto la barba moure"),
    MyMessage("Plan 4", "Te corto la barba moure"),
    MyMessage("Plan 5", "Te corto la barba moure"),
    MyMessage("Plan 6", "Te corto la barba moure"),
    MyMessage("Plan 7", "Te corto la barba moure"),
    MyMessage("Plan 8", "Te corto la barba moure"),
    MyMessage("Plan 9", "Te corto la barba moure"),
    MyMessage("Plan 10", "Te corto la barba moure"),
    MyMessage("Plan 11", "Te corto la barba moure"),
    MyMessage("Plan 12", "Te corto la barba moure"),
    MyMessage("Plan 13", "Te corto la barba moure"),
    MyMessage("Plan 14", "Te corto la barba moure"),
    MyMessage("Plan 15", "Te corto la barba moure"),
    MyMessage("Plan 16", "Te corto la barba moure"),
    MyMessage("Plan 17", "Te corto la barba moure"),
    MyMessage("Plan 18", "Te corto la barba moure"),
    MyMessage("Plan 19", "Te corto la barba moure"),
    MyMessage("Plan 20", "Te corto la barba moure"),
    MyMessage("Plan 21", "Te corto la barba moure"),
    MyMessage("Plan 22", "Te corto la barba moure"),
    MyMessage("Plan 23", "Te corto la barba moure"),
    MyMessage("Plan 24", "Te corto la barba moure"),
    MyMessage("Plan 25", "Te corto la barba moure"),
    MyMessage("Plan 26", "Te corto la barba moure"),
    MyMessage("Plan 27", "Te corto la barba moure"),
    MyMessage("Plan 28", "Te corto la barba moure")
)
private val catetext:List<String> = listOf(
    "Categoria 1",
    "Categoria 2",
    "Categoria 3",
    "Categoria 4",
    "Categoria 5",
    "Categoria 6",
    "Categoria 7",
    "Categoria 8",
    "Categoria 9",
    "Categoria 10",
    "Categoria 11",
    "Categoria 12",
    "Categoria 13",
    "Categoria 14",
    "Categoria 15",
    "Categoria 16",
    "Categoria 17",
    "Categoria 18"
)

@Composable
fun Categories(navController: NavController) {
    val materialBlue700= Color(0xFF1976D2)
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = { FloatingActionButton(onClick = {}){
            Text("X")
        } },
        drawerContent = { Text(text = "drawerContent") },
        content = { Body() },

        )
}
@Composable
fun Body(){
    Column(modifier = Modifier.padding(start = 8.dp)) {

        MyCates(catetext)
        Spacer(modifier = Modifier.height(10.dp))
        MyMessages(messages)
    }

}
data class MyMessage(val title: String, val body: String)

@Composable
fun MyMessages(messages: List<MyMessage>){
    LazyColumn{
        items(messages){message ->
            MyComponent(message)
        }
    }
}
@Composable
fun MyCates(catetext: List<String>){
    LazyRow(){
        items(catetext){cate ->
            MyCategorie(cate)
        }
    }

}

@Composable
fun MyComponent(message: MyMessage){
    Row(modifier = Modifier
        .background(MaterialTheme.colors.background)
        .padding(8.dp)) {
        MyImage()
        MyTexts(message)
    }
}
@Composable
fun MyCategorie(text:String){
    Column() {
        Image(
            painterResource(R.drawable.ic_launcher_foreground),
            "mi imagen de categoria de prueba",
            modifier = Modifier
                .size(64.dp)
                .clip(RectangleShape)
                .background(MaterialTheme.colors.secondary)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text)
    }
}

@Composable
fun MyImage(){
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        "mi imagen de prueba",
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colors.primary)
    )
}


@Composable
fun MyTexts(message: MyMessage){
    Column(modifier = Modifier.padding(start = 8.dp)) {
        MyText(
            message.title,
            MaterialTheme.colors.primary,
            MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            message.body,
            MaterialTheme.colors.onBackground,
            MaterialTheme.typography.subtitle2
        )
    }
}

@Composable
fun MyText(text: String, color: Color, style: TextStyle){
    Text(text, color = color, style = style)
}