package gm.service.fee;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NacosPropertySource(dataId = "gm-service-fee", autoRefreshed = true)
public class DubboApplication {
	public static void main(String[] args) {
		new EmbeddedZooKeeper().start();
		SpringApplication.run(DubboApplication.class, args);
	}
}
