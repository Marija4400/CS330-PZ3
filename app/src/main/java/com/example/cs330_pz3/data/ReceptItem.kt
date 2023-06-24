package com.example.cs330_pz3.data

data class ReceptItem(
    val difficulty: String,
    val id: String,
    val image: String,
    val kalorije: String,
    val naziv: String,
    val sastojci: List<String>,
    val vreme_pripreme: String,
    val nacinPripreme: String
)