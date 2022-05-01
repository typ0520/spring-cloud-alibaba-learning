package dubbo.springboot.basic.server;

import dubbo.api.DemoService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author tong
 */
@Service//注意是dubbo的service，不是spring的
public class DemoServiceImpl implements DemoService {
    @Override
    public String echo(String text) {
        return "from server: " + text;
    }
}
