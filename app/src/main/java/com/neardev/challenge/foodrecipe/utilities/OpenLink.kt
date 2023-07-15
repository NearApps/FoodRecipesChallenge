package com.neardev.challenge.foodrecipe.utilities

import android.content.Context
import android.content.Intent
import android.net.Uri

fun openLink(
    context: Context,
    url: String
) {
    context.startActivity(
        Intent(Intent.ACTION_VIEW, Uri.parse(url))
    )
}