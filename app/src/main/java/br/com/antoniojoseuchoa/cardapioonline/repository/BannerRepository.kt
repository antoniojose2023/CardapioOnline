package br.com.antoniojoseuchoa.cardapioonline.repository

import android.app.Application
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import br.com.antoniojoseuchoa.cardapioonline.model.BannerModel
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore

class BannerRepository(var application: Application) {

    private val firebase = FirebaseFirestore.getInstance()

    fun lerDadosBanner(): MutableLiveData<BannerModel>{

        var liveData = MutableLiveData<BannerModel>()

        firebase.collection("banner").document("1").get().addOnCompleteListener {

            if(it != null){

                 var banner = it.result?.toObject(BannerModel::class.java)
                 liveData.value = banner

            }

        }

        return liveData

    }

    fun carregarImagemBanner(url: String, imageView: ImageView){

            Glide.with(application)
                .asBitmap()
                .load(url)
                .into( imageView )

    }

}