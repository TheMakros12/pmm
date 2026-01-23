package com.example.barralateral

import android.content.Context
import android.media.MediaPlayer

class SoundPlayer(private val context: Context) {
    fun reproducirSonido(snd: Int){
        try {
            val mediaPlayer = MediaPlayer.create(context, snd)
            mediaPlayer?.apply {
                setVolume(0.5f, 0.5f)
                start()
                setOnCompletionListener {
                    release()
                }
            }
        }catch (exc: Exception) {
            exc.printStackTrace()
        }
    }
}