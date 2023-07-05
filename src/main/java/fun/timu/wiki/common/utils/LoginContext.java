package fun.timu.wiki.common.utils;

import fun.timu.wiki.common.response.UserLoginResponse;

import java.io.Serializable;

public class LoginContext implements Serializable {
    private static ThreadLocal<UserLoginResponse> user = new ThreadLocal<>();

    public static UserLoginResponse getUser() {
        return user.get();
    }

    public static void setUser(UserLoginResponse user) {
        LoginContext.user.set(user);
    }
}
