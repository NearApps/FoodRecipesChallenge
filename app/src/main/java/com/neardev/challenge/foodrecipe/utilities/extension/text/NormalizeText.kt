package com.neardev.challenge.foodrecipe.utilities.extension.text

import java.text.Normalizer
import java.util.*

fun String.normalizeText(): String {
    val temp = Normalizer.normalize(lowercase(Locale.US), Normalizer.Form.NFD)
    return REGEX_UNACCENT.replace(temp, "")
}

private val REGEX_UNACCENT = "\\p{InCombiningDiacriticalMarks}+".toRegex()