package fun.timu.wiki.controller;

import com.alibaba.fastjson.JSONObject;
import fun.timu.wiki.common.request.user.UserLoginVO;
import fun.timu.wiki.common.request.user.UserQueryVO;
import fun.timu.wiki.common.request.user.UserResetPasswordVO;
import fun.timu.wiki.common.request.user.UserSaveVO;
import fun.timu.wiki.common.response.BaseResponse;
import fun.timu.wiki.common.response.PageResponse;
import fun.timu.wiki.common.response.UserLoginResponse;
import fun.timu.wiki.common.response.UserQueryResponse;
import fun.timu.wiki.common.utils.SnowFlake;
import fun.timu.wiki.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SnowFlake snowFlake;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/list")
    public BaseResponse list(@Valid UserQueryVO user) {
        BaseResponse<PageResponse<UserQueryResponse>> result = new BaseResponse<>();
        PageResponse<UserQueryResponse> list = userService.list(user);
        result.setData(list);
        result.setMessage("查询成功");
        return result;
    }

    @PostMapping("/save")
    public BaseResponse save(@Valid @RequestBody UserSaveVO user) {
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes())); // 对密码进行MD5加密
        BaseResponse<UserQueryResponse> result = new BaseResponse<>();
        userService.save(user);
        result.setMessage("新增成功");
        return result;
    }

    @PatchMapping("/update")
    public BaseResponse update(@Valid @RequestBody UserSaveVO user) {
        BaseResponse result = new BaseResponse<>();
        userService.save(user);
        result.setMessage("更新成功");
        return result;
    }


    @DeleteMapping("/delete/{id}")
    public BaseResponse delete(@PathVariable Long id) {
        BaseResponse result = new BaseResponse<>();
        userService.delete(id);
        result.setMessage("删除成功");
        return result;
    }

    @PostMapping("/reset-password")
    public BaseResponse resetPassword(@Valid @RequestBody UserResetPasswordVO userResetPassword) {
        userResetPassword.setPassword(DigestUtils.md5DigestAsHex(userResetPassword.getPassword().getBytes()));
        BaseResponse result = new BaseResponse<>();
        userService.resetPassword(userResetPassword);
        result.setMessage("密码修改成功");
        return result;
    }

    @PostMapping("/login")
    public BaseResponse login(@Valid @RequestBody UserLoginVO userLogin) {
        userLogin.setPassword(DigestUtils.md5DigestAsHex(userLogin.getPassword().getBytes()));
        UserLoginResponse login = userService.login(userLogin);

        Long token = snowFlake.nextId(); // 生成token
        login.setToken(token.toString());

        redisTemplate.opsForValue().set(token.toString(), JSONObject.toJSONString(login), 3600 * 24, TimeUnit.SECONDS); // 设置Token过期时间

        BaseResponse result = new BaseResponse<>();
        result.setData(login);
        result.setMessage("登录成功");
        return result;
    }

    @GetMapping("/logout/{token}")
    public BaseResponse logout(@PathVariable String token) {
        redisTemplate.delete(token); // 用户登出
        BaseResponse result = new BaseResponse<>();
        result.setMessage("登出成功");
        return result;
    }

}