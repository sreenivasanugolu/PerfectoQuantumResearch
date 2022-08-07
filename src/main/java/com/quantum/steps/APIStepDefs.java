package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;


public class APIStepDefs {
    Response response;
    @Test
    public void testReqResTest() {
        Response res;
        res = RestAssured.given().get("https://reqres.in/api/users?page=2");
        System.out.println("Response code is : " + res.statusCode());

        System.out.println("Response : " + res.body().prettyPrint());
    }



    @Given("^I do a get in api site$")
    public void i_do_a_get_in_api_site() throws Throwable {
        //response = RestAssured.get("https://reqres.in/api/users?page=2");
        /*RequestSpecification reqSpec = new RequestSpecBuilder()
                .setBasePath("https://trial.app.perfectomobile.com/repository/api/v1/artifacts")
                .addHeader("Perfecto-Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI2ZDM2NmJiNS01NDAyLTQ4MmMtYTVhOC1kODZhODk4MDYyZjIifQ.eyJpYXQiOjE2NTg5NDY1MjAsImp0aSI6ImZmOTk0YzFhLTdlMzktNGI5NS04ZjI1LWJkMWZkNzk2NDUyYiIsImlzcyI6Imh0dHBzOi8vYXV0aDMucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL3RyaWFsLXBlcmZlY3RvbW9iaWxlLWNvbSIsImF1ZCI6Imh0dHBzOi8vYXV0aDMucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL3RyaWFsLXBlcmZlY3RvbW9iaWxlLWNvbSIsInN1YiI6IjViNjI4YzliLTA0ODMtNDI3OS1iYzM3LTc0YTA0MmRiZTIzNiIsInR5cCI6Ik9mZmxpbmUiLCJhenAiOiJvZmZsaW5lLXRva2VuLWdlbmVyYXRvciIsIm5vbmNlIjoiYTE2NzRkNDUtM2YzZC00NDJiLTg0N2MtODdmZGM5ZDhmZGNkIiwic2Vzc2lvbl9zdGF0ZSI6IjdiZWFkNDRjLTE5ZjEtNGMyZi04MWVkLTQ0YTkxMzBlMTk2ZiIsInNjb3BlIjoib3BlbmlkIG9mZmxpbmVfYWNjZXNzIHByb2ZpbGUgZW1haWwifQ.vBZ3v2suu-O5ZRu1zF7zZsxqH-YjrySs-y7dXRzrzD8")
                .addQueryParam("artifactType", "GENERAL")
                .setContentType(ContentType.JSON).build();
        response = reqSpec.get();*/

        response = RestAssured.given().get("https://reqres.in/api/users?page=2");
        System.out.println("Response code BDD is : " + response.statusCode());
    }

    @Then("^I should see details in response$")
    public void i_should_see_details_in_response() throws Throwable {
        System.out.println("Response : " + response.body().prettyPrint());
    }

}

