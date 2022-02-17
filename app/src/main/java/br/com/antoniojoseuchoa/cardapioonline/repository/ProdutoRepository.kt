package br.com.antoniojoseuchoa.cardapioonline.repository

import android.app.Application
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import br.com.antoniojoseuchoa.cardapioonline.model.CategoriaModel
import br.com.antoniojoseuchoa.cardapioonline.model.ProdutoModel
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore

class ProdutoRepository(var application: Application) {

    private val firebase = FirebaseFirestore.getInstance()

    fun lerProdutosPorCategoria(categoriaId: String): MutableLiveData<List<ProdutoModel>>{

        var liveData = MutableLiveData<List<ProdutoModel>>()
        var listProduto = mutableListOf<ProdutoModel>()

        firebase.collection("categories").document(categoriaId).collection("produtos").addSnapshotListener{ snap, ex ->
                if(ex != null) return@addSnapshotListener

                snap?.documentChanges?.forEach { doc ->
                        var produto = doc.document.toObject(ProdutoModel::class.java)
                        listProduto.add( produto )
                        liveData.value = listProduto
                }

        }

        return liveData
    }

    fun carregarImagemProduto(produto: ProdutoModel, imagemView: ImageView){

        Glide.with(application)
            .asBitmap()
            .load( produto.image )
            .into(imagemView)

    }

}