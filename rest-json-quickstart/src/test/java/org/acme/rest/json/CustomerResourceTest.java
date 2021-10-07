package org.acme.rest.json;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CustomerResourceTest {

    @Test
    public void testGetEndpoint() {
        given()
          .when().get("/customers")
          .then()
             .statusCode(200);
    }

}