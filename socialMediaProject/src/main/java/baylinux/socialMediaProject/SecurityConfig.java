package baylinux.socialMediaProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import com.vaadin.flow.spring.security.VaadinWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends VaadinWebSecurity{
	
	private UserDetailsService userDetailsService;
	
	
	@Autowired
	public SecurityConfig(UserDetailsService userDetailsService) {
		super();
		this.userDetailsService = userDetailsService;
		
	}
//	 @Override
//	 protected void configure(HttpSecurity http) throws Exception 
//	 {
//	      
//	       super.configure(http);
//	       setLoginView(http, IndexView.class);
//	       
//	           
//	           
//	 }
	
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
	     http.authorizeHttpRequests(auth -> auth
	             .requestMatchers("/VAADIN/**", "/vaadinServlet/**",
	                              "/","/logout","/login", "/LoginView", "/SignUpView").permitAll()
	             // .anyRequest().authenticated()  <-- REMOVE this line
	     ).logout(logout -> logout
                 .logoutUrl("/logout")          
                 .logoutSuccessUrl("/LoginView")
                 .invalidateHttpSession(true)
                 .deleteCookies("JSESSIONID")
				 );
	     
	     super.configure(http);        // Vaadin inserts the final .anyRequest().authenticated()
	     //setLoginView(http, LoginView.class);
	 }
	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
//	{
//		return http
//				.csrf(customizer->customizer.disable())
//				.authorizeHttpRequests(req->req
//						.requestMatchers(
//										    "/",                    // root
//				                           "/VAADIN/**",           // Vaadin statik kaynaklar
//				                            "/vaadinServlet/**",    // Vaadin servlet
//				                            "/ui/**",
//				                            "/sw.js",               // PWA
//				                            "/web-push/**", 
//				                            "/login",               // login sayfası
//				                            "/logout",
//				                            "/LoginView",
//				                            "/SignUpView"
//											).permitAll()
//						//.requestMatchers("/users/**").hasRole("USER")
//						.anyRequest().authenticated())
//				 .logout(logout -> logout
//		                    .logoutUrl("/logout")          
//		                    .logoutSuccessUrl("/LoginView")
//		                    .invalidateHttpSession(true)
//		                    .deleteCookies("JSESSIONID")
//						 )
//			  //.formLogin(Customizer.withDefaults())
//				.httpBasic(Customizer.withDefaults())
//				.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//				//.addFilterBefore(jWTFilter, UsernamePasswordAuthenticationFilter.class)
////				.cors(httpSecurityCorsConfigurer->
////				{
////					CorsConfiguration configuration=new CorsConfiguration();
////					configuration.setAllowedOrigins(List.of("*"));
////					configuration.setAllowedMethods(List.of("*"));
////					configuration.setAllowedHeaders(List.of("*"));
////					UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
////					source.registerCorsConfiguration("/**", configuration);
////					httpSecurityCorsConfigurer.configurationSource(source);
////				})
//				.build();
//				
//	}
	 @Bean
	 public PasswordEncoder passwordEncoder()
	 {
		return new BCryptPasswordEncoder(12);
	 }
	@Bean
	public AuthenticationProvider authenticationProvider() 
	{
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
	{
		return config.getAuthenticationManager();
		
	}
	
//	 @Bean
//	 public AuthenticationManager authenticationManager(UserDetailsService userDetailsService,
//	                                                    PasswordEncoder passwordEncoder) {
//	     DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//	     provider.setUserDetailsService(userDetailsService);
//	     provider.setPasswordEncoder(passwordEncoder);
//	     return new ProviderManager(provider);
//	 }
	
	@Bean 
	public RestTemplate restTemplate() 
	{
		return new RestTemplate();
	}
//	@Bean
//	public UserDetailsService userDetailsService()
//	{
//		UserDetails inMemoryUser=User
//										.builder()
//										.username("inMemoryUser")
//										.password("$2a$12$RrtH5At9LG0UOipBkO2EiOnhRVSJ..6X01XJ0ZB4scs4CIHRfWKxO")
//										.roles("USER","ADMIN")
//										.build();
//		UserDetails inMemoryUser2=User
//				.builder()
//				.username("inMemoryUser2")
//				.password("$2a$12$RrtH5At9LG0UOipBkO2EiOnhRVSJ..6X01XJ0ZB4scs4CIHRfWKxO")
//				.roles("USER")
//				.build();	
//		return new InMemoryUserDetailsManager(inMemoryUser,inMemoryUser2);
//		
//	}

}
