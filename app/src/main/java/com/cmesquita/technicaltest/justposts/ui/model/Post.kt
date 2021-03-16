package com.cmesquita.technicaltest.justposts.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Post(
  private val id: Long?,
  private val title: String?,
  private val body: String?,
  private val user: User
) : Parcelable {

  private fun hasBody() = body == null
}
