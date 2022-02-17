package br.com.antoniojoseuchoa.cardapioonline.model

import java.io.Serializable

data class CategoriaModel(
    var id: String,
    var nome: String,
    var image: String): Serializable {

      constructor(): this("", "","")
}