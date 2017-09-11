package com.starnet.cqj.brokenstonefactory.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import com.starnet.cqj.brokenstonefactory.R
import com.starnet.cqj.brokenstonefactory.base.BaseActivity
import com.starnet.cqj.brokenstonefactory.view.fragment.FaultFragment
import com.starnet.cqj.brokenstonefactory.view.fragment.MenuFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val menuFragment = MenuFragment()
    private val faultFragment = FaultFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val actionToggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.drawer_open, R.string.drawer_close)
        actionToggle.syncState()
        drawer_layout?.setDrawerListener(actionToggle)
//        drawer_layout.closeDrawers()
        fragmentManager.beginTransaction()
                .replace(R.id.mainContainer, faultFragment)
                .replace(R.id.menuContainer, menuFragment)
                .commitAllowingStateLoss()
    }

    override fun onResume() {
        super.onResume()
    }


    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

}
