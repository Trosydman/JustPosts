package com.cmesquita.technicaltest.justposts.ui.post_details

import android.content.Context
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.MediumTest
import com.cmesquita.technicaltest.justposts.R
import com.cmesquita.technicaltest.justposts.launchFragmentInHiltContainer
import com.cmesquita.technicaltest.justposts.ui.model.MockUiModels
import com.cmesquita.technicaltest.justposts.ui.model.Post
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@MediumTest
@HiltAndroidTest
class PostDetailsFragmentTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    private lateinit var postInBundle: Post

    @StringRes
    private val noPostTitleMessageID = R.string.message_no_post_title

    @StringRes
    private val noPostBodyMessageID = R.string.message_no_post_body

    @StringRes
    private val anonymousPostMessageID = R.string.message_anonymous_author

    @Test
    fun clickOnNavigationButton_thenPopBackStack() {
        val navController = mock(NavController::class.java)
        launchPostDetailsFragment(navController)

        // If navigation icon is clicked...
        onView(withId(R.id.navigation_icon)).perform(click())

        // ... then it should go back to the previous fragment.
        verify(navController).popBackStack()
    }

    @Test
    fun bundleWithDefaultPost_showsAllInformation() {
        val navController = mock(NavController::class.java)
        val post = getPostBy(MockUiModels.PostIndex.DEFAULT.ordinal)

        // If default post is shared to the fragment...
        launchPostDetailsFragment(navController, post)

        // ... then the post's title, user and body should be displayed.
        onView(withId(R.id.post_title)).check(matches(withText(postInBundle.title)))
        onView(withId(R.id.post_author_name)).check(matches(withText(postInBundle.user.name)))
        onView(withId(R.id.post_author_userName)).check(matches(withText(postInBundle.user.userName)))
        onView(withId(R.id.post_body)).check(matches(withText(postInBundle.body)))
    }

    @Test
    fun bundleWithPostWithoutTitle_showsAllInformationAndNoPostTitleMessage() {
        val navController = mock(NavController::class.java)
        val post = getPostBy(MockUiModels.PostIndex.NO_TITLE.ordinal)
        val noTitleMessage = getApplicationContext<Context>().getString(noPostTitleMessageID)

        // If post without title is shared to the fragment...
        launchPostDetailsFragment(navController, post)

        // ... then the post title should show a special no-title message ...
        onView(withId(R.id.post_title)).check(matches(withText(noTitleMessage)))

        // ... but the post user and body should be displayed.
        onView(withId(R.id.post_author_name)).check(matches(withText(postInBundle.user.name)))
        onView(withId(R.id.post_author_userName)).check(matches(withText(postInBundle.user.userName)))
        onView(withId(R.id.post_body)).check(matches(withText(postInBundle.body)))
    }

    @Test
    fun bundleWithPostWithoutBody_showsAllInformationAndNoPostBodyMessage() {
        val navController = mock(NavController::class.java)
        val post = getPostBy(MockUiModels.PostIndex.NO_BODY.ordinal)
        val noBodyMessage = getApplicationContext<Context>().getString(noPostBodyMessageID)

        // If post without body is shared to the fragment..
        launchPostDetailsFragment(navController, post)

        // ... then the post body should show a special no-body message ...
        onView(withId(R.id.post_body)).check(matches(withText(noBodyMessage)))

        // ... but the post title and user should be displayed.
        onView(withId(R.id.post_title)).check(matches(withText(postInBundle.title)))
        onView(withId(R.id.post_author_name)).check(matches(withText(postInBundle.user.name)))
        onView(withId(R.id.post_author_userName)).check(matches(withText(postInBundle.user.userName)))
    }

    @Test
    fun bundleWithPostWithoutUsersName_showsAllInformationExceptUsersName() {
        val navController = mock(NavController::class.java)
        val post = getPostBy(MockUiModels.PostIndex.NO_USER_NAME.ordinal)

        // If post without user's name is shared to the fragment..
        launchPostDetailsFragment(navController, post)

        // ... then users's name is hidden, but at least the user's username should show ...
        onView(withId(R.id.post_author_name)).check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.post_author_userName)).check(matches(withText(postInBundle.user.userName)))

        // ... in addition the post title and body should be displayed.
        onView(withId(R.id.post_title)).check(matches(withText(postInBundle.title)))
        onView(withId(R.id.post_body)).check(matches(withText(postInBundle.body)))
    }

    @Test
    fun bundleWithPostWithoutUsersUserName_showsAllInformationExceptUsersUserName() {
        val navController = mock(NavController::class.java)
        val post = getPostBy(MockUiModels.PostIndex.NO_USER_USERNAME.ordinal)

        // If post without user's name is shared to the fragment..
        launchPostDetailsFragment(navController, post)

        // ... then users's username is hidden, but at least the user's name should show ...
        onView(withId(R.id.post_author_userName)).check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.post_author_name)).check(matches(withText(postInBundle.user.name)))

        // ... in addition the post title and body should be displayed.
        onView(withId(R.id.post_title)).check(matches(withText(postInBundle.title)))
        onView(withId(R.id.post_body)).check(matches(withText(postInBundle.body)))
    }

    @Test
    fun bundleWithPostWithoutUser_showsAllInformationAndAnonymousUser() {
        val navController = mock(NavController::class.java)
        val post = getPostBy(MockUiModels.PostIndex.NO_USER.ordinal)
        val anonymousPostMessage =
            getApplicationContext<Context>().getString(anonymousPostMessageID)

        // If post without user is shared to the fragment..
        launchPostDetailsFragment(navController, post)

        // ... then users's name shows anonymous-message and user's username is hidden ...
        onView(withId(R.id.post_author_name)).check(matches(withText(anonymousPostMessage)))
        onView(withId(R.id.post_author_userName)).check(matches(withEffectiveVisibility(Visibility.GONE)))

        // ... in addition the post title and body should be displayed.
        onView(withId(R.id.post_title)).check(matches(withText(postInBundle.title)))
        onView(withId(R.id.post_body)).check(matches(withText(postInBundle.body)))
    }

    private fun getPostBy(index: Int): Post = MockUiModels.fakeDefaultUiPostList[index]

    private fun launchPostDetailsFragment(navController: NavController?, post: Post? = null) {
        val bundle: Bundle? = if (post != null) {
            postInBundle = post
            PostDetailsFragmentArgs(postInBundle).toBundle()
        } else {
            null
        }

        launchFragmentInHiltContainer<PostDetailsFragment>(
            fragmentArgs = bundle,
            themeResId = R.style.Theme_JustPosts
        ) {
            Navigation.setViewNavController(view!!, navController)
        }
    }
}
