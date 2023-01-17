package test_backend;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;


public class Authorization extends AbstractTest2 {

    @Test
    void authorizationPositiveTest() {
        String id = given()
                .config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("multipart/form-data; boundary=----WebKitFormBoundarynUwYWreIn41MzFX8", ContentType.TEXT)))
                .multiPart("username", "GB202301271f49")
                .multiPart("password", "b71e07f1ca")
                .when()
                .post(getBaseUrl())
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .extract()
                .body()
                .jsonPath()
                .get("id")
                .toString();
        System.out.println("authorization successful. user_id:  " + id);
    }

    @Test
    void authorizationNegativeTest() {
       String error = given()
                .config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("multipart/form-data; boundary=------WebKitFormBoundaryxyUfLZF3CDo26Wsb", ContentType.TEXT)))
                .multiPart("username", "")
                .multiPart("password", "")
                .when()
                .post(getBaseUrl())
                .then()
               .statusCode(401)
               .statusLine("HTTP/1.1 401 Unauthorized")
                .extract()
                .body()
                .jsonPath()
                .get("error")
                .toString();
        System.out.println("Invalid_test with error: " + error);
    }

    @Test
    void authorizationNegativeTest2() {
       given()
                .config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("multipart/form-data; boundary=----WebKitFormBoundary2wtr2pG6VB5dSZrg", ContentType.TEXT)))
                .multiPart("username", "")
                .when()
                .post(getBaseUrl())
                .then()
               .statusCode(400)
               .statusLine("HTTP/1.1 400 Bad Request");

    }
}
