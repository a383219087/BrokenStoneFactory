package com.starnet.cqj.brokenstonefactory.base

import android.app.Activity
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import org.jetbrains.anko.find

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun Activity.toast(message: String, length: Int = Snackbar.LENGTH_SHORT) {
        Snackbar.make(find(android.R.id.content), message, length).show()
//        Toast.makeText(this,message,length).show();
    }

    fun Activity.toast(@StringRes message: Int, length: Int = Toast.LENGTH_SHORT) {
        Snackbar.make(find(android.R.id.content), message, length).show()
//        Toast.makeText(this,message,length).show()
    }
}
