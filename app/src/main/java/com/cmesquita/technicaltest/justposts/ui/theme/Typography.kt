package com.cmesquita.technicaltest.justposts.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object Typography {
    val WorkSansTypography = Typography(
        h1 = Typography().h1.copy(
            fontFamily = FontFamily.WorkSans,
            fontWeight = FontWeight.SemiBold,
        ),
        h2 = Typography().h2.copy(
            fontFamily = FontFamily.WorkSans,
            fontWeight = FontWeight.SemiBold,
        ),
        h3 = Typography().h3.copy(
            fontFamily = FontFamily.WorkSans,
            fontWeight = FontWeight.Bold,
        ),
        h4 = Typography().h4.copy(
            fontFamily = FontFamily.WorkSans,
            fontWeight = FontWeight.Bold,
        ),
        h5 = Typography().h5.copy(
            fontFamily = FontFamily.WorkSans,
            fontWeight = FontWeight.Bold,
        ),
        h6 = Typography().h6.copy(
            fontFamily = FontFamily.WorkSans,
            fontWeight = FontWeight.Bold,
        ),
        subtitle1 = Typography().subtitle1.copy(
            fontFamily = FontFamily.WorkSans,
        ),
        subtitle2 = Typography().subtitle2.copy(
            fontFamily = FontFamily.WorkSans,
            fontWeight = FontWeight.Medium,
        ),
        body1 = Typography().body1.copy(
            fontFamily = FontFamily.WorkSans,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp,
        ),
        body2 = Typography().body2.copy(
            fontFamily = FontFamily.WorkSans,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
        ),
        button = Typography().button.copy(
            fontFamily = FontFamily.WorkSans,
            fontWeight = FontWeight.Medium,
            // TODO textAllCaps = false
        ),
        caption = Typography().caption.copy(
            fontFamily = FontFamily.WorkSans,
            fontWeight = FontWeight.Normal,
        ),
        overline = Typography().overline.copy(
            fontFamily = FontFamily.WorkSans,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            // TODO textAllCaps = true
        ),
    )
}
