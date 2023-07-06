package fun.timu.wiki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import fun.timu.wiki.common.response.StatisticResponse;
import fun.timu.wiki.entity.EbookSnapshot;

import java.util.List;

/**
 * @author zhengke
 * @description 针对表【ebook_snapshot(电子书快照表)】的数据库操作Service
 * @createDate 2023-07-06 13:22:29
 */
public interface EbookSnapshotService extends IService<EbookSnapshot> {
    void genSnapshot();

    List<StatisticResponse> getStatistic();

    /**
     * 30天数值统计
     */
    List<StatisticResponse> get30Statistic();
}
