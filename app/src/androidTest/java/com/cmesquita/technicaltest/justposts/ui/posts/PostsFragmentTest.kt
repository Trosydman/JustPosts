package com.cmesquita.technicaltest.justposts.ui.posts

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import com.cmesquita.technicaltest.justposts.R
import com.cmesquita.technicaltest.justposts.data_source.remote.api.graphqlzero.MockClientResponse
import com.cmesquita.technicaltest.justposts.data_source.remote.api.graphqlzero.mapper.Data1DTOMapper
import com.cmesquita.technicaltest.justposts.data_source.remote.api.graphqlzero.mapper.PostsResponseDTOMapper
import com.cmesquita.technicaltest.justposts.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@MediumTest
@HiltAndroidTest
class PostsFragmentTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun clickOnPostItem_navigatesToPostDetailsFragment() {
        val currentIndex = MockClientResponse.Data1Index.DEFAULT.ordinal
        val navController = mock(NavController::class.java)
        val posts =
            PostsResponseDTOMapper(Data1DTOMapper()).mapToDomainModel(MockClientResponse.fakeDefaultClientResponse)!!

        launchPostsFragment(navController)

        onView(withId(R.id.postsList)).perform(
            RecyclerViewActions.actionOnItemAtPosition<PostViewHolder>(
                currentIndex, click()
            )
        )

        verify(navController).navigate(
            PostsFragmentDirections.toPostDetailsFragment(posts.filterNotNull()[currentIndex])
        )
    }

    private fun launchPostsFragment(navController: NavController?) {
        launchFragmentInHiltContainer<PostsFragment>(themeResId = R.style.Theme_JustPosts) {
            Navigation.setViewNavController(view!!, navController)

            (this as PostsFragment).enableTransitions = false
        }
    }
}
