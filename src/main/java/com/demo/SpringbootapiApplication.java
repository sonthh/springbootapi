package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@EnableWebSecurity

//@SpringBootApplication(scanBasePackages = {"com.demo.*"})
//Spring Boot mặc định sẽ tự động cấu hình JPA, và tạo ra các Spring BEAN liên quan tới JPA, các tự động cấu hình này của Spring Boot bao gồm:
@SpringBootApplication
//@EnableAutoConfiguration(exclude = { //
//		DataSourceAutoConfiguration.class, //
//		DataSourceTransactionManagerAutoConfiguration.class, //
//		HibernateJpaAutoConfiguration.class })

public class SpringbootapiApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootapiApplication.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeRequests()
//				.antMatchers("/api/**", "/demo").permitAll().anyRequest().authenticated()
//				.and().httpBasic();
		http.cors(); // CẤU HÌNH Access-Control-Allow-Origin CHO ANGULAR GỌI API
	}

//	@Override
//	public void configure(WebSecurity web) throws Exception {
////		web.ignoring().antMatchers("/css/**", "/js/**", "/images/**");
//		web.ignoring().antMatchers("/resources/**");
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = passwordEncoder();
		auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("123")).roles("ADMIN").and()
				.passwordEncoder(encoder);
	}

	// CẤU HÌNH Access-Control-Allow-Origin CHO ANGULAR GỌI API
	@Bean
	CorsConfigurationSource corsConfigurationSource() {

		CorsConfiguration config = new CorsConfiguration();
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("HEAD");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("DELETE");
		config.addAllowedMethod("PATCH");

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);

		return source;
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*
	 * @Bean CharacterEncodingFilter characterEncodingFilter() {
	 * CharacterEncodingFilter filter = new CharacterEncodingFilter();
	 * filter.setEncoding("UTF-8"); filter.setForceEncoding(true); return filter; }
	 */

	/*
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Bean public WebMvcConfigurer corsConfigurer() { return new
	 * WebMvcConfigurerAdapter() {
	 * 
	 * @Override public void addCorsMappings(CorsRegistry registry) {
	 * registry.addMapping("/**") .allowedOrigins("http://localhost:4200")
	 * .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
	 * .allowedHeaders("Content-Type", "Date", "Total-Count", "loginInfo")
	 * .exposedHeaders("Content-Type", "Date", "Total-Count", "loginInfo")
	 * .maxAge(3600); } }; }
	 */




//	@Autowired
//	private Environment env;
//
//	@Bean(name = "dataSource")
//	public DataSource getDataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//		// See: application.properties
//		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
//		dataSource.setUrl(env.getProperty("spring.datasource.url"));
//		dataSource.setUsername(env.getProperty("spring.datasource.username"));
//		dataSource.setPassword(env.getProperty("spring.datasource.password"));
//
//		System.out.println("## getDataSource: " + dataSource);
//
//		return dataSource;
//	}
//
//	@Autowired
//	@Bean(name = "sessionFactory")
//	public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
//		Properties properties = new Properties();
//
//		// See: application.properties
//		properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
//		properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
//		properties.put("current_session_context_class", //
//				env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
//
//		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//
//		// Package contain entity classes
//		factoryBean.setPackagesToScan(new String[] { "" });
//		factoryBean.setDataSource(dataSource);
//		factoryBean.setHibernateProperties(properties);
//		factoryBean.afterPropertiesSet();
//		//
//		SessionFactory sf = factoryBean.getObject();
//		System.out.println("## getSessionFactory: " + sf);
//		return sf;
//	}
//
//	@Autowired
//	@Bean(name = "transactionManager")
//	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
//		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
//
//		return transactionManager;
//	}
}
