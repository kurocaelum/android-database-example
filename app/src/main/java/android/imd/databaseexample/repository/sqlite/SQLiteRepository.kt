package android.imd.databaseexample.repository.sqlite

import android.content.ContentValues
import android.content.Context
import android.imd.databaseexample.model.Produto

class SQLiteRepository(ctx: Context): ProdutoRepository {
    private val helper: ProdutoSqlHelper = ProdutoSqlHelper(ctx)

    private fun insert(produto: Produto){
        val db = helper.writableDatabase

        val cv = ContentValues().apply {
            put(COLUMN_NAME, produto.nome)
            put(COLUMN_VALUE, produto.valor)
        }

        val id = db.insert(TABLE_NAME, null, cv)
        if (id != -1L){
            produto.id = id
        }
        db.close()
    }

    private fun update(produto: Produto){
        val db = helper.writableDatabase

        val cv = ContentValues().apply {
            put(COLUMN_NAME, produto.nome)
            put(COLUMN_VALUE, produto.valor)
        }

        db.update(
            TABLE_NAME,
            cv,
            "$COLUMN_NAME = ? ",
            arrayOf(produto.id.toString())
        )

        db.close()
    }

    override fun save(produto: Produto) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remove(vararg produtos: Produto) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun produtoById(id: Long, callback: (Produto?) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun search(term: String, callback: (List<Produto>) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}