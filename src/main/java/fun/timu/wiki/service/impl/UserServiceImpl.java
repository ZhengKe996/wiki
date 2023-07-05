package fun.timu.wiki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fun.timu.wiki.common.exception.BusinessException;
import fun.timu.wiki.common.exception.BusinessExceptionCode;
import fun.timu.wiki.common.request.user.UserLoginVO;
import fun.timu.wiki.common.request.user.UserQueryVO;
import fun.timu.wiki.common.request.user.UserResetPasswordVO;
import fun.timu.wiki.common.request.user.UserSaveVO;
import fun.timu.wiki.common.response.PageResponse;
import fun.timu.wiki.common.response.UserLoginResponse;
import fun.timu.wiki.common.response.UserQueryResponse;
import fun.timu.wiki.common.utils.CopyUtil;
import fun.timu.wiki.entity.User;
import fun.timu.wiki.mapper.UserMapper;
import fun.timu.wiki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author zhengke
 * @description 针对表【user(用户)】的数据库操作Service实现
 * @createDate 2023-07-05 15:25:33
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageResponse<UserQueryResponse> list(UserQueryVO user) {
        PageHelper.startPage(user.getPage(), user.getSize());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(user.getLoginName())) {
            queryWrapper.eq(user.getLoginName() != null, "login_name", user.getLoginName());
        }

        List<User> userList = userMapper.selectList(queryWrapper);

        PageInfo<User> pageInfo = new PageInfo<>(userList);

        List<UserQueryResponse> list = CopyUtil.copyList(userList, UserQueryResponse.class);

        PageResponse<UserQueryResponse> response = new PageResponse<>();
        response.setTotal(pageInfo.getTotal());
        response.setList(list);
        return response;
    }

    @Override
    public void save(UserSaveVO user) {
        User copy = CopyUtil.copy(user, User.class);
        if (ObjectUtils.isEmpty(user.getId())) {
            // 新增操作
            User userDB = selectByLoginName(copy.getLoginName());
            if (ObjectUtils.isEmpty(userDB)) {
                userMapper.insert(copy);
            } else {
                throw new BusinessException(BusinessExceptionCode.USER_LOGIN_NAME_EXIST);// 用户名已存在
            }
        } else {
            // 更新操作(不进行修改密码操作)
            copy.setLoginName(null);
            copy.setPassword(null);
            userMapper.updateById(copy);
        }
    }

    @Override
    public User selectByLoginName(String loginName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_name", loginName);
        List<User> userList = userMapper.selectList(queryWrapper);
        if (CollectionUtils.isEmpty(userList)) {
            return null;
        } else {
            return userList.get(0);
        }
    }

    @Override
    public void delete(Long id) {
        userMapper.deleteById(id);
    }

    /**
     * 修改密码
     */
    @Override
    public void resetPassword(UserResetPasswordVO userResetPassword) {
        User copy = CopyUtil.copy(userResetPassword, User.class);
        userMapper.updateById(copy);
    }

    @Override
    public UserLoginResponse login(UserLoginVO userLogin) {
        User userDB = selectByLoginName(userLogin.getLoginName());
        if (ObjectUtils.isEmpty(userDB)) {
            throw new BusinessException(BusinessExceptionCode.LOGIN_USER_ERROR); // 用户名不存在
        } else {
            if (userDB.getPassword().equals(userLogin.getPassword())) {
                // 登录成功
                return CopyUtil.copy(userDB, UserLoginResponse.class);
            } else {
                throw new BusinessException(BusinessExceptionCode.LOGIN_USER_ERROR); // 密码错误
            }
        }
    }
}




