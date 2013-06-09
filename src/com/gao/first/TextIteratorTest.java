package com.gao.first;

import org.apache.hadoop.io.Text;

import java.nio.ByteBuffer;

/**
 * User: wangchen.gpx
 * Date: 13-6-9
 * Time: 上午8:28
 */
public class TextIteratorTest {
    public static void main(String[] args) {
        Text text = new Text("\u0041\u00df\u6771\ud801\udc00");
        ByteBuffer buffer = ByteBuffer.wrap(text.getBytes());
        int cp;
        while(buffer.hasRemaining() && (cp = Text.bytesToCodePoint(buffer) ) != -1){
            System.out.println(cp +":"+Integer.toHexString(cp));
        }


        Text hadoop = new Text("hadoop");
        hadoop.set(new Text("pig"));
        System.out.println(hadoop.getLength());
        System.out.println(hadoop.getBytes().length);
        System.out.println(hadoop.toString());
    }
}
