package br.com.antoniojoseuchoa.cardapioonline.viewmodel

import android.app.Application
import android.widget.ImageView
import androidx.lifecycle.AndroidViewModel
import br.com.antoniojoseuchoa.cardapioonline.model.CategoriaModel
import br.com.antoniojoseuchoa.cardapioonline.repository.CategoriaRepository

class CategoriaViewModel(application: Application): AndroidViewModel(application) {

      private val categoriaRepository = CategoriaRepository(getApplication())

      fun lerCategorias() = categoriaRepository.lerCategorias()

      fun carregarImagemCategoria(categoria: CategoriaModel, imagemView: ImageView) = categoriaRepository.carregarImagemCategorias( categoria, imagemView )

}