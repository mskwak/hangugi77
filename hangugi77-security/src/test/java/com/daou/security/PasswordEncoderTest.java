package com.daou.security;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordEncoderTest {
	private PasswordEncoder passwordEncoder;

	@Before
	public void setUp() throws Exception {
		passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Test
	public void encode() {
		String password = "password";
		String encPassword = passwordEncoder.encode(password);
		System.out.println(encPassword);
		assertThat(passwordEncoder.matches(password, encPassword)).isTrue();
		assertThat(encPassword).contains("{bcrypt}");
	}

	@Test
	public void noop() {
		String idForEncode = "noop";
		Map<String, PasswordEncoder> idToPasswordEncoder = new HashMap<>();
		idToPasswordEncoder.put(idForEncode, NoOpPasswordEncoder.getInstance());
		DelegatingPasswordEncoder delegatingPasswordEncoder = new DelegatingPasswordEncoder(idForEncode, idToPasswordEncoder);

		String password = "1234";
		String encPassword = delegatingPasswordEncoder.encode(password);

		assertThat(delegatingPasswordEncoder.matches(password, encPassword)).isTrue();
	}
}
