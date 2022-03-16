package com.example.finance.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.dom4j.DocumentException;

import java.io.IOException;

/**
 * Http工具类
 * @author 袁晓龙
 * @date 2022-03-15
 */
public class okHttpClient {


    /**
     * http远程调用接口，数据效验返回
     *
     * @return String
     *
     * @throws
     */
    public String postSendHttp(String url,String param,String contentType) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse(contentType);
        RequestBody body = RequestBody.create(mediaType, param);
        Request request = new Request.Builder()
                .url(url)
                .method("POST", body)
                .addHeader("Authorization", "Bearer 906e59d8-8227-eb97-9f0c-4edb5425aab6")
                .addHeader("X-ECC-Current-Tenant", "920438")
                .addHeader("Content-Type", contentType)
                .addHeader("Cookie", "caf_web_session=ZGY4Zjk5NWMtNTAxMi00ZTIzLWI2YzAtN2Q2NjdhYjVkNWZl")
                .build();
        Response response = client.newCall(request).execute();

        //验证返回参数是否是Json格式
        if (!isJSON2(response.body().string())){
            JSONObject xmltojson = xmltojson(response.body().string());
            return xmltojson.toString();
        }

        return response.body().string();
    }

    /**
     * 调用XmlTools中的documentToJSONObject方法（org.dom4j.Element 转  com.alibaba.fastjson.JSONObject）
     *
     * @param xml
     * @return JSONObject
     */
    public JSONObject xmltojson(String xml){

        XmlTools xmlTools = new XmlTools();
        JSONObject jsonObject = null;
        try {
            jsonObject = XmlTools.documentToJSONObject(xml);

        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 判断参数是否为json格式
     *
     * @param str
     * @return boolean
     */
    public static boolean isJSON2(String str) {
        boolean result = false;
        try {
            Object obj= JSON.parse(str);
            result = true;
        } catch (Exception e) {
            result=false;
        }
        return result;

    }

}
