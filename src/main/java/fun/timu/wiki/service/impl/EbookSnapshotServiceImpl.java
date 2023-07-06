package fun.timu.wiki.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.timu.wiki.common.response.StatisticResponse;
import fun.timu.wiki.entity.EbookSnapshot;
import fun.timu.wiki.mapper.EbookSnapshotMapper;
import fun.timu.wiki.service.EbookSnapshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhengke
 * @description 针对表【ebook_snapshot(电子书快照表)】的数据库操作Service实现
 * @createDate 2023-07-06 13:22:29
 */
@Service
public class EbookSnapshotServiceImpl extends ServiceImpl<EbookSnapshotMapper, EbookSnapshot>
        implements EbookSnapshotService {

    @Autowired
    private EbookSnapshotMapper ebookSnapshotMapper;

    @Override
    public void genSnapshot() {
        ebookSnapshotMapper.genSnapshot();
    }

    @Override
    public List<StatisticResponse> getStatistic() {
        return ebookSnapshotMapper.getStatistic();
    }

    @Override
    public List<StatisticResponse> get30Statistic() {
        return ebookSnapshotMapper.get30Statistic();
    }
}




