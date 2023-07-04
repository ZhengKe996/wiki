package fun.timu.wiki.controller;

import fun.timu.wiki.common.response.EbookResponse;
import fun.timu.wiki.entity.Ebook;
import fun.timu.wiki.common.request.EbookVO;
import fun.timu.wiki.common.response.BaseResponse;
import fun.timu.wiki.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {
    @Autowired
    private EbookService ebookService;

    @GetMapping("/list")
    public BaseResponse list(EbookVO ebook) {
        BaseResponse<List<EbookResponse>> result = new BaseResponse<>();
        List<EbookResponse> list = ebookService.list(ebook);
        result.setData(list);

        return result;
    }
}
