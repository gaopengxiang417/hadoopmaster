package com.gao.first;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapFile;
import org.apache.hadoop.io.Text;

import java.io.IOException;
import java.net.URI;

/**
 * User: wangchen.gpx
 * Date: 13-6-16
 * Time: 下午3:19
 */
public class MapFileWriteDemo {
    private static final String[] DATA = {
            "one,two,buckle my sheo",
            "three,four,shut the door",
            "five,six,pick up the sticks",
            "seven,eight,lay them straight",
            "nine,ten,a big fat hen"
    };

    public static void main(String[] args) throws IOException {
        String str = "file:///d:/mas.map";
        URI uri = URI.create(str);
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(uri, configuration);
        Path path = new Path(uri);
        IntWritable key = new IntWritable();
        Text value = new Text();
        MapFile.Writer writer = null;
        try{
            writer = new MapFile.Writer(configuration , fileSystem ,  str ,
                    IntWritable.class , Text.class);
            for (int i = 0; i < 100; i++) {
                key.set(i + 1);
                value.set(DATA[i % DATA.length]);
                writer.append(key,value);
            }
        }finally {
            IOUtils.closeStream(writer);
        }
    }
}
