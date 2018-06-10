package nl.jovmit.main

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import nl.jovmit.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import com.microsoft.appcenter.espresso.Factory
import com.microsoft.appcenter.espresso.ReportHelper

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule
    @JvmField
    val reportHelper = Factory.getReportHelper()

    @After
    fun TearDown() {
        reportHelper.label("Stopping main");
    }

    @Rule
    @JvmField
    val rule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun screenShouldApplyCorrectTitle() {
        toolbarWithTitle(R.string.hello) check isDisplayed
    }

    @Test
    fun screenShouldContainGreetingMessage() {
        R.id.mainGreetingMessage check isDisplayed
    }

    @Test
    fun greetingMessageShouldApplyCorrectText() {
        R.id.mainGreetingMessage hasText R.string.hello
    }
}