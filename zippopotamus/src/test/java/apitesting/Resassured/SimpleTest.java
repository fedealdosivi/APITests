package apitesting.Resassured;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.Test;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

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
    public void TestPostCode(){
        given().when().get("http://api.zippopotam.us/ar/7600").then()
                .body(containsString("7600"));
    }

    @Test
    public void makeSureThatGoogleIsUp() {
        given().when().get("http://www.google.com").then().statusCode(200);
    }
}
