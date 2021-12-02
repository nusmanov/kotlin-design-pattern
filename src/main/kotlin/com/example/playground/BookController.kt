package com.example.playground

import org.springframework.web.bind.annotation.*

@RestController
class BookController(val service: BookService) {

    @GetMapping("/book/{id}")
    fun getBook(@PathVariable id: Int) = service.getBook(id)

    @GetMapping("/books")
    fun getBook() = service.getBooks()

    @PostMapping("/book/{name}")
    fun createBook(@PathVariable name: String) = service.createBook(name)

    // test
    @GetMapping("/sim")
    fun sim() = service.simSalaBin()

    // test
    // curl -i -X POST http://localhost:8080/book/kotlin-book
    // curl localhost:8080/books

}
