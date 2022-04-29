package com.jamalmahamoud.me.model

import android.graphics.Color
import android.media.Image
import java.io.Serializable

data class Emotions(
    val title: String,
    val color: Int,
    val img: Int
        ): Serializable