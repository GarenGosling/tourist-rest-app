package org.garen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;


/**
 * Created by Administrator on 2017/8/23.
 */
@Controller
@SpringBootApplication
@MapperScan("org.garen.tourist.mybatis.mapper")
public class TouristRun {

    public static void main(String[] args) {
        SpringApplication.run(TouristRun.class, args);
    }

}
