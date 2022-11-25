package cn.edu.idea.api;

import cn.edu.idea.consts.Consts;
import cn.edu.idea.entity.Data;
import cn.edu.idea.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author chenrui
 * @Date 2022/11/23
 */
@Slf4j
@RestController
public class SearchApi {

    @Autowired
    private SearchService searchService;

    @GetMapping("/search")
    public List<Data> search(@RequestParam String str,@RequestParam(required = false,defaultValue = "10") Integer k) {
        if(!Consts.ready) {
            return null;
        }
        return searchService.search(str,k);
    }
}
