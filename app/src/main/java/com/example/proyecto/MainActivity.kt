package com.example.proyecto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.proyecto.screens.Categories
import com.example.proyecto.screens.Home
import com.example.proyecto.screens.Profile
import com.example.proyecto.screens.NavigationItem

sealed class Screen(val ruta: String) {
    object EntrarRegistrar : Screen("EntrarRegistrar")
    object registrarse : Screen("registrarse")
    object sign_in : Screen("sign_in")
    object Home : Screen("Home")
    object Categories : Screen("Categories")
    object Profile : Screen("Profile")

}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navegacion()
        }
    }
}

@Composable
fun navegacion() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.EntrarRegistrar.ruta) {
        composable(Screen.EntrarRegistrar.ruta) {
            EntrarRegistrar(navController = navController)
        }
        composable(Screen.registrarse.ruta) {
            registrarse(navController = navController)
        }
        composable(Screen.sign_in.ruta) {
            sign_in(navController = navController)
        }

        composable(Screen.Home.ruta) {
            Scaffold(
                topBar = { TopBar(navController) },
                bottomBar = { BottonBar(navController) }
            ) {
                Home(navController = navController)
            }

        }
        composable(Screen.Categories.ruta) {
            Scaffold(
                topBar = { TopBar(navController) },
                bottomBar = { BottonBar(navController) }
            ) {
                Categories(navController = navController)
            }


        }
        composable(Screen.Profile.ruta) {
            Scaffold(
                topBar = { TopBar(navController) },
                bottomBar = { BottonBar(navController) }
            ) {
                Profile(navController = navController)
            }
        }
    }

}


@Composable
fun TopBar(navController: NavHostController) {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp) },
        backgroundColor = Color.Red,
        contentColor = Color.White
    )
}

@Composable
fun BottonBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Categories,
        NavigationItem.Profile
    )
    BottomNavigation(
        backgroundColor = Color.Red,
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}