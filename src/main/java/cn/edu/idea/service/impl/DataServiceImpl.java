package cn.edu.idea.service.impl;

import cn.edu.idea.consts.Consts;
import cn.edu.idea.entity.Data;
import cn.edu.idea.entity.Node;
import cn.edu.idea.service.DataService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author chenrui
 * @Date 2022/11/24
 */
@Service
public class DataServiceImpl implements DataService {

    @Override
    public synchronized void add(List<Data> list) throws IOException {
        for(Data data : list) {
            buildTrie(data);
        }
        FileUtils.writeLines(Consts.dataFile,list,true);
    }

    @Override
    public void buildTrie(Data data) {
        String str = data.getStr();
        if(StringUtils.isBlank(str)) {
            return;
        }
        str = str.replaceAll(Consts.SPLIT_WORD," ");
        Node head = Consts.HEAD;
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            Map<Character, Node> nextMap = head.getNextMap();
            nextMap.putIfAbsent(chars[i],new Node(chars[i]));
            head = nextMap.get(chars[i]);
        }
        head.docIds().add(data.getId());
    }
}
