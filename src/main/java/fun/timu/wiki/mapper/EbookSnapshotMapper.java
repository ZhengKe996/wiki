package fun.timu.wiki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fun.timu.wiki.common.response.StatisticResponse;
import fun.timu.wiki.entity.EbookSnapshot;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhengke
 * @description 针对表【ebook_snapshot(电子书快照表)】的数据库操作Mapper
 * @createDate 2023-07-06 13:22:29
 * @Entity wiki.entity.EbookSnapshot
 */
@Repository
public interface EbookSnapshotMapper extends BaseMapper<EbookSnapshot> {
    void genSnapshot();

    List<StatisticResponse> getStatistic();

    List<StatisticResponse> get30Statistic();
}




