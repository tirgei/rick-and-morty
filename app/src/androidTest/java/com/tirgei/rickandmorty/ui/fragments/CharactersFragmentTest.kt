package com.tirgei.rickandmorty.ui.fragments

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import com.google.common.truth.Truth.assertThat
import com.tirgei.rickandmorty.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import com.tirgei.rickandmorty.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class CharactersFragmentTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun onLaunch_loadingIsShown() {
        launchFragmentInHiltContainer<CharactersFragment> {  }
        onView(withId(R.id.charactersRv)).check(matches(isDisplayed()))
    }

    @Test
    fun assertOne_isOne() {
        val one = 1
        assertThat(one).isEqualTo(1)
    }

}