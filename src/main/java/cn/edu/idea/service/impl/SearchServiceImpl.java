package cn.edu.idea.service.impl;

import cn.edu.idea.consts.Consts;
import cn.edu.idea.entity.Data;
import cn.edu.idea.entity.Node;
import cn.edu.idea.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author chenrui
 * @Date 2022/11/23
 */
@Slf4j
@Service
public class SearchServiceImpl implements SearchService {

    @Override
    public List<Data> search(String str, Integer k) {
        str = str.replaceAll(Consts.SPLIT_WORD," ");
        Node head = Consts.HEAD;
        char[] chars = str.toCharArray();
        for(char c : chars) {
            if(!head.getNextMap().containsKey(c)) {
                return null;
            }
            head = head.getNextMap().get(c);
        }
        List<Data> list = new ArrayList<>();
        listDocIds(head,str,list,k);
        return list;
    }

    private void listDocIds(Node node,String str,List<Data> list,Integer k) {
        int gap = k - list.size();
        if(gap == 0) {
            return;
        }
        Queue<Long> docIds = node.docIds();
        if(!docIds.isEmpty()) {
            list.addAll(docIds.stream().limit(gap).map(id -> new Data(id, str)).collect(Collectors.toList()));
        }
        if(node.hasNext()) {
            Set<Map.Entry<Character, Node>> entries = node.getNextMap().entrySet();
            for(Map.Entry<Character, Node> entry : entries) {
                Node nextNode = entry.getValue();
                String newStr = str + entry.getKey();
                listDocIds(nextNode,newStr,list,k);
                if(list.size() == k) {
                    return;
                }
            }
        }
    }
}
