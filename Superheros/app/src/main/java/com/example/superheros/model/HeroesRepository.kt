package com.example.superheros.model

import com.example.superheros.R

object HeroesRepository {
    val heroes = listOf(
        Hero(
            nameRes = R.string.prof_x,
            descriptionRes = R.string.profDesc,
            imageRes = R.drawable.android_superhero1
        ),
        Hero(
            nameRes = R.string.wolverine,
            descriptionRes = R.string.wolfDesc,
            imageRes = R.drawable.android_superhero2
        ),
        Hero(
            nameRes = R.string.storm,
            descriptionRes = R.string.stormDesc,
            imageRes = R.drawable.android_superhero6
        ),
        Hero(
            nameRes = R.string.gambit,
            descriptionRes = R.string.gambitDesc,
            imageRes = R.drawable.android_superhero3
        ),
        Hero(
            nameRes = R.string.rogue,
            descriptionRes = R.string.rogueDesc,
            imageRes = R.drawable.android_superhero5
        ),
        Hero(
            nameRes = R.string.beast,
            descriptionRes = R.string.beastDesc,
            imageRes = R.drawable.android_superhero4
        )
    )
}