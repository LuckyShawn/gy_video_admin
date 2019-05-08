package com.shawn.video.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shawn.video.Enums.BGMOperatorTypeEnum;
import com.shawn.video.idworker.Sid;
import com.shawn.video.mapper.BgmMapper;
import com.shawn.video.mapper.UsersReportMapperCustom;
import com.shawn.video.mapper.VideosMapper;
import com.shawn.video.pojo.Bgm;
import com.shawn.video.pojo.BgmExample;
import com.shawn.video.pojo.Videos;
import com.shawn.video.pojo.vo.Reports;
import com.shawn.video.service.VideoService;
import com.shawn.video.service.util.ZKCurator;
import com.shawn.video.utils.JsonUtils;
import com.shawn.video.utils.PagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private ZKCurator zkCurator;

    @Autowired
    private UsersReportMapperCustom usersReportMapperCustom;

    @Autowired
    private VideosMapper videosMapper;

    @Autowired
    private Sid sid;

    @Override
    public void addBgm(Bgm bgm) {
        bgm.setId(sid.nextShort());
        bgmMapper.insert(bgm);

        Map<String,String> map = new HashMap<>();
        map.put("operType",BGMOperatorTypeEnum.ADD.type);
        map.put("path",bgm.getPath());
        //创建zk节点
        zkCurator.sendBgmOperator(bgm.getId(), JsonUtils.objectToJson(map));
    }

    @Override
    public void delBgm(String id) {
        Bgm bgm = bgmMapper.selectByPrimaryKey(id);

        bgmMapper.deleteByPrimaryKey(id);
        Map<String,String> map = new HashMap<>();
        map.put("operType",BGMOperatorTypeEnum.DELETE.type);
        map.put("path",bgm.getPath());
        //删除zk节点
        zkCurator.sendBgmOperator(id,JsonUtils.objectToJson(map));
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

    @Override
    public PagedResult queryReportList(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);

        List<Reports> list = usersReportMapperCustom.selectAllVideoReport();
        PageInfo<Reports> pageInfo = new PageInfo<Reports>(list);

        PagedResult grid = new PagedResult();
        grid.setTotal(pageInfo.getPages());
        grid.setRows(list);
        grid.setPage(page);
        grid.setRecords(pageInfo.getTotal());
        return grid;
    }

    @Override
    public void updateVideoStatus(String videoId, Integer status) {
        Videos video = new Videos();
        video.setId(videoId);
        video.setStatus(status);
        videosMapper.updateByPrimaryKeySelective(video);
    }
}
