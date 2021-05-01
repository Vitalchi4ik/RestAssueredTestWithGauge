package steps;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import config.SearchBreweriesConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.List;
import static action.Actions.*;
import static config.BreweryEndpoints.PATH_PARAM;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class StepImplementationBrewery extends SearchBreweriesConfig {

    @Step("Sent request for getting breweries <table>")
    public void verifyResponseCode(Table codeExamples) {
        verifyRowValues(codeExamples, "URL", "status");
    }

    @Step("First name of breweries search result is <Brewery name>")
    public void getFirstBreweryName(String breweryName) {
        given().when().get(PATH_PARAM).then().body("name[0]", equalTo(breweryName));
    }

    @Step("Last name of breweries search result is <Brewery name>")
    public void getLastBreweryName(String breweryName) {
        given().when().get(PATH_PARAM).then().body(getLastValue("name"), equalTo(breweryName));
    }

    @Step("Response code should be <response code>")
    public void getFirstBreweryName(int responseCode) {
        int actualResult = get().getStatusCode();
        int expectedResult = 200;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Step("Extract 10 breweries name <table>")
    public void extract10BreweriesName(Table breweriesName) {
        Response response = given().when().get(PATH_PARAM).then().extract().response();
        List<String> allNames = response.path("name");
        List<String> firstTenNames = searchInTable(breweriesName, "NAME");
        for (int i = 0; i < firstTenNames.size(); i++) {
            Assert.assertEquals(allNames.get(i), firstTenNames.get(i));
        }
    }

    @Step("Extract headers of <Content-Type> is equal to <application type>")
    public void extractHeaders(String stringHeaders, String contentType) {
        Response response = given().when().get(PATH_PARAM).then().contentType(ContentType.JSON).extract().response();
        Headers headers = response.getHeaders();
        String expectedResult = contentType;
        String actualResult = response.getHeader(stringHeaders);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Step("Check that max value <param> is <data>")
    public void extractMaxCreatedAt(String value, String maxData) {
        Response response = get(PATH_PARAM);
        String maxCreated = response.path("max { it." + value + " }." + value);
        String expected = maxData;
        Assert.assertEquals(expected, maxCreated);
    }

    @Step("Check that min value <param> is <data>")
    public void extractMinCreatedAt(String value, String minData) {
        Response response = get(PATH_PARAM);
        String minCreated = response.path("min { it." + value + " }." + value);
        String expected = minData;
        Assert.assertEquals(expected, minCreated);
    }

    @Step("Extract response <parameter1> with <value1> and <parameter2> with <value2>")
    public void extractMapOfObjectWithFindValues(String brewery_type, String type, String state, String nameOfState) {
        map = extractMapOfObjects(brewery_type, type, state, nameOfState);
    }

    @Step("Name <name> with id <id> from response of search result")
    public void findNameFromMap(String name, int id) {
        findNameWithIdFromMap(map, name, id);
    }
}