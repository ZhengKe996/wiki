package fun.timu.wiki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fun.timu.wiki.common.exception.BusinessException;
import fun.timu.wiki.common.exception.BusinessExceptionCode;
import fun.timu.wiki.common.request.doc.DocQueryVO;
import fun.timu.wiki.common.request.doc.DocSaveVO;
import fun.timu.wiki.common.response.DocQueryResponse;
import fun.timu.wiki.common.response.PageResponse;
import fun.timu.wiki.common.utils.CopyUtil;
import fun.timu.wiki.common.utils.RedisUtil;
import fun.timu.wiki.common.utils.RequestContext;
import fun.timu.wiki.entity.Content;
import fun.timu.wiki.entity.Doc;
import fun.timu.wiki.mapper.ContentMapper;
import fun.timu.wiki.mapper.DocMapper;
import fun.timu.wiki.service.DocService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author zhengke
 * @description 针对表【doc(文档)】的数据库操作Service实现
 * @createDate 2023-07-04 19:24:00
 */
@Service
public class DocServiceImpl extends ServiceImpl<DocMapper, Doc> implements DocService {
    @Autowired
    private DocMapper docMapper;

    @Autowired
    private ContentMapper contentMapper;

    @Resource
    public RedisUtil redisUtil;

    @Override
    public PageResponse<DocQueryResponse> list(DocQueryVO doc) {

        PageHelper.startPage(doc.getPage(), doc.getSize());
        QueryWrapper<Doc> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");
        List<Doc> selectList = docMapper.selectList(queryWrapper);

        PageInfo<Doc> info = new PageInfo<>(selectList);

        List<DocQueryResponse> list = CopyUtil.copyList(selectList, DocQueryResponse.class);

        PageResponse<DocQueryResponse> response = new PageResponse<>();
        response.setTotal(info.getTotal());
        response.setList(list);
        return response;
    }

    @Override
    public List<DocQueryResponse> all() {
        QueryWrapper<Doc> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");
        List<Doc> categoryList = docMapper.selectList(queryWrapper);
        List<DocQueryResponse> list = CopyUtil.copyList(categoryList, DocQueryResponse.class);
        return list;
    }

    @Override
    public List<DocQueryResponse> all(Long id) {
        QueryWrapper<Doc> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");
        queryWrapper.eq("ebook_id", id);

        List<Doc> categoryList = docMapper.selectList(queryWrapper);
        List<DocQueryResponse> list = CopyUtil.copyList(categoryList, DocQueryResponse.class);
        return list;
    }


    @Override
    public void save(DocSaveVO doc) {
        Doc copy = CopyUtil.copy(doc, Doc.class);
        Content content = CopyUtil.copy(doc, Content.class);

        if (ObjectUtils.isEmpty(doc.getId())) {
            doc.setViewCount(0);
            doc.setVoteCount(0);
            docMapper.insert(copy);
            content.setId(copy.getId());
            contentMapper.insert(content);
        } else {
            docMapper.updateById(copy);
            contentMapper.updateById(content);
        }
    }

    @Override
    public void delete(Long id) {
        docMapper.deleteById(id);
    }

    @Override
    public void delete(List<String> ids) {
        docMapper.deleteBatchIds(ids);
    }

    @Override
    public String findContentById(Long id) {
        Content content = contentMapper.selectById(id);
        docMapper.increaseViewCount(id);
        if (ObjectUtils.isEmpty(content)) {
            return "";
        } else {
            return content.getContent();
        }
    }

    @Override
    public void vote(Long id) {
        String ip = RequestContext.getRemoteAddr();
        if (redisUtil.validateRepeat("DOC_VOTE_" + id + "_" + ip, 5000)) {
            docMapper.increaseVoteCount(id);
        } else {
            throw new BusinessException(BusinessExceptionCode.VOTE_REPEAT);
        }
    }

    @Override
    public void updateEbookInfo() {
        docMapper.updateEbookInfo();
    }
}




