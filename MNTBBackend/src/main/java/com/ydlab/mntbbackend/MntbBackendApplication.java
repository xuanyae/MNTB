package com.ydlab.mntbbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.ydlab.mntbbackend.mapper")
@EnableTransactionManagement//开启事务
public class MntbBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MntbBackendApplication.class, args);
    }

}
