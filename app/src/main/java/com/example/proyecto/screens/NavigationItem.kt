package com.example.proyecto.screens

import com.example.proyecto.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("Home", R.drawable.ic_home, "Home")
    object Categories : NavigationItem("Categories", R.drawable.ic_book, "Books")
    object Profile : NavigationItem("Profile", R.drawable.ic_profile, "Profile")
}