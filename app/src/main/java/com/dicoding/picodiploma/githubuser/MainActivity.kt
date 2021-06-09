package com.dicoding.picodiploma.githubuser

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView

class MainActivity : AppCompatActivity() {


    private lateinit var adapter: UserAdapter
    private lateinit var username: Array<String>
    private lateinit var repository: Array<String>
    private lateinit var followers: Array<String>
    private lateinit var following: Array<String>
    private lateinit var name: Array<String>
    private lateinit var company: Array<String>
    private lateinit var location: Array<String>
    private lateinit var photo: TypedArray
    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.list_user)
        adapter = UserAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_USER, users[position])
            startActivity(intent)
        }

    }

    private fun prepare() {
        username = resources.getStringArray(R.array.username)
        repository = resources.getStringArray(R.array.repository)
        followers = resources.getStringArray(R.array.followers)
        following = resources.getStringArray(R.array.following)
        name = resources.getStringArray(R.array.name)
        company = resources.getStringArray(R.array.company)
        location = resources.getStringArray(R.array.location)
        photo = resources.obtainTypedArray(R.array.avatar)
    }

    private fun addItem() {
        for (position in username.indices) {
            val user = User(
                photo.getResourceId(position, -1),
                username[position],
                repository[position],
                followers[position],
                following[position],
                    name[position],
                    company[position],
                    location[position]
            )
            users.add(user)
        }
        adapter.users = users
    }
}
