package fun.timu.wiki.common.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserQueryResponse {
    private Long id;

    private String loginName;

    private String nickname;

    private String password;
}
