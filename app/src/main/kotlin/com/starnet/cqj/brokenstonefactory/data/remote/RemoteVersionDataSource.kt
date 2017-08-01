package com.starnet.cqj.brokenstonefactory.data.remote

import com.starnet.cqj.brokenstonefactory.data.IVersionDataSource
import com.starnet.cqj.brokenstonefactory.data.remote.service.VersionService
import com.starnet.cqj.brokenstonefactory.pojo.Version
import io.reactivex.Observable

class RemoteVersionDataSource : RemoteDataSourceBase(Constant.Url+"/versions/"),IVersionDataSource {

    val service:VersionService

    init {
        service=retrofit.create(VersionService::class.java)
    }

    override fun getVersions(): Observable<List<Version>> {
        return service.getVersions()
    }

    override fun getVersion(id: Int, tableName: String): Observable<Version> {
        return service.getVersion(id)
    }

}