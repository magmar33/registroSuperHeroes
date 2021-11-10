package com.example.registrosuperherores

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Superhero (val etName : String,val etEgo: String,val etBio: String,val rbPoder: Float) : Parcelable {

}