package com.adso.marvelapp

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adso.marvelapp.adapter.RecyclerViewAdapter
import com.adso.marvelapp.data.DataSource
import com.adso.marvelapp.databinding.ActivityDetalleItemBinding
import com.adso.marvelapp.databinding.ActivityMainBinding
import com.bumptech.glide.Glide
import java.net.URL

class DetalleItem : AppCompatActivity() {
    private lateinit var binding: ActivityDetalleItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cargarDetalle()
        registerForContextMenu(binding.ivAvatar)
    }

    private fun cargarDetalle() {
        var nombre: String = intent.getStringExtra("nombre").toString()
        binding.tvSuperhero.text = nombre
        var nombreReal: String = intent.getStringExtra("nombreReal").toString()
        binding.tvRealName.text = nombreReal
        var publisher: String = intent.getStringExtra("publisher").toString()
        binding.tvPublisher.text = publisher
        var foto = intent.getStringExtra("imagen")
        binding.ivAvatar.loadImage(foto.toString())


    }

    fun ImageView.loadImage(url: String) {
        Glide.with(context).load(url).into(this)
    }


    override fun onCreateContextMenu(
        menu: ContextMenu, v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {

        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        //val info = item.menuInfo
        return when (item.itemId) {
            R.id.op1 -> {
                //Log.d("Help", "En que te puedo ayudar")
                Toast.makeText(this@DetalleItem,"Clicked",Toast.LENGTH_SHORT).show()
                true
            }
            R.id.op2 -> {
                //Log.d("Help", "En que te puedo ayudar")
                Toast.makeText(this@DetalleItem,"Clicked 2",Toast.LENGTH_SHORT).show()
                true
            }

            else -> super.onContextItemSelected(item)
        }


    }


}