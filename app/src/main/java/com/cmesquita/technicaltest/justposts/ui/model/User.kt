package com.cmesquita.technicaltest.justposts.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
  private val name: String?,
  private val userName: String?
) : Parcelable {

  private fun isAnonymous() = name == null && userName == null
}
