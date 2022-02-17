package br.com.antoniojoseuchoa.cardapioonline

import android.content.Intent
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.antoniojoseuchoa.cardapioonline.adapter.AdapterCategoria
import br.com.antoniojoseuchoa.cardapioonline.model.CategoriaModel
import br.com.antoniojoseuchoa.cardapioonline.repository.BannerRepository
import br.com.antoniojoseuchoa.cardapioonline.repository.CategoriaRepository
import br.com.antoniojoseuchoa.cardapioonline.viewmodel.BannerViewModel
import br.com.antoniojoseuchoa.cardapioonline.viewmodel.CategoriaViewModel

class MainActivity : AppCompatActivity(), AdapterCategoria.ClickCategoria {

    lateinit var rv_categorias: RecyclerView
    lateinit var tv_iv_imagem_banner: ImageView
    lateinit var tv_titulo_banner: TextView

    lateinit var adapterCategoria: AdapterCategoria


    private val categoriaViewModel by viewModels<CategoriaViewModel>()
    private val bannerViewModel by viewModels<BannerViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_categorias = findViewById(R.id.rv_categorias)
        adapterCategoria = AdapterCategoria(this, categoriaViewModel, this)
        rv_categorias.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        categoriaViewModel.lerCategorias().observe(this, Observer {
                adapterCategoria.listCategoria  = it as MutableList<CategoriaModel>
                adapterCategoria.notifyDataSetChanged()

        })

        rv_categorias.adapter = adapterCategoria


        tv_iv_imagem_banner = findViewById(R.id.iv_image_banner)
        tv_titulo_banner = findViewById(R.id.tv_titulo_banner)

        bannerViewModel.lerDadosBanner().observe(this, Observer {
                if(it != null){
                      tv_titulo_banner.text = it.titulo

                       bannerViewModel.carregarImagemBanner(it.imagem, tv_iv_imagem_banner)
                }
        })

    }

    override fun onClickCategoria(categoria: CategoriaModel) {

          var intent = Intent(this, ProdutoActivity::class.java)
          intent.putExtra("categoria", categoria)
          overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_in_left)
          startActivity( intent )

    }


}