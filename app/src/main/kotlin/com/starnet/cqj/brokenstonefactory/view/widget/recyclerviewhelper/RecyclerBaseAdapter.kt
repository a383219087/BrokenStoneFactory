package com.starnet.cqj.brokenstonefactory.view.widget.recyclerviewhelper

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import java.lang.reflect.Constructor
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * 作用：
 * Created by cqj on 2017-09-11.
 */
class RecyclerBaseAdapter<T, VH : BaseHolder<T>>(val layoutId: Int, val clazz: Class<VH>)
: RecyclerView.Adapter<VH>(), IParamsContainer {

    private val mDataList = ArrayList<T>()

    private val mItemClick: PublishSubject<T> = PublishSubject.create()

    private val mParamsContainerMap = HashMap<String,Any>()

    override fun get(key: String): Any? {
        return mParamsContainerMap.get(key)
    }

    override fun set(key: String, o: Any?) {
        o?.let {
            mParamsContainerMap.put(key,it)
        }
    }


    fun add(data: T?) {
        data?.let {
            mDataList.add(it)
            notifyItemInserted(mDataList.size)
        }
    }

    fun insertTop(data: T?) {
        data?.let {
            if (mDataList.size == 0) {
                mDataList.add(it)
            } else {
                mDataList.add(0, it)
            }
            notifyItemInserted(0)
        }
    }

    fun addAll(datas: List<T>?) {
        datas?.let {
            mDataList.addAll(it)
            notifyDataSetChanged()
        }
    }

    fun setAll(datas: List<T>?) {
        datas?.let {
            clear()
            mDataList.addAll(it)
            notifyDataSetChanged()
        }
    }

    fun clear() {
        mDataList.clear()
    }

    fun contains(data: T): Boolean {
        return mDataList.contains(data)
    }

    fun itemClickObserve(): Observable<T> {
        return mItemClick.throttleFirst(500, TimeUnit.MILLISECONDS)
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(mDataList,position,this,mItemClick)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VH {
        val view = LayoutInflater.from(parent!!.context).inflate(layoutId,parent,false)
        val csr: Constructor<VH> = clazz.getConstructor(View::class.java)
        return csr.newInstance(view)
    }

}