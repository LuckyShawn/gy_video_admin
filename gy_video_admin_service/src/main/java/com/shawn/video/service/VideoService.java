package com.shawn.video.service;

import com.shawn.video.pojo.Bgm;
import com.shawn.video.utils.JSONResult;
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

    /**
     * 查询举报信息列表
     * @param page
     * @param pageSize
     * @return
     */
    PagedResult queryReportList(Integer page,Integer pageSize);

    /**
     * 更新视频状态
     * @param videoId
     * @param status
     * @return
     */
    void updateVideoStatus(String videoId,Integer status);
}
