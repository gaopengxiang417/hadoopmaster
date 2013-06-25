package com.gao.second;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;

/**
 * User: wangchen.gpx
 * Date: 13-6-16
 * Time: 下午3:35
 */
public class ConfiguractionTest {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.addResource(new Path("G:\\idea_workspace\\hadoopmaster\\src\\com\\gao\\second\\configur.xml"));

        String color = configuration.get("color");
        String size = configuration.get("size");
        String weight = configuration.get("weight");
        String breadth = configuration.get("breadth");
        System.out.printf("%s\t%s\t%s\t%s\t\n",color,size,weight,breadth);
    }
}
