package com.mobile.tr.poc.koin

import com.google.gson.Gson
import org.junit.Test

import org.junit.Assert.*
import java.io.*
import com.mobile.tr.poc.koin.user.WeatherEntry
import org.junit.After
import org.junit.Assert
import org.junit.Before


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private var entry: WeatherEntry? = null

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Before
    fun loadData(){
        val file = File("src/test/resources/weather.json")
        entry = Gson().fromJson(file.readText(),WeatherEntry::class.java)
        assertTrue(file.exists())
    }

    @Test
    fun checkName() {
        assertEquals("Mountain View",entry?.city?.name)
    }

    @Test
    fun checkID() {
        assertEquals(5375480,entry?.city?.id)
    }



    @After
    fun tearDown() {
        entry = null
    }
}
