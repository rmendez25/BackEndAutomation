package integration.util.dto.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestUtils {


    private static void setUp(){
        RestAssured.reset();
    }

    public static Response get(String url){
        setUp();

        return given()
                .contentType("application/json")
                .get(url)
                .then()
                .log().ifError()
                .extract().response();
    }

    public static Response get(String url, Map<String, String> pathParams){
        setUp();

        return given()
                .contentType("application/json")
                .pathParams(pathParams)
                .get(url)
                .then()
                .log().ifError()
                .extract().response();
    }

    public static Response delete(String url, Map<String, String> pathParams){
        setUp();

        return given()
                .contentType("application/json")
                .pathParams(pathParams)
                .delete(url)
                .then()
                .log().ifError()
                .extract().response();
    }

    public static  Response post(String url, Map<String, String> pathParams){
        setUp();

        return given()
                .contentType("application/json")
                .pathParams(pathParams)
                .post(url)
                .then()
                .log().ifError()
                .extract().response();
    }

    public static  Response post(String url, String payload){
        setUp();

        return given()
                .contentType("application/json")
                .body(payload)
                .post(url)
                .then()
                .log().ifError()
                .extract().response();
    }

    public static  Response post(String url, Map<String, String> pathParams, String payload){
        setUp();

        return given()
                .contentType("application/json")
                .pathParams(pathParams)
                .body(payload)
                .post(url)
                .then()
                .log().ifError()
                .extract().response();
    }

    public static  Response patch(String url, Map<String, String> pathParams, String payload){
        setUp();

        return given()
                .contentType("application/json")
                .pathParams(pathParams)
                .body(payload)
                .post(url)
                .then()
                .log().ifError()
                .extract().response();
    }

    public static  Response put(String url, Map<String, String> pathParams, String payload){
        setUp();

        return given()
                .contentType("application/json")
                .pathParams(pathParams)
                .body(payload)
                .post(url)
                .then()
                .log().ifError()
                .extract().response();
    }
}
