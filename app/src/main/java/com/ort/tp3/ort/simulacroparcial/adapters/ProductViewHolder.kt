package com.ort.tp3.ort.simulacroparcial.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ort.tp3.ort.simulacroparcial.R
import com.ort.tp3.ort.simulacroparcial.model.Product
import com.bumptech.glide.Glide

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    private val description: TextView
    private val price: TextView
    private val image: ImageView

    init {
        description = itemView.findViewById(R.id.product_description_text)
        price = itemView.findViewById(R.id.product_price_text)
        image = itemView.findViewById(R.id.product_image)
    }

    fun bind(product: Product) {
        description.text = product.description
        price.text = "$${product.price}"

        Glide.with(itemView)
            .load(product.imageLink)
            .into(image)
    }
}