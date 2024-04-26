package com.adso.marvelapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adso.marvelapp.adapter.RecyclerViewAdapter
import com.adso.marvelapp.data.DataSource
import com.adso.marvelapp.databinding.ActivityMainBinding
import com.adso.marvelapp.model.Superheroe
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var miRecycler: RecyclerView
    val miAdapter: RecyclerViewAdapter =  RecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cargarRecycler()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menus, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_senttigs->
                Log.d("OptionsMenu", "Click en herramientas")
            R.id.item_logout->
                Log.d("Otros", "Click aqui")
        }
        return true
    }



    fun cargarRecycler(){
        miRecycler = binding.SuperHeroes
        miRecycler.setHasFixedSize(true)
        miRecycler.layoutManager = LinearLayoutManager( this)
        miAdapter.RecyclerViewAdapter(DataSource().getSuperHeroes(), this)
        miRecycler.adapter = miAdapter
        miAdapter.setOnItemClickListener(object :RecyclerViewAdapter.onItemClickListner {
            override fun onItemClickListener(position: Int) {
                /* Toast.makeText(this@MainActivity,"se selecciono el item: "+
                "$position",Toast.LENGTH_SHORT).show()*/

                val intent = Intent(this@MainActivity, DetalleItem::class.java)
                intent.putExtra("nombre", DataSource().getSuperHeroes().get(position).nombre)
                intent.putExtra("nombreReal", DataSource().getSuperHeroes().get(position).nombreReal)
                intent.putExtra("publisher", DataSource().getSuperHeroes().get(position).publisher)
                intent.putExtra("imagen", DataSource().getSuperHeroes().get(position).foto)
                startActivity(intent)
                Log.d("nombre heroe", DataSource().getSuperHeroes().get(position).nombre)

            }

        })


    }

}















