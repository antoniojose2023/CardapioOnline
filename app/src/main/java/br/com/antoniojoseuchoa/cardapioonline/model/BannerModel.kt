package br.com.antoniojoseuchoa.cardapioonline.model

data class BannerModel(
    var titulo: String,
    var imagem: String
) {

    constructor(): this("", "")
}