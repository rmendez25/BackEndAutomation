package integration.util.dto.preSeedData;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PreSeededUser {
    private  String id;
    private  String email;
    private  String firstName;
    private  String lastName;
    private String job;
}
