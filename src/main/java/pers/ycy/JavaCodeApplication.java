package pers.ycy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"pers.ycy.**.dao"})
@SpringBootApplication(scanBasePackages = {"pers.ycy"})
public class JavaCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaCodeApplication.class, args);
    }

}
