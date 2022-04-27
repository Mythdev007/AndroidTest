package com.thejan.assessment.androidtest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.thejan.assessment.androidtest.ui.MainActivity
import org.junit.Rule
import org.junit.Test


class MainActivityTest {
    @get:Rule
    val mainActivity: ActivityTestRule<MainActivity> = ActivityTestRule(
        MainActivity::class.java
    )

    @Test
    @Throws(InterruptedException::class)
    fun inputEmptyValue() {
        onView(withId(R.id.btnSave)).perform(click())
        onView(withText(R.string.invalid_input))
            .inRoot(ToastMatcher().apply {
                matches(isDisplayed())
            });
    }

    @Test
    @Throws(InterruptedException::class)
    fun correctInput() {
        onView(withId(R.id.etvInput)).perform(
            replaceText("Test123456"),
            closeSoftKeyboard()
        )
        onView(withId(R.id.btnSave)).perform(click())
        onView(withId(R.id.tvText)).check(matches(withText("Test123456")));
    }
}