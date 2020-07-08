package com.jscode.bipolarfactorydemo

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("goneIfNotNull")
fun goneIfNotNull(view: View, it: Any?) {
    view.visibility = if (it != null) View.GONE else View.VISIBLE
}

@BindingAdapter("imageUrl")
fun bindImage(img: ImageView, url:String?){
    url?.let {
        val uri= it.toUri().buildUpon().scheme("https").build()
        Glide.with(img.context).load(uri).into(img)
    }
}