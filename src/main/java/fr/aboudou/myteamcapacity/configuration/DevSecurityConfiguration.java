package fr.aboudou.myteamcapacity.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DevSecurityConfiguration extends WebSecurityConfigurerAdapter {




    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
            auth
                .inMemoryAuthentication()
                .withUser("user")
                .password("{noop}password")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/","/login/**", "/css/**", "/h2-console/*").permitAll()
                    .anyRequest().authenticated().and()
                .csrf()
                .ignoringAntMatchers("/h2-console/*")
                    .and()
                .httpBasic();
        http.headers().frameOptions().disable();
    }
}
