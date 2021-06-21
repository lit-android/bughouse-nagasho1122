package app.nickname.myoji.bughouse

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import app.nickname.myoji.bughouse.launcher.R
import app.nickname.myoji.bughouse.load.LoadActivity
import app.nickname.myoji.bughouse.save.SaveActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoadActivityShowSavedTextTest {

    @get:Rule
    val rule: ActivityScenarioRule<SaveActivity> = ActivityScenarioRule(SaveActivity::class.java)

    @Test
    fun `SaveActivityで保存したTextがLoadActivityに表示されるかどうか`() {
        val expectText = "test input"

        onView(ViewMatchers.withId(R.id.input))
            .perform(typeText(expectText))
        onView(ViewMatchers.withId(R.id.save_button))
            .perform(click())
        rule.scenario.onActivity {
            it.startActivity(Intent(it, LoadActivity::class.java))
        }
        onView(ViewMatchers.withId(R.id.text_view))
            .check(ViewAssertions.matches(withText(expectText)))
    }
}
