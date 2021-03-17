package com.cmesquita.technicaltest.justposts.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
  val name: String?,
  val userName: String?
) : Parcelable {

  fun isAnonymous() = name == null && userName == null
}
