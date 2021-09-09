package com.mateo.ejercicio1kotlin

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostView(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var nameRow : TextView = itemView.findViewById(R.id.usernameTV)
    var statusRow : TextView = itemView.findViewById(R.id.statusTV)
    var imageRow : ImageView = itemView.findViewById(R.id.imageAvatar)
    var likesRow : TextView = itemView.findViewById(R.id.likesTV)
    var heartRow : ImageButton = itemView.findViewById(R.id.heartBtn)
    var dateRow : TextView = itemView.findViewById(R.id.dateTV)

}