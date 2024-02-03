package com.example.uasandroidlisty

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.uasandroidlisty.model.Note

class NoteAdapter(
    private val listItems: ArrayList<Note>,
    private val listener: NoteListener
): RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var textViewTitle = itemView.findViewById<TextView>(R.id.text_view_title)
        var textViewBody = itemView.findViewById<TextView>(R.id.text_view_body)
        var textViewHargaBrg = itemView.findViewById<TextView>(R.id.text_view_hargabrg)
        var textViewDiskon = itemView.findViewById<TextView>(R.id.text_view_diskon)
        var textViewHasil = itemView.findViewById<TextView>(R.id.text_view_hasil)
        var textViewKeterangan = itemView.findViewById<TextView>(R.id.text_view_keterangan)
        var textViewTotal = itemView.findViewById<TextView>(R.id.text_view_total)
    }

    interface NoteListener{
        fun OnItemClicked(note: Note)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent,false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteAdapter.NoteViewHolder, position: Int) {
        val item = listItems[position]
        holder.textViewTitle.text = "NPM: ${item.title}"
        holder.textViewBody.text = "Nama: ${item.body}"
        holder.textViewHargaBrg.text = "Nilai: ${item.nilai}"
        holder.textViewDiskon.text = "Keterangan: ${item.keterangan}"
        holder.textViewHasil.text = "Jumlah SKS: ${item.jumlahsks}"
        holder.textViewKeterangan.text = "Harga SKS: Rp. ${item.hargasks}"

        val jumlahsks = item.jumlahsks.toDoubleOrNull() ?: 0.0

        val hargasks = item.hargasks.toDoubleOrNull() ?: 0.0
        val result = jumlahsks * hargasks

        holder.textViewTotal.text = "Total: Rp. $result"

        holder.itemView.setOnClickListener {
            listener.OnItemClicked(item)
        }
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}