package com.starnet.cqj.brokenstonefactory.view.widget.recyclerviewhelper

import android.support.v7.widget.RecyclerView
import android.view.View
import io.reactivex.subjects.PublishSubject

/**
 * 作用：
 * Created by cqj on 2017-09-11.
 */
abstract class BaseHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(data: List<T>, position: Int, paramsContainer: IParamsContainer, itemClick: PublishSubject<T>)
}