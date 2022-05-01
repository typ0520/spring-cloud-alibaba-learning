package dubbo.basic.server;

import dubbo.api.DemoService;

/**
 * @author tong
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String echo(String text) {
        return "from server: " + text;
    }
}
