package com.starnet.cqj.brokenstonefactory.pojo

import org.json.JSONObject

/**
 * 作用：
 * Created by cqj on 2017-07-20.
 */
data class Version(var id: Int, var tableName: String, var version: Int, var recentId: Int) {

    companion object {
        val KEY_ID = "id"
        val KEY_TABLE_NAME = "tableName"
        val KEY_VERSION = "version"
        val KEY_RECENT_ID = "recentId"

        fun parse(jsonObject: JSONObject): Version {
            val id = jsonObject.optInt(KEY_ID, 0)
            val tableName = jsonObject.optString(KEY_TABLE_NAME, "")
            val version = jsonObject.optInt(KEY_VERSION, 0)
            val recentId = jsonObject.optInt(KEY_RECENT_ID, 0)
            return Version(id, tableName, version, recentId)
        }
    }

}

data class User(var id: Int = 0, var account: String, var name: String,
                var phone: String, var departmentId: Int = 0, var isLogin: Int = 1)
