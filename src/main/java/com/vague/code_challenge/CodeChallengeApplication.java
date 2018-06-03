package com.vague.code_challenge;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.vague.code_challenge.model.entity.User;
import com.vague.code_challenge.repository.UserRepository;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = { "com.vague.code_challenge" })
public class CodeChallengeApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CodeChallengeApplication.class, args);
	}
	
	@Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }
	
	@Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
        messageBundle.setBasename("classpath:locale/messages");
        messageBundle.setDefaultEncoding("UTF-8");
        messageBundle.setCacheSeconds(1);
        return messageBundle;
    }
	
	@Autowired
	private UserRepository userRepository;
	
	@Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
        		userRepository.save(new User("java beans", "foo"));
            System.out.println(" :: Vague Code Challenge from Statflo for VanHack Leap Service Started");
        };
    }
	
}
