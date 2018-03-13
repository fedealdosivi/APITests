package apitesting.Resassured;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.Test;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
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
    public void test_NumberOfCircuitsFor2017Season_ShouldBe20() {
        given().
                when().
                get("http://ergast.com/api/f1/2017/circuits.json").
                then().
                assertThat().
                body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
    }

    @Test
    public void test_ResponseHeaderData_ShouldBeCorrect() {

        given().
                when().
                get("http://ergast.com/api/f1/2017/circuits.json").
                then().
                assertThat().
                statusCode(200).
                and().
                contentType(ContentType.JSON).
                and().
                header("Content-Length",equalTo("4567"));
    }
}
