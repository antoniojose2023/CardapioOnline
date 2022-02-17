package br.com.antoniojoseuchoa.cardapioonline.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import br.com.antoniojoseuchoa.cardapioonline.R
import br.com.antoniojoseuchoa.cardapioonline.model.CategoriaModel
import br.com.antoniojoseuchoa.cardapioonline.model.ProdutoModel
import br.com.antoniojoseuchoa.cardapioonline.viewmodel.CategoriaViewModel
import br.com.antoniojoseuchoa.cardapioonline.viewmodel.ProdutoViewModel

class AdapterProduto(var context: Context, var produtoViewModel: ProdutoViewModel): RecyclerView.Adapter<AdapterProduto.ViewHolderProduto>() {

    var listProduto = mutableListOf<ProdutoModel>()

    class ViewHolderProduto(var itemView: View): RecyclerView.ViewHolder(itemView){

        var imageView: ImageView = itemView.findViewById(R.id.iv_iamgem_item_produto)
        var nome: TextView = itemView.findViewById(R.id.tv_nome_item_produto)
        var descricao: TextView = itemView.findViewById(R.id.tv_descricao_item_produto)
        var preco: TextView = itemView.findViewById(R.id.tv_valor_item_produto)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderProduto {
        var view = LayoutInflater.from(context).inflate(R.layout.item_produto, parent, false)
        return ViewHolderProduto( view )

    }

    override fun onBindViewHolder(holder: ViewHolderProduto, position: Int) {

        var produto = listProduto[position]
        holder.nome.text = produto.name
        holder.descricao.text = produto.description
        holder.preco.text = "R$ ${produto.price.toString()}"

        produtoViewModel.carregarImagemProduto( produto, holder.imageView)


    }

    override fun getItemCount(): Int = listProduto.size

}