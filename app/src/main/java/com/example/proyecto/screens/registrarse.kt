package com.example.proyecto

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun registrarse(navController: NavController){
    Surface(color = Color.White, modifier = Modifier
        .padding()
        .fillMaxSize()) {
        Box( //background para el fondo
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                regis(navController)
                registrar(navController)

            }
        }
    }

}

@Composable
fun regis(navController: NavController) { //aqui dentro va la parte de arriba de bienvenido, inicia sensicon, lo de google...


    Text(
        text = "Crea tu cuenta",
        color = Color.Black,
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Start,
        lineHeight = 44.sp,
        style = TextStyle(
            fontSize = 36.sp
        )
    )
    Text(
        text = "Registrate con:",
        color = Color.Black,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Start,
        lineHeight = 29.sp,
        style = TextStyle(
            fontSize = 18.sp
        )
    )


    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        modifier = Modifier
            .size(width = 140.dp, height = 50.dp)
            .padding(top = 15.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.google),
            contentDescription = "google",
            modifier = Modifier
                .size(size = 25.dp)
        )
        Spacer(
            modifier = Modifier
                .width(width = 8.dp)
        )
        Text(
            text = "Google",
            color = Color.Black,
            textAlign = TextAlign.Start,
            fontFamily = FontFamily.Serif,
            lineHeight = 44.sp,
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            )
        )
    }
    Row(modifier = Modifier.padding(20.dp)) {
        Image(
            painter = painterResource(id = R.drawable.linea),
            contentDescription = "Vector 12",
            modifier = Modifier
                .padding(all = 1.dp)
                .width(width = 80.dp)
        )
        Text(
            text = "Rellenar datos",
            color = Color.Black,
            textAlign = TextAlign.Start,
            lineHeight = 15.sp,
            style = TextStyle(
                fontSize = 13.sp
            )
        )
        Image(
            painter = painterResource(id = R.drawable.linea),
            contentDescription = "Vector 12",
            modifier = Modifier
                .padding(all = 1.dp)
                .width(width = 80.dp)
        )
    }


}


@Composable
fun registrar(navController: NavController) {
    var name by remember { mutableStateOf("") }
    OutlinedTextField(
        // colors = TextFieldDefaults.textFieldColors(
        // textColor = Color.Gray,
        //disabledTextColor = Color.Transparent,

        // backgroundColor = Color.White,
        //focusedIndicatorColor = Color.Transparent,
        //disabledIndicatorColor = Color.Transparent,
        //unfocusedIndicatorColor = Color.Transparent
        //),
        modifier = Modifier
            .border(width = 0.dp, Color.Transparent),
        value = name,
        onValueChange = { name = it },

        label = { Text("Nombre") },

        )

    var correo by remember { mutableStateOf("") }
    OutlinedTextField(
        // colors = TextFieldDefaults.textFieldColors(
        // textColor = Color.Gray,
        //disabledTextColor = Color.Transparent,
        // backgroundColor = Color.White,
        //focusedIndicatorColor = Color.Transparent,
        //disabledIndicatorColor = Color.Transparent,
        //unfocusedIndicatorColor = Color.Transparent
        //),
        modifier = Modifier
            .padding(top = 5.dp)
            .border(width = 0.dp, Color.Transparent),
        value = correo,
        onValueChange = { correo = it },

        label = { Text("Correo") },

        )


    var password by remember { mutableStateOf("") }
    var password2 by remember { mutableStateOf("") }
    var hidden by remember { mutableStateOf(true) }
    var hidden2 by remember { mutableStateOf(true) }



    OutlinedTextField(//colors = TextFieldDefaults.textFieldColors( //aqui aplico esto para que se quite un fondo raro que sale en el textfield
        // textColor = Color.Gray,
        //disabledTextColor = Color.Transparent,
        //backgroundColor = Color.White,
        //focusedIndicatorColor = Color.Transparent,
        //disabledIndicatorColor = Color.Transparent,
        // unfocusedIndicatorColor = Color.Transparent
        //  ),
        modifier = Modifier
            .padding(top = 5.dp)
            .border(width = 0.dp, Color.Transparent),
        value = password,
        onValueChange = { password = it }, //va guardando cada estado del value con un iterador
        label = { Text("Contrase??a") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),//2
        singleLine = true,
        visualTransformation =
        if (hidden) PasswordVisualTransformation() else VisualTransformation.None,//3
        trailingIcon = {// 4
            IconButton(onClick = { hidden = !hidden }) {
                val vector = painterResource(//5
                    if (hidden) R.drawable.ic_visibility
                    else R.drawable.ic_visibility_off
                )
                val description = if (hidden) "Ocultar contrase??a" else "Revelar contrase??a" //6
                Icon(painter = vector, contentDescription = description)
            }
        }
    )

    OutlinedTextField(
        modifier = Modifier
            .padding(top = 5.dp)
            .border(width = 0.dp, Color.Transparent),
        value = password2,
        onValueChange = { password2 = it }, //va guardando cada estado del value con un iterador
        label = { Text("Confirmar Contrase??a") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),//2
        singleLine = true,
        visualTransformation =
        if (hidden2) PasswordVisualTransformation() else VisualTransformation.None,//3
        trailingIcon = {// 4
            IconButton(onClick = { hidden2 = !hidden2 }) {
                val vector = painterResource(//5
                    if (hidden2) R.drawable.ic_visibility
                    else R.drawable.ic_visibility_off
                )
                val description = if (hidden2) "Ocultar contrase??a" else "Revelar contrase??a" //6
                Icon(painter = vector, contentDescription = description)
            }
        }
    )
    var content = LocalContext.current
    Button(
        onClick = {
            if (name.isNotEmpty() && correo.isNotEmpty() && password.isNotEmpty() && password2.isNotEmpty()) {
                if (password == password2) {

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(correo, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                navController.navigate(Screen.sign_in.ruta)

                            } else {
                                if (password.length < 6) {
                                    Toast.makeText(
                                        content, "Contrase??a m??nima 6 caracteres",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else {
                                    Toast.makeText(
                                        content, "Datos Incorrectos",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }

                } else {
                    Toast.makeText(
                        content, "Contrase??as no coinciden",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    content, "Rellene los campos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        },
        colors = ButtonDefaults.buttonColors(Color.LightGray),
        modifier = Modifier
            .padding(top = 25.dp)
            .clip(RoundedCornerShape(25.dp))
            .size(width = 120.dp, height = 40.dp)
    ) {

        Text(
            text = "Registrar",
            color = Color(0xff5a5a5a),
            textAlign = TextAlign.Start,
            lineHeight = 15.sp,
            style = TextStyle(
                fontSize = 18.sp
            )
        )
    }
}




