package com.neardev.challenge.foodrecipe

import android.app.Application
import com.neardev.challenge.foodrecipe.domain.utilities.KLog
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application(){
    override fun onCreate() {
        super.onCreate()
        initDebugLogs()
        initFirebase()
        initClarity()
    }

    private fun initDebugLogs() {
        KLog.launch(BuildConfig.DEBUG)
    }

    private fun initFirebase() {
        //FirebaseApp.initializeApp(this)
        //subscribeToTopicUseCase(TOPIC_NEW_AUDIO)
    }
    private fun initClarity() {
        //val config = ClarityConfig(BuildConfig.CLARITY_PROJECT_ID)
        //Clarity.initialize(applicationContext, config)
    }
}