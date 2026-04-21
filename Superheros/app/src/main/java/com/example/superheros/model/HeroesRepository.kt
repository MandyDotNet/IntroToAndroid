package com.example.superheros.model

import com.example.superheros.R

object HeroesRepository {
    val heroes = listOf(
        Hero(
            nameRes = R.string.hero1,
            descriptionRes = R.string.description1,
        ),
        Hero(),
        Hero(),
        Hero()
    )
}