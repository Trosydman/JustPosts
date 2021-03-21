package com.cmesquita.technicaltest.justposts.ui.post_details

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import com.cmesquita.technicaltest.justposts.R
import com.cmesquita.technicaltest.justposts.launchFragmentInHiltContainer
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

    @Test
    fun clickOnNavigationButton_thenPopBackStack() {
        val navController = mock(NavController::class.java)
        launchPostDetailsFragment(navController)

        // If navigation icon is clicked...
        onView(withId(R.id.navigation_icon)).perform(click())

        // ... then it should go back to the previous fragment.
        verify(navController).popBackStack()
    }

    private fun launchPostDetailsFragment(navController: NavController?) {
        launchFragmentInHiltContainer<PostDetailsFragment>(themeResId = R.style.Theme_JustPosts) {
            Navigation.setViewNavController(view!!, navController)
        }
    }
}
