package gm.service.user;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@NacosPropertySource(dataId = "gm-service-user", autoRefreshed = true)
@ComponentScan(value = {"gm.common.base.aop"})
@EntityScan(basePackages = {"gm.facade.user.entity"})
public class DubboApplication {


	public static void main(String[] args) {

//		new SpringApplicationBuilder(DubboApplication.class)
//				.listeners((ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> {
//					Environment environment = event.getEnvironment();
//					int port = environment.getProperty("server.port", int.class);
//					new EmbeddedZooKeeper(port, false).start();
//				})
//				.run(args);
//		// start embedded zookeeper server
//		new EmbeddedZooKeeper(8081, false).start();
		new EmbeddedZooKeeper().start();
		SpringApplication.run(DubboApplication.class, args);
	}
	
}
