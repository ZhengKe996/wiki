package fun.timu.wiki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fun.timu.wiki.common.request.category.CategoryQueryVO;
import fun.timu.wiki.common.request.category.CategorySaveVO;
import fun.timu.wiki.common.response.CategoryQueryResponse;
import fun.timu.wiki.common.response.PageResponse;
import fun.timu.wiki.common.utils.CopyUtil;
import fun.timu.wiki.entity.Category;
import fun.timu.wiki.mapper.CategoryMapper;
import fun.timu.wiki.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author zhengke
 * @description 针对表【category(分类)】的数据库操作Service实现
 * @createDate 2023-07-04 17:24:32
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
        implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public PageResponse<CategoryQueryResponse> list(CategoryQueryVO category) {
        PageHelper.startPage(category.getPage(), category.getSize());
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");
        List<Category> categories = categoryMapper.selectList(queryWrapper);

        PageInfo<Category> info = new PageInfo<>(categories);

        List<CategoryQueryResponse> list = CopyUtil.copyList(categories, CategoryQueryResponse.class);

        PageResponse<CategoryQueryResponse> response = new PageResponse<>();
        response.setTotal(info.getTotal());
        response.setList(list);

        return response;
    }

    @Override
    public void save(CategorySaveVO category) {
        Category copy = CopyUtil.copy(category, Category.class);

        if (ObjectUtils.isEmpty(category.getId())) {
            categoryMapper.insert(copy);
        } else {
            categoryMapper.updateById(copy);
        }
    }

    @Override
    public void delete(Long id) {
        categoryMapper.deleteById(id);
    }
}




