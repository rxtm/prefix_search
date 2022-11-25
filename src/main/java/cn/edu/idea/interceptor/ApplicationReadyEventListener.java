package cn.edu.idea.interceptor;

import cn.edu.idea.consts.Consts;
import cn.edu.idea.entity.Data;
import cn.edu.idea.service.DataService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * spring启动完成事件
 * @author chenrui
 * @date 2022/11/23
 */
@Slf4j
@Component
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {

    @Value("${data.path}")
    private String dataPath;
    @Autowired
    private DataService dataService;

    @Override
    @SneakyThrows
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Consts.dataFile = new File(dataPath);
        if(!Consts.dataFile.exists()) {
            Consts.dataFile.createNewFile();
            return;
        }
        LineIterator iterator = FileUtils.lineIterator(Consts.dataFile);
        while(iterator.hasNext()) {
            String line = iterator.nextLine();
            int index = line.indexOf(Consts.DATA_SPLIT_WORD);
            Long id = Long.parseLong(line.substring(0,index));
            String str = line.substring(index+1);
            dataService.buildTrie(new Data(id,str));
        }
        Consts.ready = true;
    }

}
