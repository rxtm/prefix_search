package cn.edu.idea.service;

import cn.edu.idea.entity.Data;

import java.util.List;

/**
 * @Author chenrui
 * @Date 2022/11/23
 */
public interface SearchService {
    List<Data> search(String str, Integer k);
}
