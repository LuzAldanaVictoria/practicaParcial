package com.ort.tp3.ort.simulacroparcial.adapters

import android.view.LayoutInflater
import com.ort.tp3.ort.simulacroparcial.model.Product
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ort.tp3.ort.simulacroparcial.R
import com.ort.tp3.ort.simulacroparcial.listener.OnProductClickedListener

class ProductAdapter (
    private val productList: List<Product>,
    private val onProductClickedListener: OnProductClickedListener
    ) : RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.bind(product)
        holder.itemView.setOnClickListener {
            onProductClickedListener.onProductSelected(product)
        }
    }

    override fun getItemCount() = productList.size
}