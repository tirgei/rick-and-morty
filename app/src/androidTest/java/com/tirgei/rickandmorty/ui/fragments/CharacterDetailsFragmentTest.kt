package com.tirgei.rickandmorty.ui.fragments

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import com.tirgei.rickandmorty.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import com.tirgei.rickandmorty.R

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class CharacterDetailsFragmentTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    private lateinit var navController: NavController
    private lateinit var args: Bundle

    @Before
    fun setup() {
        hiltRule.inject()
        navController = mock(NavController::class.java)
        args = Bundle().apply {
            putInt("characterId", 1)
        }
    }

    @Test
    fun pressDeviceBackButton_popsBackStack() {
        launchFragmentInHiltContainer<CharacterDetailsFragment>(fragmentArgs = args) {
            Navigation.setViewNavController(requireView(), navController)
        }

        pressBack()
        verify(navController).popBackStack()
    }

    @Test
    fun pressToolbarBackButton_popsBackStack() {
        launchFragmentInHiltContainer<CharacterDetailsFragment>(fragmentArgs = args) {
            Navigation.setViewNavController(requireView(), navController)
        }

        onView(withId(R.id.back)).perform(click())
        verify(navController).popBackStack()
    }

}