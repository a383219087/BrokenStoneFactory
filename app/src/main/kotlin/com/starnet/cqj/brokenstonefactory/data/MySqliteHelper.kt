package com.starnet.cqj.brokenstonefactory.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * 作用：
 * Created by cqj on 2017-07-20.
 */
class MySQLiteHelper(context: Context)
: SQLiteOpenHelper(context, "brokenStone", null, 1) {


    override fun onCreate(db: SQLiteDatabase?) {
        val createVersions = "create table if not exists t_version(id INTEGER PRIMARY KEY AUTOINCREMENT,tableName VARCHAR(1000),version INTEGER,recentId INTEGER)"
        db?.execSQL(createVersions)
        val createUser = "create table if not exists t_user(id INTEGER PRIMARY KEY AUTOINCREMENT,account VARCHAR(1000),name VARCHAR(1000),phone VARCHAR(100),levels INTEGER,departmentId INTEGER,isLogin INTEGER)"
        db?.execSQL(createUser)
        val createFault ="create table if not exists t_fault(id INTEGER PRIMARY KEY AUTOINCREMENT,description VARCHAR(4000),isStopMachine INTEGER,restoreDate TIME,isRestore INTEGER,isCheck INTEGER,finishDate TIME)"
        db?.execSQL(createFault)
        val createUnit = "create table if not exists t_unit(id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(200),isValiable INTEGER,chooseCount INTEGER)"
        db?.execSQL(createUnit)
        val createImage = "create table if not exists t_image(id INTEGER PRIMARY KEY AUTOINCREMENT,path VARCHAR(2000),faultId INTEGER,imageData BLOB)"
        db?.execSQL(createImage)
        val createFitting = "create table if not exists t_fitting(id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(4000),unitId INTEGER,price DOUBLE,chooseCount INTEGER,isValiable INTEGER)"
        db?.execSQL(createFitting)
        val createPurchase ="create table if not exists t_purchase(id INTEGER PRIMARY KEY AUTOINCREMENT,fittingId INTEGER,count INTEGER, totalPrice DOUBLE,faultId INTEGER,buyUserId INTEGER,buyDate TIME)"
        db?.execSQL(createPurchase)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }



}