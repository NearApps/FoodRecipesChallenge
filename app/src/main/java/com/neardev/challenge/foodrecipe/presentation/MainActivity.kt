package com.neardev.challenge.foodrecipe.presentation

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preloadDataFromDataStore()

        setContent {
            val action: String? = intent?.action
            val data: Uri? = intent?.data
            if (action != null && data != null) {
                val appState = rememberAppState()
                appState.setStartDestination("")
            }

            AppUi(
                backDispatcher = onBackPressedDispatcher
            )
        }
    }

    private fun preloadDataFromDataStore() {
        lifecycleScope.launch {
            //dataStore.data.first()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}