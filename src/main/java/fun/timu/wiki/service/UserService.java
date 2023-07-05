package fun.timu.wiki.service;


import com.baomidou.mybatisplus.extension.service.IService;
import fun.timu.wiki.common.request.user.UserLoginVO;
import fun.timu.wiki.common.request.user.UserQueryVO;
import fun.timu.wiki.common.request.user.UserResetPasswordVO;
import fun.timu.wiki.common.request.user.UserSaveVO;
import fun.timu.wiki.common.response.PageResponse;
import fun.timu.wiki.common.response.UserLoginResponse;
import fun.timu.wiki.common.response.UserQueryResponse;
import fun.timu.wiki.entity.User;

/**
 * @author zhengke
 * @description 针对表【user(用户)】的数据库操作Service
 * @createDate 2023-07-05 15:25:33
 */
public interface UserService extends IService<User> {
    public PageResponse<UserQueryResponse> list(UserQueryVO user);

    public void save(UserSaveVO user);

    public User selectByLoginName(String loginName);

    public void delete(Long id);

    public void resetPassword(UserResetPasswordVO userResetPassword);

    public UserLoginResponse login(UserLoginVO userLogin);

}
