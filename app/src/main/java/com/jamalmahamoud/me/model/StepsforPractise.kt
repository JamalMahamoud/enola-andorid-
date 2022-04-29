package com.jamalmahamoud.me.model

import java.io.Serializable

class StepsforPractise(
    val title: String,
    val des: String,
    val time: Int,
    var didIt: Boolean,
    val video: Int?
) : Serializable