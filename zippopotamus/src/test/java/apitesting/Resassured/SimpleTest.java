package apitesting.Resassured;

import apitesting.Model.Place;
import apitesting.Model.PostCodeResponse;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;

public class SimpleTest {

    @Test
    public void TestCountry(){
        expect().body("country",equalTo("United States")).when().get("http://api.zippopotam.us/us/90210");
    }

    @Test
    public void TestPlaces(){
        expect().statusCode(200).when().get("http://api.zippopotam.us/ar/7600");
    }

    @Test
    public void TestNotNullPlaces(){
        given().when().get("http://api.zippopotam.us/ar/7600").then()
                .body("places",notNullValue());
    }

    @Test
    public void TestSizePlaces(){
        Response response = get("http://api.zippopotam.us/ar/7600");
        PostCodeResponse returned = response.getBody().as(PostCodeResponse.class);

        assertEquals(83,returned.getPlaces().size());
    }

    @Test
    public void TestPostCode(){
        given().when().get("http://api.zippopotam.us/ar/7600").then()
                .body(containsString("7600"));
    }

    @Test
    public void makeSureThatGoogleIsUp() {
        given().when().get("http://www.google.com").then().statusCode(200);
    }
}
