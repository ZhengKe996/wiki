package fun.timu.wiki.common.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryQueryResponse {
    private Long id;

    private Long parent;

    private String name;

    private Integer sort;
}
