package fun.timu.wiki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fun.timu.wiki.common.response.EbookResponse;
import fun.timu.wiki.common.response.PageResponse;
import fun.timu.wiki.common.utils.CopyUtil;
import fun.timu.wiki.entity.Ebook;
import fun.timu.wiki.mapper.EbookMapper;
import fun.timu.wiki.common.request.EbookVO;
import fun.timu.wiki.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhengke
 * @description 针对表【ebook(电子书)】的数据库操作Service实现
 * @createDate 2023-07-03 19:30:52
 */
@Service
public class EbookServiceImpl extends ServiceImpl<EbookMapper, Ebook> implements EbookService {
    @Autowired
    private EbookMapper ebookMapper;

    public PageResponse<EbookResponse> list(EbookVO ebook) {
        PageHelper.startPage(ebook.getPage(), ebook.getSize());
        QueryWrapper<Ebook> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(ebook.getName() != null, "name", ebook.getName());
        List<Ebook> ebookList = ebookMapper.selectList(queryWrapper);

        PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);

        List<EbookResponse> list = CopyUtil.copyList(ebookList, EbookResponse.class);

        PageResponse<EbookResponse> response = new PageResponse<>();
        response.setTotal(pageInfo.getTotal());
        response.setList(list);
        return response;
    }
}




