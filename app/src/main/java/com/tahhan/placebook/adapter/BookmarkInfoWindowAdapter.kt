package com.tahhan.placebook.adapter

import android.app.Activity
import android.graphics.Bitmap
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import com.tahhan.placebook.R

class BookmarkInfoWindowAdapter(context : Activity) : GoogleMap.InfoWindowAdapter{
    private val contents : View
    init {
        contents = context.layoutInflater.inflate(R.layout.content_bookmark_info,null)
    }
    override fun getInfoContents(marker: Marker): View? {
        // This function is required, but can return null if
        // not replacing the entire info window
        return null
    }

    override fun getInfoWindow(marker: Marker): View? {
       val titleTextView = contents.findViewById<TextView>(R.id.title)
        titleTextView.text = marker.title ?: ""
        val phoneView  = contents.findViewById<TextView>(R.id.phone)
        phoneView.text = marker.snippet ?: ""
        val imageView = contents.findViewById<ImageView>(R.id.image)
        imageView.setImageBitmap(marker.tag as Bitmap?)
        return contents
    }
}