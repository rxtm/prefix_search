package cn.edu.idea.service;

import cn.edu.idea.entity.Data;

import java.io.IOException;
import java.util.List;

/**
 * @Author chenrui
 * @Date 2022/11/24
 */
public interface DataService {
    void add(List<Data> list) throws IOException;

    void buildTrie(Data data);
}
