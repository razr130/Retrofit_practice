package com.spacecolony.refresh.model

data class ticket_icare(
    var id_ticket: String,
    var addtime: String,
    var cerita: String,
    var table_name: String,
    var likes: String,
    var comment_count: String,
    var is_liked: String,
    var photo: photo,
    var user_create: user_create
)