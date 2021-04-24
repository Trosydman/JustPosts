package com.cmesquita.technicaltest.justposts.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes

object Shapes {
    val JustPostsShapes = Shapes(
        small = RoundedCornerShape(Dimens.SmallCornerSize),
        medium = RoundedCornerShape(Dimens.MediumCornerSize),
        large = RoundedCornerShape(Dimens.LargeCornerSize)
    )
}
