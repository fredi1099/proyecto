package com.example.proyecto

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyecto.ui.theme.ProyectoTheme

@Composable
fun EntrarRegistrar(navController: NavController) {

    figma2android(navController)

}

@Composable
fun figma2android(navController: NavController) {
    //columna para colocar todas las cosas bien una debajo de otra
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(//dentro de las columnas hay cajas como en html , esta caja es solo el color ese grande que hay
            modifier = Modifier
                .width(372.dp)
                .height(400.dp)
                .padding(0.dp, 10.dp, 0.dp, 0.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 50.dp,
                        topEnd = 50.dp,
                        bottomStart = 50.dp,
                        bottomEnd = 50.dp
                    )
                )

                .background(
                    Color(
                        red = 0.970833420753479f,
                        green = 0.6043438911437988f,
                        blue = 0.9341843128204346f,
                    )
                )
        )
        Text(
            text = "Descrubre Tu",
            textAlign = TextAlign.Start,
            fontSize = 30.sp,
            textDecoration = TextDecoration.None,
            letterSpacing = 0.sp,

            overflow = TextOverflow.Ellipsis,
            modifier = Modifier

                .width(190.dp),

                color = Color(
                red = 0.2750000059604645f,
                green = 0.26743754744529724f,
                blue = 0.26743754744529724f,
            ),
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
        )
        Text(
            text = "     Propio Lugar",
            textAlign = TextAlign.Start,
            fontSize = 30.sp,
            textDecoration = TextDecoration.None,
            letterSpacing = 0.sp,

            overflow = TextOverflow.Ellipsis,
            modifier = Modifier

                .width(258.dp),

            //.height(38.dp)
            color = Color(
                red = 0.2750000059604645f,
                green = 0.26743754744529724f,
                blue = 0.26743754744529724f,
            ),
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
        )
        Text(
            text = "Desde aqui podrás descrubrir un nuevo mundo al alcance de tu mano. No dudes en registrarte y formar parte de esta nueva gran comunidad de fiesteros, te esperamos",
            textAlign = TextAlign.Center,
            fontSize = 13.sp,
            textDecoration = TextDecoration.None,
            letterSpacing = 0.sp,

            overflow = TextOverflow.Ellipsis,

            color = Color(red = 0f, green = 0f, blue = 0f),
            fontWeight = FontWeight.Light,
            fontStyle = FontStyle.Normal,

            modifier = Modifier

                .width(332.dp)
                .padding(0.dp, 10.dp, 0.dp, 15.dp)
            //.height(66.dp)

        )



        Button(
            onClick = { navController.navigate(Screen.sign_in.ruta) }, modifier = Modifier
                .width(130.dp)
                .height(50.dp)
                .padding(bottom = 5.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 25.dp,
                        topEnd = 25.dp,
                        bottomStart = 25.dp,
                        bottomEnd = 25.dp
                    )
                )
                .background(
                    Color(
                        red = 0.970833420753479f,
                        green = 0.6043438911437988f,
                        blue = 0.9341843128204346f,
                    )
                )
        ) {
            Text(
                text = "Entrar",
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                textDecoration = TextDecoration.None,
                letterSpacing = 0.sp,

                overflow = TextOverflow.Ellipsis,
                modifier = Modifier

                    .width(200.dp),
                color = Color(red = 1f, green = 1f, blue = 1f),
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal,
            )

        }

        Button(
            onClick = { navController.navigate(Screen.registrarse.ruta) },
            colors = ButtonDefaults.buttonColors(Color.LightGray),
            modifier = Modifier

                .width(130.dp)
                .height(50.dp)
                .padding(top = 5.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 25.dp,
                        topEnd = 25.dp,
                        bottomStart = 25.dp,
                        bottomEnd = 25.dp
                    )
                )
        ) {
            Text(
                text = "Registrar",
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                textDecoration = TextDecoration.None,
                letterSpacing = 0.sp,

                overflow = TextOverflow.Ellipsis,

                color = Color(
                    red = 0.3291666805744171f,
                    green = 0.31737157702445984f,
                    blue = 0.31737157702445984f,
                ),
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Normal,
                modifier = Modifier

                    .width(160.dp)

            )
        }


    }


}




