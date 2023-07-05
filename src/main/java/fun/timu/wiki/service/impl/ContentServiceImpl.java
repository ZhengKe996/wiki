package fun.timu.wiki.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.timu.wiki.entity.Content;
import fun.timu.wiki.mapper.ContentMapper;
import fun.timu.wiki.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhengke
 * @description 针对表【content(文档内容)】的数据库操作Service实现
 * @createDate 2023-07-05 12:36:02
 */
@Service
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content>
        implements ContentService {

    @Autowired
    private ContentMapper contentMapper;

}




