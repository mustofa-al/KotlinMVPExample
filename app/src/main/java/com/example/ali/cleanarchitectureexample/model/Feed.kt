package com.example.ali.cleanarchitectureexample.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by ali on 02/10/17.
 */
data class Feed(@SerializedName("userId")
           @Expose
           val userId: Int,
           @SerializedName("id")
           @Expose
           val id: Int,
           @SerializedName("title")
           @Expose
           val title: String,
           @SerializedName("body")
           @Expose
           val body: String
)