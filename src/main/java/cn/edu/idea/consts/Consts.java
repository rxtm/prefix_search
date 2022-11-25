package cn.edu.idea.consts;

import cn.edu.idea.entity.Node;

import java.io.File;

/**
 * @Author chenrui
 * @Date 2022/11/23
 */
public class Consts {
    //分隔符
    public static final String SPLIT_WORD = " +";
    //磁盘数据分隔符
    public static final String DATA_SPLIT_WORD = " ";
    //中文编码方式(gbk占用字节少于utf-8)
    public static final String ENCODE = "GBK";

    public static final Node HEAD = Node.head();

    public static File dataFile;

    public static boolean ready = false;
}
