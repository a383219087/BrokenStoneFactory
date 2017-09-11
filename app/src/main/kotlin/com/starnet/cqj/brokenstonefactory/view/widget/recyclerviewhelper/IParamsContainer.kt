package com.starnet.cqj.brokenstonefactory.view.widget.recyclerviewhelper

/**
 * 作用：
 * Created by cqj on 2017-09-11.
 */

interface IParamsContainer{
    fun get(key:String):Any?

    fun set(key:String,o:Any?)
}
