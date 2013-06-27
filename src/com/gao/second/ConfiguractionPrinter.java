package com.gao.second;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.util.Map;

/**
 * User: wangchen.gpx
 * Date: 13-6-26
 * Time: 下午2:15
 */
public class ConfiguractionPrinter extends Configured implements Tool {
    @Override
    public int run(String[] args) throws Exception {
        Configuration conf = getConf();
        for (Map.Entry<String, String> entry : conf) {
            System.out.printf("%s=%s\n",entry.getKey(),entry.getValue());
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        int exit = ToolRunner.run(new ConfiguractionPrinter(), args);
        System.out.println(exit);
    }
}
