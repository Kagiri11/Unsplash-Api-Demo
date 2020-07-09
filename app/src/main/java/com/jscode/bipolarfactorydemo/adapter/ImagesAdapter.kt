package com.jscode.bipolarfactorydemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jscode.bipolarfactorydemo.data.UnSplashImage
import com.jscode.bipolarfactorydemo.databinding.ImageItemBinding

class ImagesAdapter :
    PagingDataAdapter<UnSplashImage, ImagesAdapter.ViewHolder>(ImagesAdapterDiff()) {

    class ViewHolder(private val binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ImageItemBinding.inflate(inflater)
                return ViewHolder(binding)
            }
        }

        fun bind(item: UnSplashImage?) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item= getItem(position)
        holder.bind(item)
    }
}

class ImagesAdapterDiff : DiffUtil.ItemCallback<UnSplashImage>() {
    override fun areItemsTheSame(oldItem: UnSplashImage, newItem: UnSplashImage): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UnSplashImage, newItem: UnSplashImage): Boolean {
        return newItem == oldItem
    }

}
