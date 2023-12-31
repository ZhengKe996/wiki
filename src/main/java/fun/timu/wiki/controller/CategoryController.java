package fun.timu.wiki.controller;

import fun.timu.wiki.common.request.category.CategoryQueryVO;
import fun.timu.wiki.common.request.category.CategorySaveVO;
import fun.timu.wiki.common.response.BaseResponse;
import fun.timu.wiki.common.response.CategoryQueryResponse;
import fun.timu.wiki.common.response.PageResponse;
import fun.timu.wiki.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public BaseResponse list(@Valid CategoryQueryVO category) {
        BaseResponse<PageResponse<CategoryQueryResponse>> result = new BaseResponse<>();
        PageResponse<CategoryQueryResponse> list = categoryService.list(category);
        result.setData(list);
        result.setMessage("查询成功");
        return result;
    }


    @GetMapping("/all")
    public BaseResponse all() {
        BaseResponse<List<CategoryQueryResponse>> result = new BaseResponse<>();
        List<CategoryQueryResponse> list = categoryService.all();
        result.setData(list);
        result.setMessage("查询成功");
        return result;
    }


    @PostMapping("/save")
    public BaseResponse save(@RequestBody CategorySaveVO category) {
        BaseResponse result = new BaseResponse<>();
        categoryService.save(category);
        result.setMessage("新增成功");
        return result;
    }

    @PatchMapping("/update")
    public BaseResponse update(@RequestBody CategorySaveVO category) {
        BaseResponse result = new BaseResponse<>();
        categoryService.save(category);
        result.setMessage("更新成功");
        return result;
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse delete(@PathVariable Long id) {
        BaseResponse result = new BaseResponse<>();
        categoryService.delete(id);
        result.setMessage("删除成功");
        return result;
    }
}
