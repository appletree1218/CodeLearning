package online.chenke;

import online.chenke.sourcecode.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = ctx.getBean(User.class);
        System.out.println( user.getName() );
    }
}
