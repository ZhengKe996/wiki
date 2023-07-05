package fun.timu.wiki.common.interceptor;

import com.alibaba.fastjson.JSON;
import fun.timu.wiki.common.exception.BusinessException;
import fun.timu.wiki.common.exception.BusinessExceptionCode;
import fun.timu.wiki.common.response.UserLoginResponse;
import fun.timu.wiki.common.utils.LoginContext;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * TokenInterceptor拦截器：登录校验，权限校验，请求日志打印
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(TokenInterceptor.class);

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 打印请求信息
        LOG.info("------------- TokenInterceptor Start -------------");
        long startTime = System.currentTimeMillis();
        request.setAttribute("requestStartTime", startTime);

        // OPTIONS请求不做校验,
        if (request.getMethod().toUpperCase().equals("OPTIONS")) {
            return true;
        }

        String path = request.getRequestURL().toString();
        LOG.info("接口登录拦截:path：{}", path);

        //获取header的token参数
        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            LOG.info("token为空，拦截请求");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            throw new BusinessException(BusinessExceptionCode.TOKEN_ERROR);
        }
        Object object = redisTemplate.opsForValue().get(token);
        if (object == null) {
            LOG.warn("无效Token，拦截请求");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            throw new BusinessException(BusinessExceptionCode.TOKEN_ERROR);
        } else {
            LOG.info("用户登录成功：{}", object);
            LoginContext.setUser(JSON.parseObject((String) object, UserLoginResponse.class));
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (Long) request.getAttribute("requestStartTime");
        LOG.info("------------- LoginInterceptor End 耗时：{} ms -------------", System.currentTimeMillis() - startTime);
    }

}
