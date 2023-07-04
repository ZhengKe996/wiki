package fun.timu.wiki.common.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EbookResponse {
    private String name;

    private Long category1Id;


    private Long category2Id;


    private String description;


    private String cover;


    private Integer docCount;


    private Integer viewCount;


    private Integer voteCount;

}