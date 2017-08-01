package com.starnet.cqj.brokenstonefactory.data

import com.starnet.cqj.brokenstonefactory.pojo.Version
import io.reactivex.Observable

/**
 * 作用：
 * Created by cqj on 2017-08-01.
 */
interface IVersionDataSource {
    fun getVersions(): Observable<List<Version>>

    fun getVersion(id: Int, tableName: String = ""): Observable<Version>
}