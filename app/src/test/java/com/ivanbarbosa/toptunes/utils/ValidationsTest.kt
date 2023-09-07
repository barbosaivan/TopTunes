package com.ivanbarbosa.toptunes.utils

import com.ivanbarbosa.toptunes.entities.Image
import org.junit.Assert.*

import org.junit.Test

/* 
* Project: TopTunes
* From: com.ivanbarbosa.toptunes.utils
* Create by Ivan Barbosa on 14/08/2023 at 9:08 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/
class ValidationsTest {

    @Test
    fun validateSeparateDigitsTest() {
        val number = 78569326
        val result = Validations.separateDigits(number)
        assertEquals(result, "78,569,326")
    }

    @Test
    fun validateGetImageUrlBySizeTest() {
        val images = listOf(
            Image("urlimage1.com", "medium"),
            Image("urlimage2.com", "large")
        )
        val result = Validations.getImageUrlBySize(images, "medium")
        assertEquals(result, "urlimage1.com")
    }

    @Test
    fun validateGetImageUrlBySizeTestNull() {
        val images = listOf(
            Image("urlimage1.com", "medium"),
            Image("urlimage2.com", "large")
        )
        val result = Validations.getImageUrlBySize(images, "small")
        assertNull(result)
    }

    @Test
    fun validateGetImageUrlBySizeTestEmpty() {
        val image = emptyList<Image>()
        val result = Validations.getImageUrlBySize(image, "large")
        assertNull(result)
    }
}