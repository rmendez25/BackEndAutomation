package integration.util.dto.UserInfo;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Builder.Default
    private final Integer id = 2;
    private final String email = "janet.weaver@reqres.in";
    private final String firstName = "Janet";
    private final String lastName = "Weaver";
}
