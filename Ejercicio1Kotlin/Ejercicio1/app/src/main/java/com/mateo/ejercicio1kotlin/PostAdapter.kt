package com.mateo.ejercicio1kotlin

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate

class PostAdapter : RecyclerView.Adapter<PostView>() {

    private val posts = ArrayList<Post>();

    init {
        posts.add(Post("Andres", "Estoy en el bano!"))
    }

    fun addPost(post: Post) {
        posts.add(post)
        notifyItemInserted(posts.size-1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostView {

        var inflater = LayoutInflater.from(parent.context)

        val row = inflater.inflate(R.layout.postrow, parent, false)
        val postView = PostView(row)

        return postView
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: PostView, position: Int) {
        val post = posts[position]
        holder.nameRow.text = post.username
        holder.statusRow.text = post.status
        holder.dateRow.text = LocalDate.now().toString()
        holder.likesRow.text = ""

    }

    override fun getItemCount(): Int {
        return posts.size
    }


}