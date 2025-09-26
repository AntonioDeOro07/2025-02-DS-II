package com.parcial.uno.parcial_uno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParcialUnoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParcialUnoApplication.class, args);
	}

}

/* 

1. GET todos los libros
Método: GET -URL: http://localhost:9000/api/books - Lista de libros en JSON 

2. POST crear libro
Método: POST - URL: http://localhost:9000/api/books
Body → raw → JSON:
{
  "bookId": "test001",
  "isbn": "9876543210",
  "name": "Spring Boot para principiantes",
  "available": true,
  "amount": 10
}

3. GET por ID
Método: GET -URL: http://localhost:9000/api/books/test001

4. PUT actualizar libro
Método: PUT - URL: http://localhost:9000/api/books/test001
Body → raw → JSON:
{
  "bookId": "test001",
  "isbn": "9876543210",
  "name": "Spring Boot avanzado",
  "available": false,
  "amount": 7
}

5. DELETE libro
Método: DELETE - URL: http://localhost:9000/api/books/test001

6. BUSCAR POR ISBN
Método: GET - URL: http://localhost:9000/api/books/isbn/9876543210

*/
