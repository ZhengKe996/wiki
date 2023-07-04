package fun.timu.wiki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.timu.wiki.entity.Ebook;
import fun.timu.wiki.mapper.EbookMapper;
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
public class EbookServiceImpl extends ServiceImpl<EbookMapper, Ebook>
        implements EbookService {
    @Autowired
    private EbookMapper ebookMapper;

    public List<Ebook> list(String name) {
        QueryWrapper<Ebook> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", name);

        return list(queryWrapper);
    }

}




