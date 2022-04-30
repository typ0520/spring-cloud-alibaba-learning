package nacos.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tong
 */
@RestController
public class DemoController {
    @Value("${spring.application.name}")
    private String serverName;

    @Value("${server.port}")
    private int port;

    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return serverName + port;
    }

    @GetMapping("echo/{text}")
    @ResponseBody
    public String echo(@PathVariable(value = "text") String text) {
        return serverName + port + ": " + text;
    }
}
