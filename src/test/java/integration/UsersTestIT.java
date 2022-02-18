package integration;

import integration.util.dto.seedStaticMethods.UserSeeds;
import integration.util.dto.UserInfo.User;
import integration.util.dto.utils.RestUtils;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class UsersTestIT {
    private static final String GET_USERS = "https://reqres.in/api/users/{id}";
    private static final String POST_USER = "https://reqres.in/api/users";
    private static final User STATIC_DATA = User.builder().build();


    @Test
    @Tag("SeededData")
    public void getTest(){
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("id", UserSeeds.GET_SINGLE_USER.getId());

        Response user = RestUtils.get(GET_USERS, pathParams);
        Assertions.assertEquals(200, user.getStatusCode());

        JSONObject response = new JSONObject(user.getBody().asString());

        Assertions.assertEquals(STATIC_DATA.getId(), response.getJSONObject("data").get("id"));
        Assertions.assertEquals(STATIC_DATA.getEmail(), response.getJSONObject("data").get("email"));
        Assertions.assertEquals(STATIC_DATA.getFirstName(), response.getJSONObject("data").get("first_name"));
        Assertions.assertEquals(STATIC_DATA.getLastName(), response.getJSONObject("data").get("last_name"));

        Assertions.assertEquals("https://reqres.in/#support-heading", response.getJSONObject("support").get("url"));
    }

    @Test
    public void postTest(){
        JSONObject payload = new JSONObject(UserSeeds.POST_SINGLE_USER);

        Response user = RestUtils.post(POST_USER, payload.toString());
        Assertions.assertEquals(201, user.getStatusCode());

        JSONObject response = new JSONObject(user.getBody().toString());

        System.out.println(response.getJSONArray("data"));

        //Assertions.assertEquals("Robert", response.getString("name"));
       // Assertions.assertEquals("Automation Engineer", response.getString("job"));
    }

}
