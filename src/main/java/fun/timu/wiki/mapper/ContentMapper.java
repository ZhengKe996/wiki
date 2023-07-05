package fun.timu.wiki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fun.timu.wiki.entity.Content;
import org.springframework.stereotype.Repository;

/**
 * @author zhengke
 * @description 针对表【content(文档内容)】的数据库操作Mapper
 * @createDate 2023-07-05 12:36:02
 * @Entity wiki.entity.Content
 */
@Repository
public interface ContentMapper extends BaseMapper<Content> {

}




