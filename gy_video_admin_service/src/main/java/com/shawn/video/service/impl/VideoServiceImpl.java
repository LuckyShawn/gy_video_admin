package com.shawn.video.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shawn.video.idworker.Sid;
import com.shawn.video.mapper.BgmMapper;
import com.shawn.video.pojo.Bgm;
import com.shawn.video.pojo.BgmExample;
import com.shawn.video.service.VideoService;
import com.shawn.video.utils.PagedResult;
import com.sun.tools.internal.xjc.reader.xmlschema.BGMBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/4/28 0028
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private BgmMapper bgmMapper;

    @Autowired
    private Sid sid;

    @Override
    public void addBgm(Bgm bgm) {
        bgm.setId(sid.nextShort());
        bgmMapper.insert(bgm);
    }

    @Override
    public PagedResult queryBgmList(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);

        BgmExample example = new BgmExample();
        List<Bgm> list = bgmMapper.selectByExample(example);
        PageInfo<Bgm> pageInfo = new PageInfo<>(list);

        PagedResult pagedResult = new PagedResult();
        pagedResult.setTotal(pageInfo.getPages());
        pagedResult.setRows(list);
        pagedResult.setPage(page);
        pagedResult.setRecords(pageInfo.getTotal());
        return pagedResult;
    }
}
