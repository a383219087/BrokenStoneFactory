package com.starnet.cqj.brokenstonefactory.view.activity

import android.os.Bundle
import android.text.TextUtils
import com.starnet.cqj.brokenstonefactory.R
import com.starnet.cqj.brokenstonefactory.base.BaseActivity
import com.starnet.cqj.brokenstonefactory.delegate.Preference
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    private var mAccount: String by Preference(this, "account", "")
    private var mPwd: String by Preference(this, "pwd", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        edtAccount.setText(mAccount)
        edtPwd.setText(mPwd)
        if (TextUtils.isEmpty(mPwd).not()) {
            edtPwd.setSelection(mPwd.length - 1)
        }
        btnLogin.setOnClickListener({
            if (TextUtils.isEmpty(edtAccount.text.toString())) {
                toast(R.string.account_hint)
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(edtPwd.text.toString())) {
                toast(R.string.pwd_hint)
                return@setOnClickListener
            }
            mAccount = edtAccount.text.toString()
            mPwd = edtPwd.text.toString()
            login(mAccount, mPwd)
        })
    }

    private fun login(account: String, pwd: String) {
        //TODO 服务端验证
        MainActivity.start(this)
        finish()
    }
}
