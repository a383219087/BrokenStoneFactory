package com.starnet.cqj.brokenstonefactory.data.remote

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 作用：
 * Created by cqj on 2017-08-01.
 */
abstract class RemoteDataSourceBase(url:String){
    val retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}