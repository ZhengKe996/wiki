package fun.timu.wiki.common.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocQueryResponse {
    private Long id;

    private Long ebookId;

    private Long parent;

    private String name;

    private Integer sort;

    private Integer viewCount;

    private Integer voteCount;

}
