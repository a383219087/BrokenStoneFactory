package com.starnet.cqj.brokenstonefactory.view.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.starnet.cqj.brokenstonefactory.R
import kotlinx.android.synthetic.main.fragment_infos.*

/**
 * 作用：
 * Created by cqj on 2017-07-19.
 */
class InfosFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.fragment_infos, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}
