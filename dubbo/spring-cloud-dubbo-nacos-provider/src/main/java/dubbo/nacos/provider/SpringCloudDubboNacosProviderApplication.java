package dubbo.nacos.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tong
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudDubboNacosProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDubboNacosProviderApplication.class, args);
    }
}