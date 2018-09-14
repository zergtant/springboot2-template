package tant.template.web;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
@MapperScan("tant.template.dao")
@ComponentScan("tant.template")
@Slf4j
public class App  {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);

        if (args.length==1 && args[0].equals("initDB"))
        {
            app.setWebApplicationType(WebApplicationType.NONE);
            try{
                ConfigurableApplicationContext context = app.run(args);
                log.info("*正在测试数据链接，生成测试数据*");
                context.getBean(tant.template.service.test.class).initDB();
                log.info("**测试数据生成完成**");
                //SpringApplication.exit(context);
            }
            catch (Exception exp)
            {
                log.error("1",exp);
            }
        }
        else
        {
            app.setWebApplicationType(WebApplicationType.SERVLET);
            app.run(args);
            log.info("********* Web 启动成功 ********");
        }


    }

}

