package dubbo.basic.client;

import dubbo.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tong
 */
public class DubboBasicClientApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"META-INF/spring/consumer.xml"});
        DemoService demoService = (DemoService) context.getBean("demoService");
        // 获取远程服务代理
        String hello = demoService.echo("hello world"); // 执行远程方法
        System.out.println( hello ); // 显示调用结果
    }
}