package com.example.playground

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class BookRepository {

    fun getAll(): List<BookDto> = transaction { BookTable.selectAll().map { BookDto.fromResultRow(it) } }

    fun create(bookName: String): Int = transaction { BookTable.insertAndGetId { it[name] = bookName }.value }

    fun getBook(id: Int): BookDto {
        return transaction {
            BookTable.select { BookTable.id eq id }.limit(1).single().let { BookDto.fromResultRow(it) }
        }
    }

    fun fireToDb(): List<BookDto> =

        transaction {

            // search filter + pagination
            val baseQuery: Query = BookTable.selectAll()

            // do some cool stuff here
            listOf()
        }
}


