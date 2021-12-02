# about
kotlin playground to implement design patterns to enrich the kotlin exposed query
# run
* run the app
# test
### create a book
```curl -i -X POST http://localhost:8080/book/kotlin-book```
### get all books
```curl localhost:8080/books```
### simulate and check generated SQL queries in logs
```curl localhost:8080/sim```

# logs should look like
```
Exposed                                  : SELECT VALUE FROM INFORMATION_SCHEMA.SETTINGS WHERE NAME = 'MODE'

o.j.exposed.spring.DatabaseInitializer   : Schema generation for tables '[Book]'
o.j.exposed.spring.DatabaseInitializer   : ddl [CREATE TABLE IF NOT EXISTS BOOK (ID INT AUTO_INCREMENT PRIMARY KEY, "NAME" VARCHAR(200) NOT NULL, AUTHOR VARCHAR(200) DEFAULT 'authorRandom' NOT NULL, OBJECT_TYPE VARCHAR(200) DEFAULT 'Task' NOT NULL)]
Exposed                                  : CREATE TABLE IF NOT EXISTS BOOK (ID INT AUTO_INCREMENT PRIMARY KEY, "NAME" VARCHAR(200) NOT NULL, AUTHOR VARCHAR(200) DEFAULT 'authorRandom' NOT NULL, OBJECT_TYPE VARCHAR(200) DEFAULT 'Task' NOT NULL)
o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
o.s.web.servlet.DispatcherServlet        : Completed initialization in 0 ms
Exposed                                  : SELECT BOOK.ID, BOOK."NAME", BOOK.AUTHOR, BOOK.OBJECT_TYPE FROM BOOK
Exposed                                  : INSERT INTO BOOK (AUTHOR, "NAME", OBJECT_TYPE) VALUES ('authorRandom', 'kotlin-book', 'Task')
Exposed                                  : SELECT BOOK.ID, BOOK."NAME", BOOK.AUTHOR, BOOK.OBJECT_TYPE FROM BOOK WHERE BOOK.ID = 1 LIMIT 1
Exposed                                  : SELECT BOOK.ID, BOOK."NAME", BOOK.AUTHOR, BOOK.OBJECT_TYPE FROM BOOK
```



