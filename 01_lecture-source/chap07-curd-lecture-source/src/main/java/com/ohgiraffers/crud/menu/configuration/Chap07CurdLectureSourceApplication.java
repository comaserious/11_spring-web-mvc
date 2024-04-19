package com.ohgiraffers.crud.menu.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.ohgiraffers.crud" ,annotationClass = Mapper.class)
// annotationClass 를 통해서 스캔범위를 한정 지을수도 있다
public class Chap07CurdLectureSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chap07CurdLectureSourceApplication.class, args);
	}

}
