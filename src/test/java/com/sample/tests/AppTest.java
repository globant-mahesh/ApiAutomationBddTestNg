package com.sample.tests;

import com.sample.utility.LogConfig;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.CoreMatchers;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AppTest extends LogConfig {

    Logger logger;

    @BeforeClass
    public void setup() {
        logger = getLogger();
    }

//    @Test
//    public void shouldAnswerWithTrue() {
////        Base Url for REST webservice
//        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
////        Create HttpRequest
//        RequestSpecification httpRequest = RestAssured.given();
//// Use request method to send the request on http & get response
//        Response response = httpRequest.request(Method.GET, "/Hyderabad");
//        String responseBody = response.getBody().asString();
//        logger.info(responseBody);
//    }

    @Test
    public void verifyStatus() {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");
        logger.info(response.asString());
        int status = response.getStatusCode();
        String contentType = response.getHeader("Content-Type");
        String server = response.getHeader("Server");
        String contentEncoding = response.getHeader("Content-Encoding");
        logger.info(status + " " + contentType + " " + server + " " + contentEncoding);
        Headers headers = response.headers();
        for (Header header : headers) {
            logger.info("Key: " + header.getName() + " value: " + header.getValue());
        }
    }

//    @Test
//    public void registerUser() {
//        RestAssured.baseURI = "http://restapi.demoqa.com/customer";
//        RequestSpecification request = RestAssured.given();
//        JSONObject jsonParameters = new JSONObject();
//        jsonParameters.put("FirstName", "Viru");
//        jsonParameters.put("LastName", "Sahasrabudhe");
//        jsonParameters.put("UserName", "63userf2d3d2011");
//        jsonParameters.put("Password", "password1");
//        jsonParameters.put("Email", "ed26dff39@gmail.com");
//        request.body(jsonParameters);
//        Response response = request.post("/register");
//        ResponseBody responseBody = response.getBody();
//        RegistrationSuccessResponse responseBodyObject = responseBody.as(RegistrationSuccessResponse.class);
//        assertThat("Successcode is not correct.", responseBodyObject.SuccessCode, equalTo("OPERATION_SUCCESS"));
//        assertThat("Message is not correct.", responseBodyObject.Message, equalTo("Operation completed successfully"));
//    }

    @Test
    public void authenticateUser() {
        RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
        RequestSpecification request = RestAssured.given();
        Response response = request.get();
        assertThat("Wrong status code", response.getStatusCode(), equalTo(401));
        logger.info(response.body().asString());
    }
}
