package com.daou.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Parent {
	@Configuration
	static class InnerClass1 {
		public void t() {

		}
		@Bean
		public Child1 child1() {
			return new Child1();
		}
	}

	@Configuration
	@Profile("user")
	//@RunningMode
	static class InnerClass2 {
		@Autowired
		private InnerClass1 child1;
		@Bean
		public Child2 child2() {
			child1.t();
			return new Child2();
		}
	}

	@Profile("development")
	@Configuration
	static class InnerClass3 {

		@Profile("user")
		static class InnerClass4 {
			@Bean
			public Child4 child4() {
				return new Child4();
			}
		}
	}
}
