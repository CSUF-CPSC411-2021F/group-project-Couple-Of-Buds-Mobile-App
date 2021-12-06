package com.example.cobrtb

import com.example.cobrtb.database.DataGenerator
import com.example.cobrtb.updatesList.UpdatesListFragment
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun database_is_correctly_filled() {
        assertEquals(9, DataGenerator.announcements.size)
    }
}