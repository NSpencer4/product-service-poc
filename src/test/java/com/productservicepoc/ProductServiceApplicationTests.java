package com.productservicepoc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.SpringApplication;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class ProductServiceApplicationTests {
	@Mock
	private SpringApplication springApplication = new SpringApplication();
	@InjectMocks
	private ProductServiceApplication app;

	@Test
	void contextLoads() {
		assertNotNull(app);
	}

}
