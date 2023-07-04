package fun.timu.wiki.controller;

import fun.timu.wiki.common.request.ebook.EbookSaveVO;
import fun.timu.wiki.common.response.EbookQueryResponse;
import fun.timu.wiki.common.response.PageResponse;
import fun.timu.wiki.common.request.ebook.EbookQueryVO;
import fun.timu.wiki.common.response.BaseResponse;
import fun.timu.wiki.service.EbookService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ebook")
public class EbookController {
    @Autowired
    private EbookService ebookService;

    @GetMapping("/list")
    public BaseResponse list(EbookQueryVO ebook) {
        BaseResponse<PageResponse<EbookQueryResponse>> result = new BaseResponse<>();
        PageResponse<EbookQueryResponse> list = ebookService.list(ebook);
        result.setData(list);
        return result;
    }

    @PostMapping("/save")
    public BaseResponse save(@RequestBody EbookSaveVO ebook) {
        BaseResponse result = new BaseResponse<>();
        System.out.println(ebook.toString());
        ebookService.save(ebook);
        result.setMessage("新增成功");
        return result;
    }

    @PatchMapping("/update")
    public BaseResponse update(@RequestBody EbookSaveVO ebook) {
        BaseResponse result = new BaseResponse<>();
        ebookService.save(ebook);
        result.setMessage("更新成功");
        return result;
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse delete(@PathVariable Long id) {
        BaseResponse result = new BaseResponse<>();
        ebookService.delete(id);
        result.setMessage("删除成功");
        return result;
    }
}
