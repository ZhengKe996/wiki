package fun.timu.wiki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import fun.timu.wiki.common.response.EbookResponse;
import fun.timu.wiki.entity.Ebook;
import fun.timu.wiki.common.request.EbookVO;

import java.util.List;

/**
 * @author zhengke
 * @description 针对表【ebook(电子书)】的数据库操作Service
 * @createDate 2023-07-03 19:30:52
 */
public interface EbookService extends IService<Ebook> {
    public List<EbookResponse> list(EbookVO ebook);
}
