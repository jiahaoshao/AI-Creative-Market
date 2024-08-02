package name.sauerkraut.aicreativemarket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("name.sauerkraut.aicreativemarket.mapper")
public class AiCreativeMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiCreativeMarketApplication.class, args);
    }

}
