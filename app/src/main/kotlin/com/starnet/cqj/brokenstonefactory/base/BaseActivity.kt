package com.starnet.cqj.brokenstonefactory.base

import android.app.Activity
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun Activity.toast(message:String,length:Int = Toast.LENGTH_SHORT){
        Toast.makeText(this,message,length).show();
    }

    fun Activity.toast(@StringRes message:Int,length:Int=Toast.LENGTH_SHORT){
        Toast.makeText(this,message,length).show();
    }
}
