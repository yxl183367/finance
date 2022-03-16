package com.example.finance.controller;

import com.example.finance.utils.okHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FiaccbdInterFaceController {

    Logger logger = LoggerFactory.getLogger(FiaccbdInterFaceController.class);


    /**
     * 获取往来单位信息
     *
     * @Author 袁晓龙
     * */
    @RequestMapping("/api/jg/fiaccbddata/v1.0/fiaccbdinterface/getWldw")
    @ResponseBody
    public String getWldw() {

        String url = "http://123.121.155.161:5200/api/jg/fiaccbddata/v1.0/fiaccbdinterface/getWldw";
        String param = "pZtid=920438&pDwid=111111&pKjnd=2022";
        String contentType = "application/x-www-form-urlencoded";

        try {
            okHttpClient okHttpClient = new okHttpClient();
            String response = okHttpClient.postSendHttp(url, param, contentType);
            logger.info("返回数据:{}",response);
            return response;
        }catch (Exception ignored){

            logger.info("This is an info message");
            return ignored.toString();
        }

    }


    /**
     * 获取往来单位信息（增量）
     *
     * @Author 袁晓龙
     * */
    @RequestMapping("/api/jg/fiaccbddata/v1.0/fiaccbdinterface/getWldwForIncre")
    @ResponseBody
    public String getWldwForIncre() {

        logger.info("开始执行获取往来单位信息（增量）");

        String url = "http://123.121.155.161:5200/api/jg/fiaccbddata/v1.0/fiaccbdinterface/getWldwForIncre";
        String param = "pZtid=920438&pDwid=111111&pKjnd=2022&pFilter=";
        String contentType = "application/x-www-form-urlencoded";

        try {
            okHttpClient okHttpClient = new okHttpClient();
            String response = okHttpClient.postSendHttp(url, param, contentType);
            logger.info("返回数据:{}",response);
            return response;
        }catch (Exception ignored){

            logger.info("This is an info message");
            return ignored.toString();
        }

    }

    /**
     * 获取往来单位信息（分页）
     *
     * @Author 袁晓龙
     * */
    @RequestMapping("/api/jg/fiaccbddata/v1.0/fiaccbdinterface/getWldwForPage")
    @ResponseBody
    public String getWldwForPage() {

        String url = "http://123.121.155.161:5200/api/jg/fiaccbddata/v1.0/fiaccbdinterface/getWldwForPage";
        String param = "pZtid=920438&pDwid=111111&pKjnd=2022&pWhere=&pStart=0&pEnd=10";
        String contentType = "application/x-www-form-urlencoded";

        try {
            okHttpClient okHttpClient = new okHttpClient();
            String response = okHttpClient.postSendHttp(url, param, contentType);
            logger.info("返回数据:{}",response);
            return response;
        }catch (Exception ignored){

            logger.info("This is an info message");
            return ignored.toString();
        }

    }
}
