package com.codingwithmitch.openapi.common

import android.app.Activity
import android.content.Context
import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.codingwithmitch.openapi.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavController(
    val context: Context,
    @IdRes val containerId: Int,
    @IdRes val appStartDestinationId: Int,
    val graphChangeListener: OnNavigationGraphChanged?,
    val navGraphProvider: NavGraphProvider
) {

    private val TAG: String = "AppDebug"

    lateinit var activity: Activity
    private val navigationBackStack = BackStack.of(appStartDestinationId)
    lateinit var fragmentManager: FragmentManager
    lateinit var navItemChangeListener: OnNavigationItemChanged

    init {
        if (context is Activity) {
            activity = context
            fragmentManager = (activity as FragmentActivity).supportFragmentManager
        }
    }

    fun onNavigationItemSelected(itemId: Int = navigationBackStack.last()): Boolean {
        val fragment = fragmentManager.findFragmentByTag(itemId.toString())
            ?: NavHostFragment.create(navGraphProvider.getNavGraphId(itemId))

        fragmentManager.beginTransaction().setCustomAnimations(
            R.anim.fade_in,
            R.anim.fade_out,
            R.anim.fade_in,
            R.anim.fade_out
        )
            .replace(containerId, fragment, itemId.toString())
            .addToBackStack(null)
            .commit()

        navigationBackStack.moveLast(itemId)
        navItemChangeListener.onItemChanged(itemId)
        graphChangeListener?.onGraphChange()

        return true
    }

    fun onBackPressed() {
        val childFragmentManager =
            fragmentManager.findFragmentById(containerId)?.childFragmentManager ?: return
        when {
            childFragmentManager.popBackStackImmediate() -> Unit
            navigationBackStack.size > 1 -> {
                navigationBackStack.removeLast()
                onNavigationItemSelected()
            }
            navigationBackStack.last() != appStartDestinationId -> {
                navigationBackStack.removeLast()
                navigationBackStack.add(0, appStartDestinationId)
                onNavigationItemSelected()
            }
            else -> activity.finish()
        }
    }

    fun setOnNavigationItemChanged(listener: (itemId: Int) -> Unit) {
        this.navItemChangeListener = object : OnNavigationItemChanged {
            override fun onItemChanged(itemId: Int) {
                listener.invoke(itemId)
            }
        }
    }

    //For setting the checked icon in the bottom nav
    interface OnNavigationItemChanged {
        fun onItemChanged(itemId: Int)
    }

    //Get id of each graph
    interface NavGraphProvider {
        @NavigationRes
        fun getNavGraphId(itemId: Int): Int
    }

    //Execute when navigation graph changes
    interface OnNavigationGraphChanged {
        fun onGraphChange()
    }

    interface OnNavigationReselectedListener {
        fun onReselectedNavItem(navController: NavController, fragment: Fragment)
    }

    private class BackStack : ArrayList<Int>() {
        companion object {
            fun of(vararg elements: Int): BackStack {
                val backStack = BackStack()
                backStack.addAll(elements.toTypedArray())
                return backStack
            }
        }

        fun removeLast() = removeAt(size - 1)

        fun moveLast(item: Int) {
            remove(item)
            add(item)
        }
    }
}

fun BottomNavigationView.setUpNavigation(
    bottomNavController: BottomNavController,
    onReselectListener: BottomNavController.OnNavigationReselectedListener
) {
    setOnNavigationItemSelectedListener {
        bottomNavController.onNavigationItemSelected(it.itemId)
    }
    setOnNavigationItemReselectedListener {
        bottomNavController
            .fragmentManager
            .findFragmentById(bottomNavController.containerId)!!.childFragmentManager
            .fragments[0]?.let { fragment ->
            onReselectListener.onReselectedNavItem(
                bottomNavController.activity.findNavController(bottomNavController.containerId),
                fragment
            )
        }
    }
    bottomNavController.setOnNavigationItemChanged { itemId ->
        menu.findItem(itemId).isChecked = true
    }
}