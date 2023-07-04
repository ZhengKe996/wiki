package fun.timu.wiki.common.request.ebook;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EbookSaveVO implements Serializable {
    private Long id;
    /**
     * 名称
     */
    private String name;

    /**
     * 分类1
     */
    private Long category1Id;

    /**
     * 分类2
     */
    private Long category2Id;

    /**
     * 描述
     */
    private String description;

    /**
     * 封面
     */
    private String cover;

    /**
     * 文档数
     */
    private Integer docCount;

    /**
     * 阅读数
     */
    private Integer viewCount;

    /**
     * 点赞数
     */
    private Integer voteCount;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}