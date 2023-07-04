package fun.timu.wiki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fun.timu.wiki.entity.Ebook;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhengke
 * @description 针对表【ebook(电子书)】的数据库操作Mapper
 * @createDate 2023-07-03 19:30:52
 * @Entity wiki.entity.Ebook
 */
@Repository
public interface EbookMapper extends BaseMapper<Ebook> {
    public List<Ebook> list();
}




