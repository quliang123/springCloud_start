package com.example;

import com.example.filters.RequestTimeFilter;
import com.example.filters.RequestTimeGatewayFilterFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class ServiceGatewayApplication {


//    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(ServiceGatewayApplication.class, args);
    }


    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        System.out.println("hello world~~~");
        String httpUri = "http://httpbin.org:80";
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("hello", "world"))
                        .uri(httpUri))
                .route(p -> p
                        .host("*.hystrix.com")
                        .filters(f -> f
                                .hystrix(config -> config
                                        .setName("mycmd")
                                        .setFallbackUri("forward:/fallback")))
                        .uri(httpUri))
                .route(r -> r
                        .path("/customer/**")
                        .filters(f -> f.
                                filter(new RequestTimeFilter())
                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                        .uri("http://httpbin.org:80/get")
                        .order(0)
                        .id("customer_filter_route")

                )
                .build();
    }

    /**
     * Mono是一个Reactive stream，对外输出一个“fallback”字符串。
     *
     * @return
     */
    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        System.out.println("fallback");
        return Mono.just("fallback");
    }


    @Bean
    public RequestTimeGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new RequestTimeGatewayFilterFactory();
    }


//    @Bean
//    public RouteLocatorBuilder routeLocatorBuilder() {
//        return new RouteLocatorBuilder(context);
//    }
}
