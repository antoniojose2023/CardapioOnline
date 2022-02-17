package br.com.antoniojoseuchoa.cardapioonline.viewmodel

import android.app.Application
import android.widget.ImageView
import androidx.lifecycle.AndroidViewModel
import br.com.antoniojoseuchoa.cardapioonline.model.CategoriaModel
import br.com.antoniojoseuchoa.cardapioonline.model.ProdutoModel
import br.com.antoniojoseuchoa.cardapioonline.repository.ProdutoRepository

class ProdutoViewModel(application: Application): AndroidViewModel(application) {

    private val produtoRepository = ProdutoRepository(getApplication())

    fun lerProdutosPorCategoria(categoria: String) = produtoRepository.lerProdutosPorCategoria( categoria )

    fun carregarImagemProduto(produto: ProdutoModel, imageView: ImageView) = produtoRepository.carregarImagemProduto(produto, imageView)

}