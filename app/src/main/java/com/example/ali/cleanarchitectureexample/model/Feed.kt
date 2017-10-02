package com.example.ali.cleanarchitectureexample.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by ali on 02/10/17.
 */
class Feed(@SerializedName("userId")
           @Expose
           var userId: Int? = null,
           @SerializedName("id")
           @Expose
           var id: Int? = null,
           @SerializedName("title")
           @Expose
           var title: String? = null,
           @SerializedName("body")
           @Expose
           var body: String? = null
)