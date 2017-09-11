package com.starnet.cqj.brokenstonefactory.view.fragment

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.starnet.cqj.brokenstonefactory.R
import com.starnet.cqj.brokenstonefactory.pojo.MainMenu
import com.starnet.cqj.brokenstonefactory.view.widget.recyclerviewhelper.RecyclerBaseAdapter
import com.starnet.cqj.brokenstonefactory.view.widget.viewholder.MenuViewHolder
import kotlinx.android.synthetic.main.fragment_menu.*
import java.util.*

/**
 * 作用：
 * Created by cqj on 2017-07-19.
 */
class MenuFragment : Fragment() {

    var mAdapter: RecyclerBaseAdapter<MainMenu, MenuViewHolder>? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initData()
        initEvent()
    }

    private fun init() {
        menuList.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        mAdapter = RecyclerBaseAdapter<MainMenu, MenuViewHolder>(R.layout.item_menu, MenuViewHolder::class.java)
        menuList.adapter = mAdapter
    }

    private fun initData() {
        val dataList = ArrayList<MainMenu>()
        val menu1 = MainMenu("故障申报")
        dataList.add(menu1)
        val menu2 = MainMenu("通讯录")
        dataList.add(menu2)
        val menu3 = MainMenu("统计报表")
        dataList.add(menu3)
        val menu4 = MainMenu("我的业务")
        dataList.add(menu4)
        mAdapter?.setAll(dataList)
    }


    private fun initEvent() {
        mAdapter?.itemClickObserve()
                ?.subscribe({
                    Snackbar.make(activity.window.decorView, it.menuText, Snackbar.LENGTH_LONG).show()
                }, {
                    it.printStackTrace()
                })
    }

}
