package com.cmesquita.technicaltest.justposts.ui.model

object MockUiModels {

    enum class PostIndex {
        DEFAULT,
        NO_TITLE,
        NO_BODY,
        NO_USER_NAME,
        NO_USER_USERNAME,
        NO_USER,
    }

    val fakeDefaultUiPost = Post(
        id = 0,
        title = "Hello World!",
        body = "I love you",
        user = User(
            name = "Andy",
            userName = "andy_official"
        )
    )

    val fakeDefaultUiPostList = listOf(
        copyOfDefaultUiPost(PostIndex.DEFAULT.ordinal.toLong()),
        copyOfDefaultUiPost(PostIndex.NO_TITLE.ordinal.toLong(), hasTitle = false),
        copyOfDefaultUiPost(PostIndex.NO_BODY.ordinal.toLong(), hasBody = false),
        copyOfDefaultUiPost(PostIndex.NO_USER_NAME.ordinal.toLong(), hasUserAName = false),
        copyOfDefaultUiPost(
            PostIndex.NO_USER_USERNAME.ordinal.toLong(),
            hasUserAnUsername = false
        ),
        copyOfDefaultUiPost(
            PostIndex.NO_USER.ordinal.toLong(),
            hasUserAName = false,
            hasUserAnUsername = false
        ),
    )

    private fun copyOfDefaultUiPost(
        id: Long,
        hasTitle: Boolean = true,
        hasBody: Boolean = true,
        hasUserAName: Boolean = true,
        hasUserAnUsername: Boolean = true,
    ) = fakeDefaultUiPost.copy(
        id = id,
        title = if (hasTitle) {
            fakeDefaultUiPost.title
        } else {
            null
        },
        body = if (hasBody) {
            fakeDefaultUiPost.body
        } else {
            null
        },
        user = fakeDefaultUiPost.user.copy(
            name = if (hasUserAName) {
                fakeDefaultUiPost.user.name
            } else {
                null
            },
            userName = if (hasUserAnUsername) {
                fakeDefaultUiPost.user.userName
            } else {
                null
            }
        ),
    )
}