package com.dragon.portal.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.dragon.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dragon.portal.mapper.StatisticsArticlePvMapper;
import com.dragon.portal.domain.StatisticsArticlePv;
import com.dragon.portal.service.IStatisticsArticlePvService;

/**
 * 统计 - 文章 PV (浏览量)Service业务层处理
 * 
 * @author dragon
 * @date 2024-07-20
 */
@Service
public class StatisticsArticlePvServiceImpl implements IStatisticsArticlePvService {
    @Autowired
    private StatisticsArticlePvMapper statisticsArticlePvMapper;

    /**
     * 查询统计 - 文章 PV (浏览量)
     * 
     * @param id 统计 - 文章 PV (浏览量)主键
     * @return 统计 - 文章 PV (浏览量)
     */
    @Override
    public StatisticsArticlePv selectStatisticsArticlePvById(Long id) {
        return statisticsArticlePvMapper.selectStatisticsArticlePvById(id);
    }

    /**
     * 查询统计 - 文章 PV (浏览量)列表
     * 
     * @param statisticsArticlePv 统计 - 文章 PV (浏览量)
     * @return 统计 - 文章 PV (浏览量)
     */
    @Override
    public List<StatisticsArticlePv> selectStatisticsArticlePvList(StatisticsArticlePv statisticsArticlePv) {
        return statisticsArticlePvMapper.selectStatisticsArticlePvList(statisticsArticlePv);
    }

    /**
     * 新增统计 - 文章 PV (浏览量)
     * 
     * @param statisticsArticlePv 统计 - 文章 PV (浏览量)
     * @return 结果
     */
    @Override
    public int insertStatisticsArticlePv(StatisticsArticlePv statisticsArticlePv) {
        statisticsArticlePv.setCreateTime(DateUtils.getNowDate());
        return statisticsArticlePvMapper.insertStatisticsArticlePv(statisticsArticlePv);
    }

    /**
     * 修改统计 - 文章 PV (浏览量)
     * 
     * @param statisticsArticlePv 统计 - 文章 PV (浏览量)
     * @return 结果
     */
    @Override
    public int updateStatisticsArticlePv(StatisticsArticlePv statisticsArticlePv) {
        statisticsArticlePv.setUpdateTime(DateUtils.getNowDate());
        return statisticsArticlePvMapper.updateStatisticsArticlePv(statisticsArticlePv);
    }

    /**
     * 批量删除统计 - 文章 PV (浏览量)
     * 
     * @param ids 需要删除的统计 - 文章 PV (浏览量)主键
     * @return 结果
     */
    @Override
    public int deleteStatisticsArticlePvByIds(Long[] ids) {
        return statisticsArticlePvMapper.deleteStatisticsArticlePvByIds(ids);
    }

    /**
     * 删除统计 - 文章 PV (浏览量)信息
     * 
     * @param id 统计 - 文章 PV (浏览量)主键
     * @return 结果
     */
    @Override
    public int deleteStatisticsArticlePvById(Long id) {
        return statisticsArticlePvMapper.deleteStatisticsArticlePvById(id);
    }

    /**
     * 当日文章 PV 访问量 +1
     * @param currDate
     */
    @Override
    public void increasePVCount(LocalDate currDate) {
        StatisticsArticlePv statisticsArticlePv = new StatisticsArticlePv();
        statisticsArticlePv.setPvDate(currDate);
        // 当日文章 PV 访问量 +1
        int count = statisticsArticlePvMapper.increasePVCount(statisticsArticlePv);
        // 如果更新数据为零则新增数据
        if (Objects.equals(0, count)) {
            statisticsArticlePv.setPvCount(1L);
            this.insertStatisticsArticlePv(statisticsArticlePv);
        }
    }
}
