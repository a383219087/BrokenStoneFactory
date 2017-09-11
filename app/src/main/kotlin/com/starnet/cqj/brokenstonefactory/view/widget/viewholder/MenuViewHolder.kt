package com.starnet.cqj.brokenstonefactory.view.widget.viewholder

import android.view.View
import com.starnet.cqj.brokenstonefactory.pojo.MainMenu
import com.starnet.cqj.brokenstonefactory.view.widget.recyclerviewhelper.BaseHolder
import com.starnet.cqj.brokenstonefactory.view.widget.recyclerviewhelper.IParamsContainer
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_menu.view.*

/**
 * 作用：
 * Created by cqj on 2017-09-11.
 */
class MenuViewHolder(itemView: View) : BaseHolder<MainMenu>(itemView) {


    override fun bind(data: List<MainMenu>, position: Int, paramsContainer: IParamsContainer, itemClick: PublishSubject<MainMenu>) {
        val itemData = data.get(position)
        itemView.menuItemText.text = itemData.menuText
        itemView.setOnClickListener {
            itemClick.onNext(itemData)
        }
    }

}