package br.com.antoniojoseuchoa.cardapioonline.repository

import android.app.Application
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import br.com.antoniojoseuchoa.cardapioonline.model.CategoriaModel
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore


class CategoriaRepository(val application: Application) {

     private val firebase = FirebaseFirestore.getInstance()


     fun lerCategorias(): MutableLiveData<List<CategoriaModel>>{

            var liveData = MutableLiveData<List<CategoriaModel>>()
            var listCategoria = mutableListOf<CategoriaModel>()

            firebase.collection("categories").addSnapshotListener{ snap, ex ->

                if(ex != null) return@addSnapshotListener


                snap?.documentChanges?.forEach {  doc ->

                    var categoria = doc.document.toObject(CategoriaModel::class.java)
                    listCategoria.add( categoria )

                    liveData.value = listCategoria
                }

            }

         return liveData

     }


     fun carregarImagemCategorias(categoria: CategoriaModel, imagemView: ImageView){

            Glide.with(application)
                .asBitmap()
                .load( categoria.image )
                .into(imagemView)

     }

}