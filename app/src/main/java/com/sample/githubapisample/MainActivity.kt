package com.sample.githubapisample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var textView = TextView(applicationContext)
        setContentView(textView)


        var gitHubService = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                // rxJavaを使用
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                // コンバーターにはGsonを利用
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                // APIを定義したインターフェースを指定
                .create(GitHubService::class.java)

        gitHubService.getId("Tokky-tane")
                // getIdはioスレッド上で実行
                .subscribeOn(Schedulers.io())
                // これ以下の内容はメインスレッド上で実行
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        // 通信成功時
                        onSuccess = {
                            textView.text = it.toString()
                        },
                        // 通信失敗時
                        onError = {
                            RuntimeException(it)
                        }
                )
    }
}



