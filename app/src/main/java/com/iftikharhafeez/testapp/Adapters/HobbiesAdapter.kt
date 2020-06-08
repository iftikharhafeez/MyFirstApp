package com.iftikharhafeez.testapp.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iftikharhafeez.testapp.Models.Hobby
import com.iftikharhafeez.testapp.R
import com.iftikharhafeez.testapp.showToast
import kotlinx.android.synthetic.main.list_view.view.*

class HobbiesAdapter(val context: Context, val hobbies: List<Hobby>) :
    RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

    companion object {
        val TAG : String= HobbiesAdapter::class.java.simpleName
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_view, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currentHobby: Hobby? = null
        var currentposition: Int = 0

        init {
            itemView.setOnClickListener {

                currentHobby?.let {
                    context.showToast(it.title + "Clicked! ")
                }
                itemView.imgShare.setOnClickListener {

                    currentHobby?.let {
                        val message: String = "my hobby is : " + currentHobby!!.title
                        val intent = Intent()
                        intent.action = Intent.ACTION_SEND
                        intent.putExtra(Intent.EXTRA_TEXT, message)
                        intent.type = "text/plain"

                        context.startActivity(Intent.createChooser(intent, "share to : "))
                    }
                }
            }

        }
        fun setData(hobby: Hobby?, pos: Int) {

            hobby?.let {
                itemView.txvTitle.text = hobby.title
            }
            this.currentHobby = hobby
            this.currentposition = pos
        }
    }
}