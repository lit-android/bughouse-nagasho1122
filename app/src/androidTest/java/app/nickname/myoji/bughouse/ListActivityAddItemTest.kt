package app.nickname.myoji.bughouse

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import app.nickname.myoji.bughouse.launcher.R
import app.nickname.myoji.bughouse.list.ListActivity
import app.nickname.myoji.bughouse.matchers.withRecyclerViewItemSize
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ListActivityAddItemTest {

    @get:Rule
    val rule: ActivityScenarioRule<ListActivity> = ActivityScenarioRule(ListActivity::class.java)

    @Test
    fun `RecyclerViewにItemが追加できるか`() {
        val expectText = "test"

        onView(withId(R.id.recycler_view))
            .check(matches(withRecyclerViewItemSize(3)))
        onView(withId(R.id.add_button))
            .perform(click())
        onView(withId(R.id.edit_text))
            .perform(typeText(expectText))
        onView(withId(R.id.recycler_view))
            .check(matches(withRecyclerViewItemSize(4)))
    }
}
