package com.dwes.productos.gatewayservice;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayServiceApplication {

   @Value("${global-message}")
   private String globalMessage;
   @Value("${server.port}")
   private String port;

	  
	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
		System.out.println("from gateway");
	}
	
	// Endpoint para mostrar el puerto
    @GetMapping("/show-port")
    public String showPort() {
        return "El puerto actual del gateway es: " + port;
    }
	@RequestMapping("/")
    public String home() {
        return "globalMessage: "+ globalMessage;
    }
	
	/**
	 * 
    // Si deseas configurar rutas programáticamente en lugar de en application.yml
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("producto", r -> r.path("/api/v0/productos/**")
                        .uri("http://localhost:9013/"))
                .route("auth-service", r -> r.path("/api/v0/auth/**")
                        .uri("lb://autorizacion")) // Usando lb:// para el balanceo de carga con Eureka
                .build();
    }*/
	 
}
