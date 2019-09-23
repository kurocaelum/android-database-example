package android.imd.databaseexample.repository.sqlite

import android.imd.databaseexample.model.Produto

interface ProdutoRepository {
    fun save(produto: Produto)
    fun remove(vararg produtos: Produto)
    fun produtoById(id: Long, callback: (Produto?) -> Unit)
    fun search(term: String, callback: (List<Produto>) -> Unit)
}