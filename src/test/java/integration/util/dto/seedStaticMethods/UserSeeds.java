package integration.util.dto.seedStaticMethods;

import integration.util.dto.preSeedData.PreSeededUser;


public class UserSeeds {
    public static final PreSeededUser GET_SINGLE_USER = PreSeededUser.builder()
            .id("2")
            .build();

    public static final PreSeededUser POST_SINGLE_USER = PreSeededUser.builder()
            .firstName("Robert")
            .job("Automation Engineer")
            .build();
}
