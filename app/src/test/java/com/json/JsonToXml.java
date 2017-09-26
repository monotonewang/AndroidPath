package com.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ubuntu on 17-9-25.
 */

public class JsonToXml {


    //Email_Bind
    //Failed
    //Top_Up


    /**
     * 讲多语言的json转化成有序xml
     */
    @Test
    public void testJsonToXml() {
        File fileJson = new File("common-en-CN-7.json");
        File fileXml = new File("");
        try {
            InputStream fileInputStream = new FileInputStream(fileJson);
            ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
            try {
                byte[] buffer = new byte[1024 * 16 * 8];
                int length = 0;
                while ((length = fileInputStream.read(buffer)) != -1) {
                    byteOutputStream.write(buffer, 0, length);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            int sieze = byteOutputStream.size();
            System.out.println("out=" + sieze);
            String string = byteOutputStream.toString();
            System.out.println("无序遍历结果：");
            com.alibaba.fastjson.JSONObject jsonObj = JSON.parseObject(string);
            for (Map.Entry<String, Object> entry : jsonObj.entrySet()) {
//                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
            System.out.println("-------------------");
            System.out.println("有序遍历结果：");
            LinkedHashMap<String, String> jsonMap = JSON.parseObject(string, new TypeReference<LinkedHashMap<String, String>>() {
            });

            for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
                System.out.println("<string name=\"" + entry.getKey() + "\">" + entry.getValue() + "</string>");
            }


//            System.out.println(string + "length");
//            System.out.println(string.length());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(fileJson.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
