package com.ivanbarbosa.toptunes.utils

import com.ivanbarbosa.toptunes.enity.Image
import java.text.NumberFormat
import java.util.*

/* 
* Project: TopTunes
* From: com.ivanbarbosa.toptunes.utils
* Create by Ivan Barbosa on 15/06/2023 at 10:20 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/
object Validations {
    fun separateDigits(number: Int): String {
        val formatter = NumberFormat.getNumberInstance(Locale.US)
        return formatter.format(number)
    }

    fun getImageUrlBySize(images: List<Image>, targetSize: String): String? {
        if (images.isNotEmpty()) {
            for (image in images) {
                if (image.size == targetSize) {
                    return image.text
                }
            }
        }
        return null
    }
}