package com.gao.first;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.io.WritableUtils;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Comparator;

/**
 * User: wangchen.gpx
 * Date: 13-6-11
 * Time: 上午10:05
 */
public class TextPair  implements WritableComparable<TextPair>{

    private Text first;

    private Text second;

    public TextPair() {
        this.first = new Text();
        this.second = new Text();
    }

    public TextPair(String f, String s) {
        first = new Text(f);
        second = new Text(s);
    }

    public TextPair(Text first, Text second) {
        this.first = first;
        this.second = second;
    }

    public Text getFirst() {
        return first;
    }

    public void setFirst(Text first) {
        this.first = first;
    }

    public Text getSecond() {
        return second;
    }

    public void setSecond(Text second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return first.toString() +"\t" + second.toString();
    }

    @Override
    public int hashCode() {
        return first.hashCode() * 31 + second.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TextPair) {
            TextPair other = (TextPair) obj;
            return this.first.equals(other.first) && this.second.equals(other.second);
        }
        return false;
    }

    @Override
    public int compareTo(TextPair o) {
        int result = this.first.compareTo(o.first);
        if(result == 0)
            result = this.second.compareTo(o.second);
        return result;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        first.write(out);
        second.write(out);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        first.readFields(in);
        second.readFields(in);
    }

    public static class Comparator extends WritableComparator {

        private static final Comparator COMPARATOR = new Comparator();

        protected Comparator() {
            super(TextPair.class);
        }

        @Override
        public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
            int result  = 0;
            try {
                int first = WritableUtils.decodeVIntSize(b1[s1]) + readVInt(b1, s1);
                int second = WritableUtils.decodeVIntSize(b2[s2]) + readVInt(b2, s2);
                result = COMPARATOR.compare(b1, s1, first, b2, s2, second);
                if(result != 0) {
                    return COMPARATOR.compare(b1, s1 + first, l1 - first, b2, s2 + second, l2 - second);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }
    }
    static {
        WritableComparator.define(TextPair.class , new Comparator());
    }
}
