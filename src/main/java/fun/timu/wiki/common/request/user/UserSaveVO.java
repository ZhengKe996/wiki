package fun.timu.wiki.common.request.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSaveVO {
    private Long id;

    @NotNull(message = "【用户名】不能为空")
    private String loginName;

    @NotNull(message = "【昵称】不能为空")
    private String nickname;

    @NotNull(message = "【密码】不能为空")

    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,32}$", message = "【密码】至少包含 数字和英文，长度6-32")
    private String password;
}
