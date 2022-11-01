package com.ort.tp3.ort.simulacroparcial.listener

import com.ort.tp3.ort.simulacroparcial.model.Product

interface OnProductClickedListener {

        /**
        * Se invoca cuando se selecciona un producto de la lista
        */
        fun onProductSelected(product: Product)
}