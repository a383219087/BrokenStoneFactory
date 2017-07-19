package com.starnet.cqj.brokenstonefactory.view.activity

import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.starnet.cqj.brokenstonefactory.R
import com.starnet.cqj.brokenstonefactory.base.BaseActivity
import com.starnet.cqj.brokenstonefactory.view.fragment.ContactsFragment
import com.starnet.cqj.brokenstonefactory.view.fragment.FaultFragment
import com.starnet.cqj.brokenstonefactory.view.fragment.InfosFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_title.*

class MainActivity : BaseActivity() {

    private val mContactsFragment: ContactsFragment = ContactsFragment()
    private val mFaultFragment: FaultFragment = FaultFragment()
    private val mInfosFragment: InfosFragment = InfosFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBar(toolbar)
        actionBar.setDisplayHomeAsUpEnabled(false)
        changeFragment(mFaultFragment)
        initEvent()
    }

    private fun initEvent() {
        switchRg.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.main_btn_contacts -> {
                    changeFragment(mContactsFragment)
                }
                R.id.main_btn_fault -> {
                    changeFragment(mFaultFragment)
                }
                R.id.main_btn_info -> {
                    changeFragment(mInfosFragment)
                }
                else -> {
                    changeFragment(mFaultFragment)
                }
            }
        }
    }

    private fun changeFragment(fragment: Fragment) {
        fragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
    }


    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

}
