package br.com.antoniojoseuchoa.cardapioonline.model

import java.io.Serializable

data class ProdutoModel(
    var name: String,
    var description: String,
    var image: String,
    var price: Double,
    var categoryId: String): Serializable {

        constructor(): this("","", "", 0.0, "")
}