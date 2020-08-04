package com.spacecolony.refresh.api.services

import android.util.Log
import com.spacecolony.refresh.api.`interface`.service_builder
import com.spacecolony.refresh.api.builder.restAPI
import com.spacecolony.refresh.model.request.get_ticket_request
import com.spacecolony.refresh.model.response.ticketicare_response
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class restAPIservices {

    fun getTicket(data: get_ticket_request, onResult: (ticketicare_response?) -> Unit) {
        val retrofit = service_builder.buildService(restAPI::class.java)
        retrofit.getTicketList(
            data.tag,
            data.last_index,
            data.sort_by,
            data.sort_type,
            data.limit,
            data.id_user,
            data.table_name
        ).enqueue(object : Callback<ticketicare_response> {
            override fun onFailure(call: Call<ticketicare_response>, t: Throwable) {
                onResult(null)
            }
            override fun onResponse(
                call: Call<ticketicare_response>,
                response: Response<ticketicare_response>
            ) {
                val respon = response.body()
                onResult(respon)
            }
        })
    }
}