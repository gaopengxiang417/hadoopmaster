package com.gao.first;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;

import java.io.IOException;
import java.net.URI;

/**
 * User: wangchen.gpx
 * Date: 13-6-16
 * Time: 下午12:56
 */
public class SequenceFileWriteDemo {
    private static final String[] DATA = {
            "one,two,buckle my sheo",
            "three,four,shut the door",
            "five,six,pick up the sticks",
            "seven,eight,lay them straight",
            "nine,ten,a big fat hen"
    };

    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration();
        URI uri = URI.create("file:///d:/ss.seq");
        FileSystem fileSystem = FileSystem.get(uri, configuration);

        Path path = new Path(uri);
        IntWritable intWritable = new IntWritable();
        Text text = new Text();

        SequenceFile.Writer writer = null;
        try {
            writer = SequenceFile.createWriter(fileSystem, configuration, path, IntWritable.class,
                    Text.class);
            for (int i = 0; i < 100; i++) {
               intWritable.set(100 - i);
                text.set(DATA[i % DATA.length]);
                System.out.printf("[%s]\t%s\t%s\n" , writer.getLength(),intWritable,text);
                writer.append(intWritable,text);
            }
        }finally {
            IOUtils.closeStream(writer);
        }
    }
}
