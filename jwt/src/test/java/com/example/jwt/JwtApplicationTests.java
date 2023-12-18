package com.example.jwt;

import com.example.jwt.service.JWTService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Objects;

@SpringBootTest
class JwtApplicationTests {

	@Autowired
	private JWTService jwtService;

	@Test
	void contextLoads() {
	}

	@Test
	void tokenCreate(){
		var claims = new HashMap<String, Object>();
		claims.put("user_id", 923);

		var expireAt = LocalDateTime.now().plusMinutes(30);

		var jwtToken = jwtService.create(claims, expireAt);
		System.out.println(jwtToken);
	}

	@Test
	void tokenValidation(){
		var token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo5MjMsImV4cCI6MTcwMjUzNDE0OX0.uWVYkLr5I_I7varm4qrOlSLmtA851eljv_IBXIF1c40.eyJ1c2VyX2lkIjo5MjMsImV4cCI6MTcwMjUzMDgzMH0.1QwY1q1KADcQWk1UssDUsG7mtFcx9yUGLaPGSGP1PYA";
		jwtService.validation(token);

	}

}
