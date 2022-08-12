package kr.co.iotree.sanghproject;

import kr.co.iotree.sanghproject.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SanghProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SanghProjectApplication.class, args);
	}

}
