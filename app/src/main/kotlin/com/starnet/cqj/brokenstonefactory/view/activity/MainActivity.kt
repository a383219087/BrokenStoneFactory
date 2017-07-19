package com.starnet.cqj.brokenstonefactory.view.activity

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
        fragmentManager.beginTransaction()
                .replace(R.id.container, mFaultFragment)
                .commit()
        initEvent()
    }

    private fun initEvent() {
        switchRg.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.main_btn_contacts -> {
                    fragmentManager
                            .beginTransaction()
                            .replace(R.id.container, mContactsFragment)
                            .commit()
                }
                R.id.main_btn_fault -> {
                    fragmentManager
                            .beginTransaction()
                            .replace(R.id.container, mFaultFragment)
                            .commit()
                }
                R.id.main_btn_info -> {
                    fragmentManager
                            .beginTransaction()
                            .replace(R.id.container, mInfosFragment)
                            .commit()
                }
                else -> {

                }
            }
        }
    }


    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

}
