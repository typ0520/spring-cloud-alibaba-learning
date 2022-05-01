package consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tong
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudDubboNacosConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDubboNacosConsumerApplication.class, args);
    }
}