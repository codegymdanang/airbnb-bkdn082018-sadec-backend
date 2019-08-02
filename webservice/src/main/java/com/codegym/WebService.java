package com.codegym;

import jpaRepository.NguoiDungRepository;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.net.InetAddress;


@Configuration
@SpringBootApplication
@EntityScan(basePackages = "entity")
@EnableJpaRepositories(basePackages = "jpaRepository")
@EnableElasticsearchRepositories(basePackages = "elasticsearchRepository")
@ComponentScan(basePackages = {"service", "Impl", "entity", "com.codegym.controller","com.codegym.user"}, basePackageClasses = WebSecurityConfig.class)
public class WebService extends SpringBootServletInitializer implements CommandLineRunner  {

    public static void main(String[] args) {
        SpringApplication.run(WebService.class, args);
    }

    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    @Value("${elasticsearch.host}")
    private String EsHost;

    @Value("${elasticsearch.port}")
    private int EsPort;

    @Value("${elasticsearch.clustername}")
    private String EsClusterName;

    @Bean
    public Client client() throws Exception {

        Settings esSettings = Settings.builder()
                .put("cluster.name", "mkyong-cluster")
                .build();

        TransportClient clientTransport = new PreBuiltTransportClient(esSettings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300))
                .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));

        return clientTransport;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            System.out.println(nguoiDungRepository.findByTenNguoiDung("hoangpv6681"));
        } catch (Exception e) {
            System.out.println("Null");
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources((WebService.class));
    }
}
