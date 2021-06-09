package com.dicoding.picodiploma.githubuser

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class UserAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var users = arrayListOf<User>()

    override fun getCount(): Int = users.size

    override fun getItem(i: Int): Any = users[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val user = getItem(position) as User
        viewHolder.bind(user)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val photo: ImageView = view.findViewById(R.id._photo)
        private val username: TextView = view.findViewById(R.id._username)
        private val repository: TextView = view.findViewById(R.id._repository)
        private val followers: TextView = view.findViewById(R.id._followers)
        private val following: TextView = view.findViewById(R.id._following)

        internal fun bind(user: User) {
            Glide.with(context).load(user.photo).override(200, 200).into(photo)
            username.text = user.username
            repository.text = user.repository
            followers.text = user.followers
            following.text = user.following

        }
    }
}