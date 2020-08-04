package com.spacecolony.refresh.model

data class header(var SortBy: String, var SortType: String, var Limit: Int, var FirstIndex: Int, var LastIndex: Int, var TicketRemaining: Boolean,
var Tickets: List<ticket_icare>)