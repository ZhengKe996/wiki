package fun.timu.wiki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fun.timu.wiki.common.request.doc.DocQueryVO;
import fun.timu.wiki.common.request.doc.DocSaveVO;
import fun.timu.wiki.common.response.DocQueryResponse;
import fun.timu.wiki.common.response.PageResponse;
import fun.timu.wiki.common.utils.CopyUtil;
import fun.timu.wiki.entity.Doc;
import fun.timu.wiki.mapper.DocMapper;
import fun.timu.wiki.service.DocService;
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
public class DocServiceImpl extends ServiceImpl<DocMapper, Doc>
        implements DocService {
    @Autowired
    private DocMapper docMapper;

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
    public void save(DocSaveVO doc) {
        Doc copy = CopyUtil.copy(doc, Doc.class);

        if (ObjectUtils.isEmpty(doc.getId())) {
            docMapper.insert(copy);
        } else {
            docMapper.updateById(copy);
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
}




