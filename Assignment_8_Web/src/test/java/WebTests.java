/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import assignment_8_web.Order;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItems;
import io.restassured.http.ContentType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mathiasjepsen
 */
public class WebTests {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public WebTests() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void orderGetsAddedToQueue() {
        given().
                contentType(ContentType.JSON).
                body(gson.toJson(new Order(0, "14:02"))).
                post("http://localhost:8080/Assignment_8_web/api/pizza").
        then().
                statusCode(200);
    }

    @Test
    public void allOrdersGetReturned() {
        when().
                get("http://localhost:8080/Assignment_8_web/api/pizza")
        .then()
                .statusCode(200)
                .body("orders", hasItems());
    }

    @Test
    public void orderGetsDeletedFromQueue() {
        given().
                contentType(ContentType.JSON).
                body(gson.toJson(new Order(0, "14:02"))).
                post("http://localhost:8080/Assignment_8_web/api/pizza").
        then().
                statusCode(200);
        
        when().
                delete("http://localhost:8080/Assignment_8_web/api/pizza").
        then().
                statusCode(200);
                
    }
}
