package nacos.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author tong
 */
@RestController
public class TestController {
    private final RestTemplate restTemplate;

    @Value("${nacos-provider-server-url}")
    private String nacosProviderServerUrl;

    @Autowired
    public TestController(RestTemplate restTemplate) {this.restTemplate = restTemplate;}

    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        return restTemplate.getForObject(nacosProviderServerUrl + "/echo/" + str, String.class);
    }

    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return restTemplate.getForObject(nacosProviderServerUrl + "/hello", String.class);
    }
}
