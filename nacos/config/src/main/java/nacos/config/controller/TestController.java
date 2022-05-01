package nacos.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @author tong
 */
@RestController
@RefreshScope
public class TestController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
