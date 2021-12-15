package kr.co.psj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class PsjApplication{
    
    public static void main(String[] args){
        SpringApplication.run(PsjApplication.class, args);
    }
    
}
