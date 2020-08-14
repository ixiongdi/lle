package fun.xruo.lle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author kevin
 */
@SpringBootApplication
@MapperScan("fun.xruo.lle.*.dao")
public class LleApplication {

    public static void main(String[] args) {
        SpringApplication.run(LleApplication.class, args);
    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("*").allowedOrigins("http://localhost:8081");
//            }
//        };
//    }

}
