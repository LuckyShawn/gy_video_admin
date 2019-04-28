package com.shawn.video.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shawn.video.utils.JSONResult;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.nio.ch.IOUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/4/26 0026
 */
@Controller
@RequestMapping("/video")
public class VideoController {

    @GetMapping("/showAddBgm")
    public String showAddBgm() {
        return "video/addBgm";
    }

    @PostMapping("/addBgm")
    @ResponseBody
    public JSONResult addBgm() {



        return JSONResult.ok();
    }

    @PostMapping("/bgmUpload")
    @ResponseBody
    public JSONResult bgmUpload(@RequestParam("file") MultipartFile[] files) throws IOException {
        //文件保存的命名空间
        String fileSpace = "F:" + File.separator + "WechatDev" + File.separator
                + "javaworkspace" + File.separator + "wechat_resource";
//        String fileSpace =  File.separator+"WechatDev"+File.separator
//                +"javaworkspace"+File.separator+"wechat_resource";

        //保存到数据库中的相对路径
        String uploadPathDB = File.separator + "gy_video_bgm";

        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        try {
            if (files != null && files.length > 0) {
                String fileName = files[0].getOriginalFilename();
                if (StringUtils.isNotBlank(fileName)) {
                    //文件上传的最终保存路径
                    String finalPath = fileSpace + uploadPathDB + "/" + fileName;
                    //设置数据库保存的路径
                    uploadPathDB += ("/" + fileName);
                    File outFile = new File(finalPath);
                    if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
                        //创建父文件夹
                        outFile.getParentFile().mkdirs();
                    }
                    fileOutputStream = new FileOutputStream(outFile);
                    inputStream = files[0].getInputStream();
                    IOUtils.copy(inputStream,fileOutputStream);
                }
            }else {
                return JSONResult.errorMsg("上传出错...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JSONResult.errorMsg("上传出错...");
        }finally {
            if(fileOutputStream != null){
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
        return JSONResult.ok(uploadPathDB);
    }

}
