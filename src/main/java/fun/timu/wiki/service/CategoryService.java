package fun.timu.wiki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import fun.timu.wiki.common.request.category.CategoryQueryVO;
import fun.timu.wiki.common.request.category.CategorySaveVO;
import fun.timu.wiki.common.response.CategoryQueryResponse;
import fun.timu.wiki.common.response.PageResponse;
import fun.timu.wiki.entity.Category;

/**
* @author zhengke
* @description 针对表【category(分类)】的数据库操作Service
* @createDate 2023-07-04 17:24:32
*/
public interface CategoryService extends IService<Category> {
    public PageResponse<CategoryQueryResponse> list(CategoryQueryVO category);

    public void save(CategorySaveVO category);

    public void delete(Long id);
}
