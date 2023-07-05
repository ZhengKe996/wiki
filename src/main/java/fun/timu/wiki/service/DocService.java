package fun.timu.wiki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import fun.timu.wiki.common.request.doc.DocQueryVO;
import fun.timu.wiki.common.request.doc.DocSaveVO;
import fun.timu.wiki.common.response.DocQueryResponse;
import fun.timu.wiki.common.response.PageResponse;
import fun.timu.wiki.entity.Doc;

import java.util.List;

/**
 * @author zhengke
 * @description 针对表【doc(文档)】的数据库操作Service
 * @createDate 2023-07-04 19:24:00
 */
public interface DocService extends IService<Doc> {
    public PageResponse<DocQueryResponse> list(DocQueryVO doc);

    public List<DocQueryResponse> all();

    public List<DocQueryResponse> all(Long id);

    public String findContentById(Long id);

    public void save(DocSaveVO doc);

    public void delete(Long id);

    public void delete(List<String> ids);
}
