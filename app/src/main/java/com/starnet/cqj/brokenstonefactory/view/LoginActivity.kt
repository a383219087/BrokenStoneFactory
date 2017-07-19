package com.starnet.cqj.brokenstonefactory.view

import android.os.Bundle
import com.starnet.cqj.brokenstonefactory.R
import com.starnet.cqj.brokenstonefactory.base.BaseActivity
import com.starnet.cqj.brokenstonefactory.delegate.Preference
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    private var mAccount:String by Preference(this,"account","")
    private var mPwd:String by Preference(this,"pwd","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        edtAccount.setText(mAccount)
        edtPwd.setText(mPwd)
        btnLogin.setOnClickListener({

            mAccount = edtAccount.text.toString()
            mPwd = edtPwd.text.toString()
            login(mAccount,mPwd)
        })
    }

    private fun login(account:String,pwd:String){

    }
}
