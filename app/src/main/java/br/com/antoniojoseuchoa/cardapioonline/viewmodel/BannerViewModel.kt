package br.com.antoniojoseuchoa.cardapioonline.viewmodel

import android.app.Application
import android.widget.ImageView
import androidx.lifecycle.AndroidViewModel
import br.com.antoniojoseuchoa.cardapioonline.repository.BannerRepository

class BannerViewModel(application: Application): AndroidViewModel(application) {

    private val bannerRepository = BannerRepository(getApplication())

    fun lerDadosBanner() = bannerRepository.lerDadosBanner()

    fun carregarImagemBanner(url: String, imageView: ImageView) = bannerRepository.carregarImagemBanner(url, imageView)

}