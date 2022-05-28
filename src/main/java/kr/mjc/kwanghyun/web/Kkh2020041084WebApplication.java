package kr.mjc.kwanghyun.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan(basePackages = "kr.mjc.kwanghyun.web.servlets")
public class Kkh2020041084WebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Kkh2020041084WebApplication.class, args);
    }

    /**
     * 서블릿 컨테이너에 배포하기 위한 구성
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Kkh2020041084WebApplication.class);
    }
}
