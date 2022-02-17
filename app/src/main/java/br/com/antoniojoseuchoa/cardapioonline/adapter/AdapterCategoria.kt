package br.com.antoniojoseuchoa.cardapioonline.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import br.com.antoniojoseuchoa.cardapioonline.R
import br.com.antoniojoseuchoa.cardapioonline.model.CategoriaModel
import br.com.antoniojoseuchoa.cardapioonline.viewmodel.CategoriaViewModel

class AdapterCategoria(var context: Context, var categoriaViewModel: CategoriaViewModel, var clickCategoria: ClickCategoria): RecyclerView.Adapter<AdapterCategoria.ViewHolderCategoria>() {

    var listCategoria = mutableListOf<CategoriaModel>()
    var clickCategoriaListener = clickCategoria

    class ViewHolderCategoria(var itemView: View): RecyclerView.ViewHolder(itemView){

        var imageView: ImageView = itemView.findViewById(R.id.iv_imagem_item_categoria)
        var nomeCategoria: TextView = itemView.findViewById(R.id.tv_nome_item_categoria)
        var item_categoria: CardView = itemView.findViewById(R.id.item_card_categoria)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCategoria {
        var view = LayoutInflater.from(context).inflate(R.layout.item_categoria, parent, false)
        return ViewHolderCategoria( view )

    }

    override fun onBindViewHolder(holder: ViewHolderCategoria, position: Int) {

        var categoria = listCategoria[position]
        holder.nomeCategoria.text = categoria.nome

        categoriaViewModel.carregarImagemCategoria( categoria, holder.imageView )

        holder.item_categoria.setOnClickListener {
                clickCategoriaListener.onClickCategoria( categoria )
        }

    }

    override fun getItemCount(): Int = listCategoria.size


    interface ClickCategoria{

        fun onClickCategoria(categoria: CategoriaModel)

    }

}