package fun.timu.wiki.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Common<T> {
    /**
     * 业务上的成功或失败
     */
    private boolean success = true;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回泛型数据，自定义类型
     */
    private T data;

}
