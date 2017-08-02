package com.starnet.cqj.brokenstonefactory.data.remote.service

import com.starnet.cqj.brokenstonefactory.pojo.Version
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * 作用：
 * Created by cqj on 2017-08-01.
 */

interface VersionService{

    @GET("versions/")
    fun getVersions(): Observable<List<Version>>;

    @GET("versions/{id}")
    fun getVersion(@Path("id") id:Int):Observable<Version>;

}