package com.jamalmahamoud.me.model


import java.io.Serializable

class Goals(
    val title: String,
    val description: String,
    val steps: List<StepsforPractise>,
    val VideoURI: Int?,
    val rewardPoint: Int,
    val practiseVideo :Int?
):Serializable