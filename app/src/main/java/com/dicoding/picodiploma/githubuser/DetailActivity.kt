package com.dicoding.picodiploma.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    companion object{
        val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val photo: ImageView = findViewById(R.id._photoDetail)
        val username: TextView = findViewById(R.id.username)
        val repository: TextView = findViewById(R.id.repository)
        val followers: TextView = findViewById(R.id.followers)
        val following: TextView = findViewById(R.id.following)
        val name: TextView = findViewById(R.id.name)
        val company: TextView = findViewById(R.id.company)
        val location: TextView = findViewById(R.id.location)


        val data = intent.getParcelableExtra(EXTRA_USER) as? User


        Glide.with(this).load(data?.photo).override(200, 200).into(photo)
        username.text = data?.username
        repository.text = data?.repository
        followers.text = data?.followers
        following.text = data?.following
        name.text = data?.name
        company.text = data?.company
        location.text = data?.location


    }
}
