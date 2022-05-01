package consumer.controller;

import dubbo.api.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

/**
 * @author tong
 */
@RestController
public class DemoController {
    @Reference
    private DemoService demoService;

    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        return demoService.echo(str);
    }
}
