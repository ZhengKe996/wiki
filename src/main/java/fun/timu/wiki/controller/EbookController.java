package fun.timu.wiki.controller;

import fun.timu.wiki.entity.Ebook;
import fun.timu.wiki.mapper.EbookMapper;
import fun.timu.wiki.response.Common;
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
    public Common list(String name) {
        Common<List<Ebook>> result = new Common<>();
        List<Ebook> list = ebookService.list(name);
        result.setData(list);

        return result;
    }
}
