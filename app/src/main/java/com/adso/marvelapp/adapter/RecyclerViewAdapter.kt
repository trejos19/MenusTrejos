package com.adso.marvelapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.adso.marvelapp.R
import com.adso.marvelapp.model.Superheroe
import com.bumptech.glide.Glide

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {



    var superheroe: MutableList<Superheroe> = ArrayList()
    lateinit  var context: Context
    lateinit var miListener: onItemClickListner

    fun RecyclerViewAdapter(superheroe: MutableList<Superheroe>, context: Context){
        this.superheroe = superheroe
        this.context = context

        }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return  ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_superheroe, parent, false), miListener)
    }

    override fun getItemCount(): Int {
        return superheroe.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = superheroe.get(position)
        //holder.bindingAdapterPosition
        holder.bind(item, context)
    }

    class ViewHolder(view: View, listener: onItemClickListner):RecyclerView.ViewHolder(view) {
        val superheroeName = view.findViewById<TextView>(R.id.tvSuperhero)
        val realName = view.findViewById<TextView>(R.id.tvRealName)
        val publisher = view.findViewById<TextView>(R.id.tvPublisher)
        val foto = view.findViewById<ImageView>(R.id.ivAvatar)

        fun bind(superheroe: Superheroe, context: Context){
            superheroeName.text = superheroe.nombre
            realName.text = superheroe.nombreReal
            publisher.text = superheroe.publisher
            foto.loadImage(superheroe.foto)
        }
         fun ImageView.loadImage(url:String){
             Glide.with(context).load(url).into(this)

         }
        init{
            view.setOnClickListener {
                listener.onItemClickListener(bindingAdapterPosition)
            }
        }

    }

    interface onItemClickListner{
        fun onItemClickListener(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListner){
        miListener = listener

    }

}