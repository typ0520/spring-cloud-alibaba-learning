package dubbo.basic.server;

import org.apache.dubbo.container.Main;

/**
 * @author tong
 */
public class DubboBasicServerNacosApplication {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/application.xml"});
//        context.start();
        Main.main(args);
    }
}