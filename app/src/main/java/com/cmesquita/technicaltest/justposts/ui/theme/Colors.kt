package com.cmesquita.technicaltest.justposts.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

object Colors {
    val White50 = Color(0xFFffffff)

    val Black800 = Color(0xFF121212)
    val Black900 = Color(0xFF000000)

    val Blue50 = Color(0xFFeef0f2)
    val Blue100 = Color(0xFFd2dbe0)
    val Blue200 = Color(0xFFadbbc4)
    val Blue300 = Color(0xFF8ca2ae)
    val Blue600 = Color(0xFF4a6572)
    val Blue700 = Color(0xFF344955)
    val Blue800 = Color(0xFF232f34)

    val Orange300 = Color(0xFFfbd790)
    val Orange400 = Color(0xFFf9be64)
    val Orange500 = Color(0xFFf9aa33)

    val Red200 = Color(0xFFcf7779)
    val Red400 = Color(0xFFff4c5d)

    val Transparent_Black900 = Black900.copy(alpha = 0f)
    val Transparent_White50 = White50.copy(alpha = 0f)

    val White50_Alpha060 = White50.copy(alpha = 0.6f)

    val Blue50_Alpha060 = Blue50.copy(alpha = 0.6f)

    val Black900_Alpha087 = Black900.copy(alpha = 0.87f)

    val JustPostsLightColors = lightColors(
        primary = Blue700,
        primaryVariant = Blue800,
        secondary = Orange500,
        secondaryVariant = Orange400,
        background = Blue50,
        surface = White50,
        error = Red400,
        onPrimary = White50,
        onSecondary = Black900,
        onBackground = Black900,
        onSurface = Black900,
        onError = Black900,
    )

    val JustPostsDarkColors = darkColors(
        primary = Blue200,
        primaryVariant = Blue300,
        secondary = Orange300,
        secondaryVariant = Orange300,
        background = Black900,
        surface = Black800,
        error = Red200,
        onPrimary = Black900,
        onSecondary = Black900,
        onBackground = White50,
        onSurface = White50,
        onError = Black900,
    )
}
