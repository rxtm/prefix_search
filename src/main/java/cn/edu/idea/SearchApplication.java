package cn.edu.idea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cn.edu.idea")
public class SearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class, args);
    }

}
