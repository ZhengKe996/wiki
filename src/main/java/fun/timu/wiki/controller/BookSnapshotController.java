package fun.timu.wiki.controller;

import fun.timu.wiki.common.response.BaseResponse;
import fun.timu.wiki.common.response.StatisticResponse;
import fun.timu.wiki.service.EbookSnapshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ebook-snapshot")
public class BookSnapshotController {

    @Autowired
    private EbookSnapshotService ebookSnapshotService;

    @GetMapping("/get-statistic")
    public BaseResponse getStatistic() {
        List<StatisticResponse> statistic = ebookSnapshotService.getStatistic();
        BaseResponse<List<StatisticResponse>> result = new BaseResponse<>();
        result.setData(statistic);
        return result;
    }

    @GetMapping("/get-30-statistic")
    public BaseResponse get30Statistic() {
        List<StatisticResponse> statistic = ebookSnapshotService.get30Statistic();
        BaseResponse<List<StatisticResponse>> result = new BaseResponse<>();
        result.setData(statistic);
        return result;
    }
}
