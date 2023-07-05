package fun.timu.wiki.common.request.user;

import fun.timu.wiki.common.request.PageRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserQueryVO extends PageRequest {
    private String loginName;
}
