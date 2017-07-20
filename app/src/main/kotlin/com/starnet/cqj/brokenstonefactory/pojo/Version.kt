package com.starnet.cqj.brokenstonefactory.pojo

/**
 * 作用：
 * Created by cqj on 2017-07-20.
 */
data class Version(var id:Int,var tableName:String,var version:Int,var recentId:Int)

data class User(var id:Int,var account:String,var name:String,var phone:String,var departmentId:Int,var isLogin:Int)
