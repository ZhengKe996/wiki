package fun.timu.wiki.common.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageRequest {
    //    @NotNull(message = "【页码】不能为空")
    private int page;

    //    @NotNull(message = "【每页条数】不能为空")
//    @Max(value = 1000, message = "【每页条数】不能超过1000")
    private int size;
}
