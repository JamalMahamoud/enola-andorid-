package com.jamalmahamoud.me

import com.jamalmahamoud.me.model.Checkins
import com.jamalmahamoud.me.model.Emotions
import com.jamalmahamoud.me.model.Entries

class MeeSystem {

    companion object {
        val checkins = mutableListOf<Checkins>()
        val emotions = mutableListOf<Emotions>()
        val diaries = mutableListOf<Entries>()

        fun addcheckins(checkin: Checkins) {
            checkins.add(checkin)
        }

        fun addEmotions(emotion: Emotions) {
            emotions.add(emotion)
        }

        fun addDiaries(diary: Entries) {
            diaries.add(diary)
        }

        fun getCheckings() = checkins

        fun  getDairies()= diaries










    }
}