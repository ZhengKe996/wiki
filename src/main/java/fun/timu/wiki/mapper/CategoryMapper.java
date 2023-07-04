package fun.timu.wiki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fun.timu.wiki.entity.Category;
import org.springframework.stereotype.Repository;

/**
* @author zhengke
* @description 针对表【category(分类)】的数据库操作Mapper
* @createDate 2023-07-04 17:24:32
* @Entity wiki.entity.Category
*/
@Repository
public interface CategoryMapper extends BaseMapper<Category> {

}




