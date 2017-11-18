package es.proojec;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
@EnableJpaRepositories("es.proojec.store.repositories")
@EntityScan(
        basePackageClasses = { ProojecWebApplication.class, Jsr310JpaConverters.class }
)
@Configuration
public class ProojecWebApplication {
    @Autowired
    private YAMLConfig myConfig;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProojecWebApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ProojecWebApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Before("execution(* es.proojec.controllers.*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void callSetters(JoinPoint joinPoint) {
        LOGGER.info("Setter Called");
        LOGGER.info("Method Invoked: " + joinPoint.getSignature().getName());
        LOGGER.info("Value Passed: " + joinPoint.getArgs()[0]);
    }

    public void run(String... args) throws Exception {
        System.out.println("using environment: " + myConfig.getEnvironment());
        System.out.println("name: " + myConfig.getName());
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            /*Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }*/

        };
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/user.*|/register.*|/oauth/token.*"))
                //PathSelectors.any() for all
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "aTitle",
                "aDescription",
                "aVersion",
                "a url to terms and services",
                "aContact",
                "a License of API",
                "a license URL");
        return apiInfo;
    }

}
