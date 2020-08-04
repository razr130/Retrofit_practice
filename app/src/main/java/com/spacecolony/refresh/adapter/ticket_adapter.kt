package com.spacecolony.refresh.adapter

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.spacecolony.refresh.R
import com.spacecolony.refresh.config.constant
import com.spacecolony.refresh.model.ticket_icare
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class ticket_adapter(
    private val context: Context,
    private val ticketlist: MutableList<ticket_icare>
) : RecyclerView.Adapter<ticket_adapter.ticket_viewholder>() {

    class ticket_viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txtusername = itemView.findViewById(R.id.TxtUserTicket) as TextView
        var txttgl = itemView.findViewById(R.id.TxtTglTicket) as TextView
        var profileimage = itemView.findViewById(R.id.ImgProfile) as CircleImageView
        var txtlikecount = itemView.findViewById(R.id.TxtLikeCount) as TextView
        var txtcommentcount = itemView.findViewById(R.id.TxtCommentCount) as TextView
        var ticketimage = itemView.findViewById(R.id.ImgTicket) as ImageView
        var txtcerita = itemView.findViewById(R.id.TxtCerita) as TextView
        var moremenu = itemView.findViewById(R.id.BtnMore) as ImageView
        var loveicon = itemView.findViewById(R.id.ImgLove) as ImageView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ticket_viewholder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.ticket_item, parent, false)
        return ticket_viewholder(itemView)
    }

    override fun getItemCount(): Int {
        return ticketlist.size
    }

    override fun onBindViewHolder(holder: ticket_viewholder, position: Int) {
        val ticket: ticket_icare = ticketlist[position]
        Picasso.with(context).load(constant.IMG_URL_ICARE + ticket.photo.medium).into(holder.ticketimage)
        Picasso.with(context).load(constant.IMG_URL_ICARE + ticket.user_create.photo.small).placeholder(R.drawable.sana).into(holder.profileimage)
        holder.txtusername.text = ticket.user_create.name
        holder.txttgl.text = ticket.addtime
        holder.txtlikecount.text = ticket.likes
        holder.txtcommentcount.text = ticket.comment_count
        holder.txtcerita.text = ticket.cerita

        if(ticket.is_liked == "1") {
            ImageViewCompat.setImageTintList(holder.loveicon, ColorStateList.valueOf(ContextCompat.getColor(context, R.color.colorPrimary)))
        }

    }
}