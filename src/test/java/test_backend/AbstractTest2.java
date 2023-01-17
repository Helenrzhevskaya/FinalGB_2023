package test_backend;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AbstractTest2 {
    static Properties prop2 = new Properties();
    private static InputStream configFile2;
    /**protected static ResponseSpecification responseValidSpecification2;
    protected static ResponseSpecification responseInvalidSpecification2;
    protected static ResponseSpecification responseInvalid2Specification2;**/
    private static String baseUrl;

    @BeforeAll
    static void initTest() throws IOException {
        configFile2 = new FileInputStream("src/test/resources/2.properties");
        prop2.load(configFile2);
        baseUrl = prop2.getProperty("base_url");
        /**
        responseValidSpecification2 = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .build();

        responseInvalidSpecification2 = new ResponseSpecBuilder()
                .expectStatusCode(401)
                .expectStatusLine("HTTP/1.1 401 Unauthorized")
                .build();

        responseInvalid2Specification2 = new ResponseSpecBuilder()
                .expectStatusCode(401)
                .expectStatusLine("HTTP/1.1 404 Bad Request")
                .build();


        RestAssured.responseSpecification = responseValidSpecification2;
        RestAssured.responseSpecification = responseInvalidSpecification2;
        RestAssured.responseSpecification = responseInvalid2Specification2;
         **/
    }
    public static String getBaseUrl() {
        return baseUrl;
    }
}
