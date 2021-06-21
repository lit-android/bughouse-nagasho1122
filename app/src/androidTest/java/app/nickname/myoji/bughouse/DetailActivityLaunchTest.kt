package app.nickname.myoji.bughouse

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.ComponentNameMatchers.hasClassName
import androidx.test.espresso.intent.matcher.ComponentNameMatchers.hasMyPackageName
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import app.nickname.myoji.bughouse.launcher.R
import app.nickname.myoji.bughouse.list.ListActivity
import app.nickname.myoji.bughouse.list.TaskAdapter
import org.hamcrest.CoreMatchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailActivityLaunchTest {

    @get:Rule
    val intentsTestRule = IntentsTestRule(ListActivity::class.java)

    @Test
    fun `DetailActivityに遷移できるか`() {
        onView(withId(R.id.recycler_view))
            .perform(RecyclerViewActions.actionOnItemAtPosition<TaskAdapter.ViewHolder>(0, click()))

        intended(
            allOf(
                hasComponent(hasMyPackageName()),
                hasComponent(hasClassName("app.nickname.myoji.bughouse.list.DetailActivity")),
            )
        )
    }
}
