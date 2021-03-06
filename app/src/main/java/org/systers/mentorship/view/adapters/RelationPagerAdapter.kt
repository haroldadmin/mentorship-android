package org.systers.mentorship.view.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import org.systers.mentorship.MentorshipApplication
import org.systers.mentorship.R
import org.systers.mentorship.view.fragments.RelationFragment
import org.systers.mentorship.view.fragments.TasksFragment

/**
 * This is the [FragmentPagerAdapter] responsible for the configuration each fragment assigned to
 * each tabs. One tab displays the details of the current mentorship relation and the other provides
 * a detailed information about the tasks.
 * @param fm fragment manager
 */
class RelationPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    /**
     * This class represents the number and index of each tab of the layout
     */
    enum class TabsIndex(val value: Int) {
        DETAILS(0),
        TASKS(1)
    }

    val context = MentorshipApplication.getContext()

    override fun getItem(position: Int): Fragment {
        when (position) {
            TabsIndex.DETAILS.value -> {
                return RelationFragment.newInstance()
            }

            TabsIndex.TASKS.value -> {
                return TasksFragment.newInstance()
            }
        }
        return TasksFragment.newInstance()
    }

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            RequestsPagerAdapter.TabsIndex.PENDING.value -> {
                return context.getString(R.string.details)
            }
            RequestsPagerAdapter.TabsIndex.PAST.value -> {
                return context.getString(R.string.tasks)
            }
        }
        return context.getString(R.string.details)
    }
}
