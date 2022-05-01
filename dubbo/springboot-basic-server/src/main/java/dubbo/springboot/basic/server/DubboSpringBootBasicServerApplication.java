package dubbo.springboot.basic.server;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tong
 */
@SpringBootApplication
@EnableDubbo
public class DubboSpringBootBasicServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboSpringBootBasicServerApplication.class, args);
    }
}