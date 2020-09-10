package org.cskj.boot.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.cskj.boot.shiro.mapper")
public class ShiroDemoSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShiroDemoSpringbootApplication.class, args);
	}

}
