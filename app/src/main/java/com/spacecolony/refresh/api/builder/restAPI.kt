package com.spacecolony.refresh.api.builder

import com.spacecolony.refresh.model.response.ticketicare_response
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface restAPI {

    @FormUrlEncoded
    @POST(".")
    fun getTicketList(
        @Field("tag") tag: String,
        @Field("last_index") last_index: Int,
        @Field("sort_by") sort_by: String,
        @Field("sort_type") sort_type: String,
        @Field("limit") limit: Int,
        @Field("id_user") id_user: String,
        @Field("table_name") table_name: String
    ): Call<ticketicare_response>

}