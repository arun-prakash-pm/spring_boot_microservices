package com.ap.microservices.product_service;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

//@Import(TestcontainersConfiguration.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {
//
//	@ServiceConnection
//	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");
//
//
//	@LocalServerPort
//	private int port;
//
//	@BeforeEach
//	void setup() {
//		RestAssured.baseURI = "http://localhost:8989";
//		RestAssured.port = port;
//	}
//
//	static {
//		mongoDBContainer.start();
//	}
//
//	@Test
//	void createProduct() {
//		String requestBody = """
//            {
//                "name": "iPhone 15",
//                "description": "iPhone 15 is a smartphone from Apple",
//                "price": 1000
//            }
//        """;
//
//		System.out.println("I'm here...");
//
//		RestAssured.given()
//				.contentType("application/json")
//				.body(requestBody)
//				.when()
//				.post("/api/products") // ✅ ADD leading slash here
//				.then()
//				.statusCode(201)
//				.body("id", Matchers.notNullValue())
//				.body("name", Matchers.equalTo("iPhone 15"))
//				.body("description", Matchers.equalTo("iPhone 15 is a smartphone from Apple"))
//				.body("price", Matchers.equalTo(1000));
	//}
}
