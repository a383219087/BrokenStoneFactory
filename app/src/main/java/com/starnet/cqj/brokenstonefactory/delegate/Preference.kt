package com.starnet.cqj.brokenstonefactory.delegate

import android.content.Context
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * 作用：SharedPreference属性代理
 * Created by cqj on 2017-07-19.
 */
class Preference<T>(val context: Context, val name:String, val default:T) : ReadWriteProperty<Any?, T> {

    val pref by lazy{
        context.getSharedPreferences("config", Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return getPreference(name,default)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putPreference(name,value)
    }

    private fun <U> putPreference(name:String,value:U) = with(pref.edit()){
        val res:Any = when(value){
            is Long -> putLong(name,value)
            is String ->putString(name,value)
            is Int ->putInt(name,value)
            is Float ->putFloat(name,value)
            is Boolean ->putBoolean(name,value)
            else -> throw IllegalArgumentException()
        }.apply()
    }

    private fun <U> getPreference(name:String,default:U):U=with(pref){
        val res:Any=when(default){
            is Long->getLong(name,default)
            is String -> getString(name,default)
            is Float -> getFloat(name,default)
            is Int ->getInt(name,default)
            is Boolean ->getBoolean(name,default)
            else->throw IllegalArgumentException()
        }

        res as U
    }

}
