package fun.timu.wiki.common.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageResponse<T> {
    private long total;

    private List<T> list;

}
