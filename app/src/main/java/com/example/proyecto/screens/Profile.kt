package com.example.proyecto.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.proyecto.models.Profile
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Place
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.example.proyecto.models.Event




var profile:Profile = Profile(
    "Pepe",
    "Malaga",
    "petito@.com",
    "Discoteca"
)

var myEvents:List<Event> = listOf(
    Event(
        "1",
        "",
        "fieston",
        "7/4",
        12,
        5,
        18,
        "malaga",
        listOf("nocturno","discoteca")
    ),
    Event(
        "2",
        "",
        "fieston",
        "7/4",
        12,
        5,
        18,
        "malaga",
        listOf("nocturno","discoteca")
    ),
    Event(
        "3",
        "",
        "fieston",
        "7/4",
        12,
        5,
        18,
        "malaga",
        listOf("nocturno","discoteca")
    ),
    Event(
        "4",
        "",
        "fieston",
        "7/4",
        12,
        5,
        18,
        "malaga",
        listOf("nocturno","discoteca")
    ),
)

@Composable
fun Image(img: String, modifier: Modifier){

}

@Composable
fun Text(string: String, color: Color, style: TextStyle, modifier: Modifier) {
    Text(
        text = string,
        color = color,
        style = style,
        modifier = modifier
    )
}

@Composable
fun HeadProfile() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            "",
            Modifier
                .size(128.dp)
                .clip(CircleShape))
        Column() {
            Text(
                profile.name,
                MaterialTheme.colors.primaryVariant,
                MaterialTheme.typography.subtitle1,
                Modifier.padding(top = 10.dp, start = 10.dp)
            )
            Row() {
                Icon(
                    Icons.Rounded.Place, contentDescription = "Localized description",
                    Modifier.padding(top = 8.dp, start = 8.dp))
                Text(
                    profile.loacalitation,
                    MaterialTheme.colors.primaryVariant,
                    MaterialTheme.typography.subtitle1,
                    Modifier.padding(top = 10.dp, start = 4.dp)
                )
            }
            Text(
                profile.profileGoogle,
                MaterialTheme.colors.primaryVariant,
                MaterialTheme.typography.subtitle1,
                Modifier.padding(top = 10.dp, start = 10.dp)
            )
            Text(
                profile.description,
                MaterialTheme.colors.primaryVariant,
                MaterialTheme.typography.subtitle1,
                Modifier.padding(top = 10.dp, start = 10.dp)
            )
        }
    }
}

@Composable
fun MyEvent(event:Event){
    Card(
        Modifier
            .padding(top = 32.dp)
            .width(300.dp)) {
        Column() {
            Image(event.img, Modifier.size(300.dp))
            Text(
                event.title,
                MaterialTheme.colors.primaryVariant,
                MaterialTheme.typography.subtitle1,
                Modifier.padding(top = 16.dp, start = 10.dp)
            )
            Text(
                event.price.toString(),
                MaterialTheme.colors.primaryVariant,
                MaterialTheme.typography.subtitle1,
                Modifier.padding(top = 16.dp, start = 10.dp)
            )
            Text(
                event.minimumAge.toString(),
                MaterialTheme.colors.primaryVariant,
                MaterialTheme.typography.subtitle1,
                Modifier.padding(top = 16.dp, start = 10.dp)
            )
            Text(
                event.localitation.toString(),
                MaterialTheme.colors.primaryVariant,
                MaterialTheme.typography.subtitle1,
                Modifier.padding(top = 16.dp, start = 10.dp)
            )
            Row(
                Modifier
                    .padding(top = 16.dp, bottom = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { delete() },
                    Modifier.padding(end = 4.dp)
                ) {
                    Text("Delete")
                }
                Button(
                    onClick = { update() },
                    Modifier.padding(end = 4.dp)
                ) {
                    Text("Update")
                }
                Button(
                    onClick = { viewMore() },
                ) {
                    Text("View More")
                }
            }
        }
    }
}

private fun delete(){}
private fun update(){}
private fun viewMore(){}

@Composable
fun MyEvents(){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        items(myEvents){ event->
            MyEvent(event)
        }
        item { Text("dfd") }
    }
}

@Composable
fun BodyProfile(){
    BoxWithConstraints() {
        val boxHeight = this.maxHeight
        MyEvents()
        Column {
            Spacer(modifier = Modifier
                .height(boxHeight-32.dp)
            )
        }
    }
}

@Composable
fun Profile(navController: NavController){
    Column {
        HeadProfile()
        BodyProfile()
    }
}