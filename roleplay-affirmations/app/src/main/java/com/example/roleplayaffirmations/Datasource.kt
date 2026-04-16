package com.example.roleplayaffirmations.data

import com.example.roleplayaffirmations.R
import com.example.roleplayaffirmations.model.Affirmation

class Datasource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf(
            // Generic
            Affirmation(R.string.affirmation1, R.drawable.barbarian_grog),
            Affirmation(R.string.affirmation2, R.drawable.barbarian_grog_2),
            Affirmation(R.string.affirmation3, R.drawable.barbarian_karlach),
            Affirmation(R.string.affirmation4, R.drawable.barbarian_karlach_2),
            Affirmation(R.string.affirmation5, R.drawable.barbarian_tormund),
            // Monk
            Affirmation(R.string.monk1, R.drawable.monk1),
            Affirmation(R.string.monk2, R.drawable.monk2),
            Affirmation(R.string.monk3, R.drawable.monk3),
            Affirmation(R.string.monk4, R.drawable.monk4),
            Affirmation(R.string.monk5, R.drawable.monk5),
            // Shaman
            Affirmation(R.string.shaman1, R.drawable.shaman1),
            Affirmation(R.string.shaman2, R.drawable.shaman2),
            Affirmation(R.string.shaman3, R.drawable.shaman3),  // note: typo in strings.xml is intentional here
            Affirmation(R.string.shaman4, R.drawable.shaman4),
            Affirmation(R.string.shaman5, R.drawable.shaman5),
            // Barbarian
            Affirmation(R.string.barbarian1, R.drawable.barbarian_grog),
            Affirmation(R.string.barbarian2, R.drawable.barbarian_grog_2),
            Affirmation(R.string.barbarian3, R.drawable.barbarian_karlach),
            Affirmation(R.string.barbarian4, R.drawable.barbarian_karlach_2),
            Affirmation(R.string.barbarian5, R.drawable.barbarian_tormund),
            // NoHo Hank
            Affirmation(R.string.nohohank1, R.drawable.nohohank),
        )
    }
}