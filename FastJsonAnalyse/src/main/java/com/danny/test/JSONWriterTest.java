package com.danny.test;/**
 * Created by danny on 2017-11-23.
 */



import com.alibaba.fastjson.JSONWriter;

import java.io.FileWriter;

/**
 * @author danny
 * @create 2017-11-23 16:32
 */

public class JSONWriterTest {
    public static void main(String[] args) throws Exception{
        String path = "D:\\workspace64\\FrameAnalyseDemo\\FastJsonAnalyse\\src\\main\\resources\\huge.json";
        JSONWriter writer = new JSONWriter(new FileWriter(path));
        writer.startArray();
        for (int i = 0; i < 10 * 10; ++i) {
            writer.writeValue(i);
        }
        writer.endArray();
        writer.close();


        JSONWriter writer2 = new JSONWriter(new FileWriter("D:\\workspace64\\FrameAnalyseDemo\\FastJsonAnalyse\\src\\main\\resources\\huge1.json"));
        writer2.startObject();
        for (int i = 0; i < 10 * 10; ++i) {
            writer2.writeKey("x" + i);
            writer2.writeValue(1);
        }
        writer2.endObject();
        writer2.close();

    }
}
