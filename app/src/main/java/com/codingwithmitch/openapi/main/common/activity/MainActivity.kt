package com.codingwithmitch.openapi.main.common.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.codingwithmitch.openapi.R

import com.codingwithmitch.openapi.common.BottomNavController
import com.codingwithmitch.openapi.common.activity.BaseActivity
import com.codingwithmitch.openapi.common.setUpNavigation
import com.codingwithmitch.openapi.main.account.fragment.ChangePasswordFragment
import com.codingwithmitch.openapi.main.account.fragment.UpdateAccountFragment
import com.codingwithmitch.openapi.main.blog.fragment.UpdateBlogFragment
import com.codingwithmitch.openapi.main.blog.fragment.ViewBlogFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), BottomNavController.OnNavigationReselectedListener,
    BottomNavController.OnNavigationGraphChanged, BottomNavController.NavGraphProvider {

    private lateinit var bottomNavigationView: BottomNavigationView
    private val bottomNavController by lazy {
        BottomNavController(
            this,
            R.id.main_nav_host_fragment,
            R.id.nav_blog,
            this,
            this
        )
    }

    override fun getNavGraphId(itemId: Int): Int {
        return when(itemId){
            R.id.nav_blog -> {
                R.navigation.nav_blog
            }
            R.id.nav_account -> {
                R.navigation.nav_account
            }
            R.id.nav_create_blog -> {
                R.navigation.nav_create_blog
            }
            else -> R.navigation.nav_blog
        }
    }

    override fun onGraphChange() {
        //TODO
    }

    override fun onReselectedNavItem(navController: NavController, fragment: Fragment) {
        when(fragment){
            is ViewBlogFragment -> {
                navController.navigate(R.id.action_viewBlogFragment_to_blogFragment)
            }
            is UpdateBlogFragment -> {
                navController.navigate(R.id.action_updateBlogFragment_to_blogFragment)
            }
            is UpdateAccountFragment -> {
                navController.navigate(R.id.action_updateAccountFragment_to_launcherFragment)
            }
            is ChangePasswordFragment -> {
                navController.navigate(R.id.action_changePasswordFragment_to_launcherFragment)
            }
            else -> Unit
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        bottomNavController.onBackPressed()
    }

    private fun setupActionBar(){
        setSupportActionBar(tool_bar)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupActionBar()
        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        bottomNavigationView.setUpNavigation(bottomNavController, this)
        if(savedInstanceState == null){
            bottomNavController.onNavigationItemSelected()
        }
    }
}