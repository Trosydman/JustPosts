package com.cmesquita.technicaltest.justposts.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Post(
  val id: Long?,
  val title: String?,
  val body: String?,
  val user: User
) : Parcelable {

  fun hasTitle() = title != null
  fun hasBody() = body != null
}
