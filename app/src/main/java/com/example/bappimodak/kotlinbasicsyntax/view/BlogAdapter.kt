package com.example.bappimodak.kotlinbasicsyntax.view

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.bappimodak.kotlinbasicsyntax.R
import com.example.bappimodak.kotlinbasicsyntax.model.NicePlaces


class BlogAdapter(val blogList: List<NicePlaces>?) : RecyclerView.Adapter<BlogAdapter.ViewHolder>() {

    override fun getItemCount() = blogList!!.size

    private var mContext: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        this.mContext = parent.context;

        return ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.blog_item,
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val mBlog = blogList!!.get(position);

        if (mBlog.url!= null) {
            Glide.with(mContext!!)
                    .load(mBlog.url)
                    .into(holder.ivThumbnail);
        }
        if (mBlog.name!= null) {
            holder.tvTitle.setText(mBlog.name);
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivThumbnail: ImageView = itemView.findViewById(R.id.ivThumbnail);
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle);
    }
}