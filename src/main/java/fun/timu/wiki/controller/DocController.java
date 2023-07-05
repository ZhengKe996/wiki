package fun.timu.wiki.controller;

import fun.timu.wiki.common.request.doc.DocQueryVO;
import fun.timu.wiki.common.request.doc.DocSaveVO;
import fun.timu.wiki.common.response.BaseResponse;
import fun.timu.wiki.common.response.DocQueryResponse;
import fun.timu.wiki.common.response.PageResponse;
import fun.timu.wiki.service.DocService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/doc")
public class DocController {
    @Autowired
    private DocService docService;

    @GetMapping("/list")
    public BaseResponse list(@Valid DocQueryVO doc) {
        BaseResponse<PageResponse<DocQueryResponse>> result = new BaseResponse<>();
        PageResponse<DocQueryResponse> list = docService.list(doc);
        result.setData(list);
        result.setMessage("查询成功");
        return result;
    }

    @GetMapping("/all")
    public BaseResponse all() {
        BaseResponse<List<DocQueryResponse>> result = new BaseResponse<>();
        List<DocQueryResponse> list = docService.all();
        result.setData(list);
        result.setMessage("查询成功");
        return result;
    }

    @GetMapping("/find-content/${id}")
    public BaseResponse findContent(@PathVariable Long id) {
        BaseResponse<String> result = new BaseResponse<>();
        String content = docService.findContentById(id);
        result.setData(content);
        return result;
    }


    @PostMapping("/save")
    public BaseResponse save(@Valid @RequestBody DocSaveVO doc) {
        BaseResponse result = new BaseResponse<>();
        docService.save(doc);
        result.setMessage("新增成功");
        return result;
    }

    @PatchMapping("/update")
    public BaseResponse update(@Valid @RequestBody DocSaveVO doc) {
        BaseResponse result = new BaseResponse<>();
        docService.save(doc);
        result.setMessage("更新成功");
        return result;
    }

    @DeleteMapping("/delete/{ids}")
    public BaseResponse delete(@PathVariable String ids) {
        BaseResponse result = new BaseResponse<>();
        List<String> list = Arrays.asList(ids.split(","));
        docService.delete(list);
        result.setMessage("删除成功");
        return result;
    }
}
