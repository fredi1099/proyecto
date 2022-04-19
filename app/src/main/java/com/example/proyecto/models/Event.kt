package com.example.proyecto.models

    data class Event(
        val id:String,
        val img:String,
        val title:String,
        val date: String,
        val price:Number,
        val drinkPrice:Number,
        val minimumAge:Number,
        val localitation:String,
        val tags:List<String>
    )
