package cn.edu.idea.entity;

import lombok.AllArgsConstructor;

/**
 * @Author chenrui
 * @Date 2022/11/23
 */
@lombok.Data
@AllArgsConstructor
public class Data {

    private Long id;
    private String str;

    @Override
    public String toString() {
        return id + " " + str;
    }
}
