package app.nickname.myoji.bughouse

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import app.nickname.myoji.bughouse.count.CountActivity
import app.nickname.myoji.bughouse.launcher.R
import app.nickname.myoji.bughouse.matchers.withFontSize
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CountActivityChangeFontSizeTest {

    @get:Rule
    val rule: ActivityScenarioRule<CountActivity> = ActivityScenarioRule(CountActivity::class.java)

    @Test
    fun `TextViewのサイズを小さくしているか`() {
        Espresso.onView(ViewMatchers.withId(R.id.text_view))
            .check(ViewAssertions.matches(Matchers.not(withFontSize(1000f))))
    }
}
