package com.starnet.cqj.brokenstonefactory.data.local

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.text.TextUtils
import com.starnet.cqj.brokenstonefactory.pojo.Version
import java.util.*

/**
 * 作用：Version专用数据库操作类
 * Created by cqj on 2017-07-20.
 */
class VersionDao(context: Context) : BaseDao<Version>(context) {

    private val TABLE_NAME = "t_version"

    override fun insertLogic(db: SQLiteDatabase, t: Version) {
        val cv = ContentValues()
        cv.put(Version.KEY_TABLE_NAME, t.tableName)
        cv.put(Version.KEY_VERSION, t.version)
        cv.put(Version.KEY_RECENT_ID, t.recentId)
        db.insert(TABLE_NAME, "tableName", cv)
    }

    override fun updateLogic(db: SQLiteDatabase, t: Version) {
        val cv = ContentValues()
        cv.put(Version.KEY_TABLE_NAME, t.tableName)
        cv.put(Version.KEY_VERSION, t.version)
        cv.put(Version.KEY_RECENT_ID, t.recentId)
        var whereClause: String = ""
        var whereArgs: Array<String> = emptyArray<String>()
        if (t.id != 0) {
            whereClause = Version.KEY_ID + "=?"
            whereArgs = arrayOf(t.id.toString())
        } else if (TextUtils.isEmpty(t.tableName).not()) {
            whereClause = Version.KEY_TABLE_NAME + "=?"
            whereArgs = arrayOf(t.tableName.toString())
        }
        if (TextUtils.isEmpty(whereClause).not()) {
            db.update(TABLE_NAME, cv, whereClause, whereArgs)
        }
    }

    override fun deleteLogic(db: SQLiteDatabase, t: Version) {
        var whereClause: String = ""
        var whereArgs: Array<String> = emptyArray<String>()
        if (t.id != 0) {
            whereClause = Version.KEY_ID + "=?"
            whereArgs = arrayOf(t.id.toString())
        } else if (TextUtils.isEmpty(t.tableName).not()) {
            whereClause = Version.KEY_TABLE_NAME + "=?"
            whereArgs = arrayOf(t.tableName.toString())
        }
        if (TextUtils.isEmpty(whereClause).not()) {
            db.delete(TABLE_NAME, whereClause, whereArgs)
        }
    }

    override fun selectLogic(db: SQLiteDatabase, whereClause: String, whereArgs: Array<out String>, order: String): List<Version> {
        val list = ArrayList <Version>()
        val cursor: Cursor? = db.query(TABLE_NAME, null, whereClause, whereArgs, null, null, order)
        cursor?.let {
            if (cursor.moveToFirst()) {
                do {
                    val id = cursor.getInt(cursor.getColumnIndex(Version.KEY_ID))
                    val tableName = cursor.getString(cursor.getColumnIndex(Version.KEY_TABLE_NAME))
                    val version = cursor.getInt(cursor.getColumnIndex(Version.KEY_VERSION))
                    val recentId = cursor.getInt(cursor.getColumnIndex(Version.KEY_RECENT_ID))
                    val v = Version(id,tableName,version,recentId)
                    list.add(v)
                } while (cursor.moveToNext())
            }
        }
        cursor?.close()
        return list
    }

}