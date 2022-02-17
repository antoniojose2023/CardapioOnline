package br.com.antoniojoseuchoa.cardapioonline

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.antoniojoseuchoa.cardapioonline.adapter.AdapterProduto
import br.com.antoniojoseuchoa.cardapioonline.model.CategoriaModel
import br.com.antoniojoseuchoa.cardapioonline.model.ProdutoModel
import br.com.antoniojoseuchoa.cardapioonline.viewmodel.CategoriaViewModel
import br.com.antoniojoseuchoa.cardapioonline.viewmodel.ProdutoViewModel

class ProdutoActivity : AppCompatActivity() {

    lateinit var rv_produtos: RecyclerView
    lateinit var seta_voltar: ImageView
    lateinit var bt_whatsapp: ImageView
    lateinit var adapterProduto: AdapterProduto

    val produtoViewModel by viewModels<ProdutoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto)

        //TODO continuar daqui - criar o banner- repository - viewModel

        rv_produtos = findViewById(R.id.rv_produtos)
        rv_produtos.layoutManager = LinearLayoutManager(this)
        adapterProduto = AdapterProduto(this, produtoViewModel)

        var categoria = intent.getSerializableExtra("categoria") as CategoriaModel

        if(categoria != null){
            produtoViewModel.lerProdutosPorCategoria(categoria.id).observe(this, Observer {
                  adapterProduto.listProduto = it as MutableList<ProdutoModel>
                  adapterProduto.notifyDataSetChanged()
            })
        }

        rv_produtos.adapter = adapterProduto

        seta_voltar = findViewById(R.id.seta_voltar)
        seta_voltar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }


        bt_whatsapp = findViewById(R.id.bt_whatsapp)
        bt_whatsapp.setOnClickListener {

            abrirWhatsapp()
        }


    }

    fun abrirWhatsapp(){

        var numero = 5588992012410

        var url = "https://api.whatsapp.com/send?phone="+numero
        var intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse( url ))
        startActivity( intent )
    }

}