package com.cmesquita.technicaltest.justposts.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.cmesquita.technicaltest.justposts.R

object FontFamily {
    val WorkSans = FontFamily(
        Font(R.font.work_sans, FontWeight.Normal),
        Font(R.font.work_sans_bold, FontWeight.Bold),
        Font(R.font.work_sans_extrabold, FontWeight.ExtraBold),
        Font(R.font.work_sans_medium, FontWeight.Medium),
        Font(R.font.work_sans_semibold, FontWeight.SemiBold),
    )
}
