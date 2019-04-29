package com.shawn.video.service;

import com.shawn.video.pojo.Bgm;
import com.shawn.video.utils.PagedResult;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/4/28 0028
 */
public interface VideoService {
    /**
     * 添加BGM
     * @param bgm
     */
    void addBgm(Bgm bgm);

    /**
     * 删除BGM
     * @param id
     */
    void delBgm(String id);

    /**
     * 查询Bgm列表
     * @param
     * @return
     */
    PagedResult queryBgmList(Integer page,Integer pageSize);
}
