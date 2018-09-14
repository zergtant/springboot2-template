package tant.template.Config;
import org.eclipse.jetty.server.NCSARequestLog;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.boot.web.embedded.jetty.JettyServerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class JettyConfig {

    @Bean
    public ServletWebServerFactory jettyEmbeddedServletContainerFactory(
            JettyServerCustomizer jettyServerCustomizer) {
        JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
        factory.addServerCustomizers(jettyServerCustomizer);
        return factory;
    }


    @Bean
    public JettyServerCustomizer jettyServerCustomizer() {
        return server -> {
            threadPool(server);
            //accessLog(server);
        };
    }



    private void threadPool(Server server){
        // connections
        final QueuedThreadPool threadPool = server.getBean(QueuedThreadPool.class);
        //默认最大线程连接数200
        threadPool.setMaxThreads(100);
        //默认最小线程连接数8
        threadPool.setMinThreads(20);
        //默认线程最大空闲时间60000ms
        threadPool.setIdleTimeout(60000);
    }
    //jetty启动日志
    private void accessLog(Server server) {
        NCSARequestLog requestLog = new NCSARequestLog("logs/jetty-yyyy_mm_dd.request.log");
        requestLog.setAppend(true);
        requestLog.setExtended(false);
        requestLog.setLogTimeZone("GMT+08");
        requestLog.setLogLatency(true);
        requestLog.setRetainDays(60);
        server.setRequestLog(requestLog);
    }

}
