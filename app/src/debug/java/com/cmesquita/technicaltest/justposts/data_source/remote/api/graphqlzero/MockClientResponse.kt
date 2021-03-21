package com.cmesquita.technicaltest.justposts.data_source.remote.api.graphqlzero

import com.cmesquita.technicaltest.justposts.PostsQuery
import com.cmesquita.technicaltest.justposts.fragment.Post

object MockClientResponse {

    enum class Data1Index {
        DEFAULT,
        NO_TITLE,
        NO_BODY,
        NO_USER_NAME,
        NO_USER_USERNAME,
        NO_USER,
        NO_TITLE_AND_BODY,
        EMPTY_TITLE_AND_BODY,
        BLANK_TITLE_AND_BODY,
    }

    val fakeDefaultData1 = PostsQuery.Data1(
        fragments = PostsQuery.Data1.Fragments(
            Post(
                id = "0",
                title = "Hello World!",
                body = "I love you",
                user = Post.User(
                    name = "Andy",
                    username = "andy_official"
                )
            )
        )
    )

    val fakeDefaultData1List = listOf(
        copyOfDefaultData1(Data1Index.DEFAULT.ordinal.toString()),
        copyOfDefaultData1(Data1Index.NO_TITLE.ordinal.toString(), hasTitle = false),
        copyOfDefaultData1(Data1Index.NO_BODY.ordinal.toString(), hasBody = false),
        copyOfDefaultData1(Data1Index.NO_USER_NAME.ordinal.toString(), hasUserAName = false),
        copyOfDefaultData1(
            Data1Index.NO_USER_USERNAME.ordinal.toString(),
            hasUserAnUsername = false
        ),
        copyOfDefaultData1(Data1Index.NO_USER.ordinal.toString(), hasUser = false),
        copyOfDefaultData1(
            Data1Index.NO_TITLE_AND_BODY.ordinal.toString(),
            hasTitle = false,
            hasBody = false
        ),
        copyOfDefaultData1(
            Data1Index.EMPTY_TITLE_AND_BODY.ordinal.toString(),
            hasEmptyTitle = true,
            hasEmptyBody = true
        ),
        copyOfDefaultData1(
            Data1Index.BLANK_TITLE_AND_BODY.ordinal.toString(),
            hasBlankTitle = true,
            hasBlankBody = true
        ),
    )

    val fakeDefaultClientResponse = PostsQuery.Posts(
        data = fakeDefaultData1List
    )

    private fun copyOfDefaultData1(
        id: String,
        hasTitle: Boolean = true,
        hasEmptyTitle: Boolean = false,
        hasBlankTitle: Boolean = false,
        hasBody: Boolean = true,
        hasEmptyBody: Boolean = false,
        hasBlankBody: Boolean = false,
        hasUser: Boolean = true,
        hasUserAName: Boolean = true,
        hasUserAnUsername: Boolean = true,
    ) = fakeDefaultData1.copy(
        fragments = fakeDefaultData1.fragments.copy(
            post = fakeDefaultData1.fragments.post.copy(
                id = id,
                title = if (hasTitle) {
                    when {
                        hasEmptyTitle -> ""
                        hasBlankTitle -> "  "
                        else -> fakeDefaultData1.fragments.post.title
                    }
                } else {
                    null
                },
                body = if (hasBody) {
                    when {
                        hasEmptyBody -> ""
                        hasBlankBody -> "  "
                        else -> fakeDefaultData1.fragments.post.body
                    }
                } else {
                    null
                },
                user = if (hasUser) {
                    fakeDefaultData1.fragments.post.user!!.copy(
                        name = if (hasUserAName) {
                            fakeDefaultData1.fragments.post.user.name
                        } else {
                            null
                        },
                        username = if (hasUserAnUsername) {
                            fakeDefaultData1.fragments.post.user.username
                        } else {
                            null
                        }
                    )
                } else {
                    null
                },
            )
        )
    )
}
