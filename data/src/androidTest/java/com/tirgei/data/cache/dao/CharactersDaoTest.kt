package com.tirgei.data.cache.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.tirgei.data.cache.AppDatabase
import com.tirgei.data.cache.SampleData
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject
import javax.inject.Named
import kotlin.time.ExperimentalTime

@ExperimentalTime
@ExperimentalCoroutinesApi
@SmallTest
@HiltAndroidTest
class CharactersDaoTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    @Named("test_db")
    lateinit var database: AppDatabase

    private lateinit var charactersDao: CharactersDao

    @Before
    fun setup() {
        hiltRule.inject()
        charactersDao = database.charactersDao()
    }

    @After
    fun teardown() {
        database.clearAllTables()
        database.close()
    }

    @Test
    fun saveCharacter() = runBlockingTest {
        charactersDao.saveCharacter(SampleData.character1)
        val result = charactersDao.getAll().first()

        assertThat(result.size).isEqualTo(1)
        assertThat(result.first()).isEqualTo(SampleData.character1)
    }

    @Test
    fun insertAll() = runBlockingTest {
        charactersDao.insertAll(listOf(SampleData.character1, SampleData.character2))
        val result = charactersDao.getAll().first()

        assertThat(result.size).isEqualTo(2)
        assertThat(result).contains(SampleData.character1)
        assertThat(result).contains(SampleData.character2)
    }

    @Test
    fun getCharacter() = runBlockingTest {
        charactersDao.saveCharacter(SampleData.character1)
        val result = charactersDao.getCharacter(1).first()

        assertThat(result).isEqualTo(SampleData.character1)
        assertThat(result.name).isEqualTo("Pickle Rick")
    }

}