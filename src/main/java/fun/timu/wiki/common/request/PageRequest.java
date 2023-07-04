package fun.timu.wiki.common.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageRequest {
    @NotNull(message = "【页码】不能为空")
    @Min(value = 1, message = "【页码】不能为0")
    private int page;

    @NotNull(message = "【数据条数】不能为空")
    @Max(value = 500, message = "【数据条数】不能超过500")
    @Min(value = 1, message = "【数据条数】不能为0")
    private int size;
}
