package com.shawn.video.service.impl;

import com.shawn.video.mapper.BgmMapper;
import com.shawn.video.pojo.Bgm;
import com.shawn.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/4/28 0028
 */
public class VideoServiceImpl implements VideoService {

    @Autowired
    private BgmMapper bgmMapper;
    @Override
    public void addBgm(Bgm bgm) {

    }
}
