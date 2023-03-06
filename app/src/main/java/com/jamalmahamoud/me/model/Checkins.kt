package com.jamalmahamoud.me.model

import android.icu.util.Calendar
import org.tensorflow.lite.examples.textclassification.client.Result
import java.io.Serializable
import java.util.*

data class Checkins(
    val date: Date, val emotions: Emotions, val rate: Int?,
    var feelings: String?, var result: List<Result>? ):Serializable
