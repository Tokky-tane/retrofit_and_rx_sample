package com.sample.githubapisample

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import java.sql.Timestamp

interface GitHubService {
    @GET("users/{userId}")
    fun getId(@Path("userId") userId: String): Single<GitHubReceiver>
}

data class GitHubReceiver(val login: String,
                          val id: String,
                          val node_id: String,
                          val avatar_url: String,
                          val gravatar_id: String,
                          val url: String,
                          val html_url: String,
                          val followers_url: String,
                          val following_url: String,
                          val gists_url: String,
                          val starred_url: String,
                          val subscriptions_url: String,
                          val organizations_url: String,
                          val repos_url: String,
                          val events_url: String,
                          val received_events_url: String,
                          val type: String,
                          val site_admin: Boolean,
                          val name: String,
                          val company: String,
                          val blog: String,
                          val location: String,
                          val email: String,
                          val hireable: String,
                          val bio: String,
                          val public_repos: Int,
                          val public_gists: Int,
                          val followers: Int,
                          val following: Int,
                          val created_at: Timestamp,
                          val updated_at: String)