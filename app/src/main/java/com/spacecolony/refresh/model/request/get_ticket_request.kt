package com.spacecolony.refresh.model.request


data class get_ticket_request(
    var tag: String,
    val last_index: Int,
    val sort_by: String,
    val sort_type: String,
    val limit: Int,
    val id_user: String,
    val table_name: String
)

