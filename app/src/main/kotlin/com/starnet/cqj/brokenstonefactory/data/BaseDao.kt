package com.starnet.cqj.brokenstonefactory.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.starnet.cqj.brokenstonefactory.pojo.Version

/**
 * 作用：数据库操作基类
 * Created by cqj on 2017-07-20.
 */
abstract class BaseDao<T>(context: Context) {
    private val helper: MySQLiteHelper

    init {
        helper = MySQLiteHelper(context)
    }

    fun insert(t: T) {
        val db = helper.writableDatabase
        insertLogic(db, t)
    }

    protected abstract fun insertLogic(db: SQLiteDatabase, t: T)

    fun update(t: T) {
        val db = helper.writableDatabase
        updateLogic(db, t)
    }

    protected abstract fun updateLogic(db: SQLiteDatabase, t: T)


    fun delete(t: T) {
        val db = helper.writableDatabase
        deleteLogic(db, t)
    }

    protected abstract fun deleteLogic(db: SQLiteDatabase, t: T)

    fun select(whereClause: String, whereArgs: Array<out String>, order: String): List<Version> {
        val db = helper.readableDatabase
        return selectLogic(db, whereClause, whereArgs, order)
    }

    protected abstract fun selectLogic(db: SQLiteDatabase, whereClause: String, whereArgs: Array<out String>, order: String): List<Version>

}