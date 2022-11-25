package cn.edu.idea.api;

import cn.edu.idea.entity.Data;
import cn.edu.idea.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @Author chenrui
 * @Date 2022/11/23
 */
@Slf4j
@RestController
public class DataApi {

    @Autowired
    private DataService dataService;

    @PostMapping("/add")
    public void add(@RequestBody List<Data> list) throws IOException {
        dataService.add(list);
    }

}
