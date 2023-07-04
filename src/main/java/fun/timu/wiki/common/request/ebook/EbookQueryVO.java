package fun.timu.wiki.common.request.ebook;

import fun.timu.wiki.common.request.PageRequest;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EbookQueryVO extends PageRequest implements Serializable {

    private Long id;
    private Long categoryId1;
    private Long categoryId2;
    private String name;
}