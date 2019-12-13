package com.cjwsjy.talents.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cjwsjy.talents.entity.Dm_num_cube;
import com.cjwsjy.talents.entity.Sm_user;
import com.cjwsjy.talents.service.IDm_num_cubeService;
import com.util.FileUtils;
import com.util.ImageUtil;
import com.util.LogUtil;
import com.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.coobird.thumbnailator.Thumbnails;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import com.cjwsjy.talents.service.ISm_userService;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xuli2
 * @since 2019-07-22
 */
@Api(description = "照片API")
@CrossOrigin
@RestController
@RequestMapping("/rest")
public class Sm_userController {

    @Autowired
    private ISm_userService sm_userService;
    @Autowired
    private IDm_num_cubeService dmNumCubeService;

    @Value(value = "${web.upload-path}")
    private String path;
    @Value(value = "${source.photo.url}")
    private String soucrcePhoto;

    @ApiOperation(value = "是否有查看该功能的权限")
    @ApiImplicitParam(name = "userName", value = "员工login_name", paramType = "query", required = true)
    @RequestMapping("/checkPremission")
    @ResponseBody
    ResponseResult checkPremission(@RequestParam("userName") String userName) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_code", userName);
        int count = sm_userService.count(wrapper);
        JSONObject result = new JSONObject();
        result.put("count", count);
        return ResponseResult.success(result, null);
    }

    @ApiOperation(value = "获取权限范围")
    @ApiImplicitParam(name = "userName", value = "员工login_name", paramType = "query", required = true)
    @RequestMapping("/getPremission")
    @ResponseBody
    ResponseResult getPremission(@RequestParam("userName") String userName) {
        QueryWrapper<Sm_user> wrapper = new QueryWrapper();
        wrapper.eq("user_code", userName);
        Sm_user user = sm_userService.getOne(wrapper);
        return ResponseResult.success(user, null);
    }

    @GetMapping("/photo/{userName}")
    void photo(@PathVariable ("userName") String userName,HttpServletResponse response) {
        response.setContentType("image/*");
        //建目录
        File dir = new File(path+"photo/");
        if(!dir.exists()){
            dir.mkdir();
        }
        //获取照片
        String photoPath = path+"photo/"+userName+".jpg";
        File file = new File(photoPath);
        //检查照片是否存在，存在则输出，不存在则拷贝
        if(file.exists()){
            FileInputStream fis = null;
            OutputStream os = null;
            try {
                fis = new FileInputStream(photoPath);
                os = response.getOutputStream();
                int count = 0;
                byte[] buffer = new byte[1024 * 8];
                while ((count = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, count);
                    os.flush();
                }
            } catch (IOException e) {
                LogUtil.printLog(e,Sm_userController.class);
            } finally {
                try {
                    fis.close();
                    os.close();
                } catch (IOException e) {
                    LogUtil.printLog(e,Sm_userController.class);
                }
            }
        }else{
            BASE64Decoder decoder = new BASE64Decoder();
            OutputStream os = null;
            try {
                byte[] decoderBytes = decoder.decodeBuffer(defaut);
                os = response.getOutputStream();
                os.write(decoderBytes, 0, decoderBytes.length);
                os.flush();
            } catch (IOException e) {
                LogUtil.printLog(e,Sm_userController.class);
            } finally {
                try {
                    os.close();
                } catch (IOException e) {
                    LogUtil.printLog(e,Sm_userController.class);
                }
            }


            String spath = soucrcePhoto+userName+".jpg";
            ImageUtil.compressionByWidth(spath,photoPath,240);
        }
    }

    @GetMapping("/pic/{pk_psndoc}")
    void pic(@PathVariable ("pk_psndoc") String pk_psndoc
            ,HttpServletResponse response) {
        Map<String, String> map = new HashMap<>();
        map.put("pk_psndoc", pk_psndoc);
        Map blob = sm_userService.getPic(map);
        byte[] pic = (byte[]) blob.get("previewphoto");
        OutputStream out = null;
        ByteArrayInputStream is = null;
        try {
            is = new ByteArrayInputStream(pic);
            out = response.getOutputStream();
            response.setContentType("image/*");
            //读取文件流
            int len = 0;
            byte[] buffer = new byte[1024 * 8];
            while ((len = is.read(buffer)) != -1){
                out.write(buffer,0,len);
            }
        } catch (IOException e) {
            LogUtil.printLog(e,Sm_userController.class);
        }finally {
            try {
                out.close();
                is.close();
            } catch (IOException e) {
                LogUtil.printLog(e,Sm_userController.class);
            }
        }
    }
    @GetMapping("/initPhoto")
    void initPhoto(HttpServletRequest req) {
        String p = req.getRequestURL().toString();
        String pathUrl = p.replace("initPhoto","photo");
        new Thread(new Runnable() {
            @Override
            public void run() {
                LogUtil.printLog("用户照片同步开始");
                OkHttpClient client = new OkHttpClient();
                Response response = null;
                List<Dm_num_cube> list = dmNumCubeService.list(new QueryWrapper<>());
                for (int i = 0; i <list.size() ; i++) {

                    try {
                        String u = pathUrl +"/"+list.get(i).getEmail().substring(0,list.get(i).getEmail().indexOf("@"));
                        LogUtil.printLog(u);
                        Request request = new Request.Builder().url(u).build();
                        LogUtil.printLog(i+"");
                        response = client.newCall(request).execute();
                        LogUtil.printLog(response.code()+"");
                        Thread.sleep(50);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (NullPointerException e){
                        e.printStackTrace();
                    }finally {
                        response.close();
                    }
                }
                LogUtil.printLog("用户照片同步结束");

            }
        }).start();
    }

    private String defaut="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";

}

