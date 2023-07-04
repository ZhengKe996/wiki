package fun.timu.wiki.common.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EbookVO extends PageRequest implements Serializable {

    private Long id;

    private String name;
}