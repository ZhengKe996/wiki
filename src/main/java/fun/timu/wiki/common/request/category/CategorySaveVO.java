package fun.timu.wiki.common.request.category;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategorySaveVO {
    private Long id;

    private Long parent;

    @NotNull(message = "【名称】不能为空")
    private String name;

    @NotNull(message = "【排序】不能为空")
    private Integer sort;
}
