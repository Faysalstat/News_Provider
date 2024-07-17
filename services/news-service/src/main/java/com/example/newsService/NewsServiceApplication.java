package com.example.newsService;

import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableScheduling
public class NewsServiceApplication {
	@Value("openai.key")
	private String OPENAI_API_KEY;
	private static final Logger logger = LoggerFactory.getLogger(NewsServiceApplication.class);
	private static final HttpClient httpClient = HttpClient.newBuilder()
			.version(HttpClient.Version.HTTP_2)
			.connectTimeout(java.time.Duration.ofSeconds(10))
			.build();

	private static final String PUBSUB_NAME = "newspubsub";
	private static final String TOPIC = "news";
	private static String DAPR_HOST = System.getenv().getOrDefault("DAPR_HOST", "http://localhost");
	private static String DAPR_HTTP_PORT = System.getenv().getOrDefault("DAPR_HTTP_PORT", "3500");

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(NewsServiceApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate(){
		RestTemplate restTemplate = new RestTemplate();

		return restTemplate;
	}
}

