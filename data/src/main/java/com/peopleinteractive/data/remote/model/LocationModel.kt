package com.peopleinteractive.data.remote.model

import com.google.gson.annotations.SerializedName

data class LocationModel(val city: String, val state: String, val country: String,
                         @SerializedName("postcode")
                    val postCode: String)