package com.example.eatup.berita_adapter
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eatup.DetailActivity
import com.example.eatup.R

class BeritaAdapter(private val newsList: List<BeritaModel.News>) :
    RecyclerView.Adapter<BeritaAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.tvw_photo)
        val titleTextView: TextView = view.findViewById(R.id.tvw_title)
        val descTextView: TextView = view.findViewById(R.id.tvw_Desc)
        val dateTextView: TextView = view.findViewById(R.id.tvw_Date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_berita, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = newsList[position]

        holder.imageView.setImageResource(news.photo)
        holder.titleTextView.text = news.title
        holder.descTextView.text = news.desc
        holder.dateTextView.text = news.date

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("photo", news.photo)
            intent.putExtra("title", news.title)
            intent.putExtra("desc", news.desc)
            intent.putExtra("date", news.date)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

}
