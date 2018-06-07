package mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("mybatis.mapper")
public class SpringBootWithMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithMybatisApplication.class, args);
	}
}
