package config;

import com.thoughtworks.gauge.BeforeSuite;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.lessThan;

public class SearchBreweriesConfig {

    public static RequestSpecification brewRequestSpec;
    public static ResponseSpecification brewResponseSpec;

    @BeforeSuite
    public static void setUp(){
        brewRequestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.openbrewerydb.org/")
                .addFilter(new RequestLoggingFilter())
                .build();

        brewResponseSpec = new ResponseSpecBuilder()
                .expectResponseTime(lessThan(3000L))
                .build();
        RestAssured.requestSpecification = brewRequestSpec;
        RestAssured.responseSpecification = brewResponseSpec;
    }
}
