package fun.timu.wiki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fun.timu.wiki.entity.Doc;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhengke
 * @description 针对表【doc(文档)】的数据库操作Mapper
 * @createDate 2023-07-04 19:24:00
 * @Entity wiki.entity.Doc
 */
@Repository
public interface DocMapper extends BaseMapper<Doc> {
    public void increaseViewCount(@Param("id") Long id);

    public void increaseVoteCount(@Param("id") Long id);

}




