package com.snail.booklist.config;

import com.snail.booklist.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

/**
 * @author Snail
 * @date 2019/11/19 22:11
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ReaderRepository readerRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/")
                .access("hasRole('READER')")
                .antMatchers("/**")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(new UserDetailsManager() {
                    @Override
                    public void createUser(UserDetails userDetails) {

                    }

                    @Override
                    public void updateUser(UserDetails userDetails) {

                    }

                    @Override
                    public void deleteUser(String s) {

                    }

                    @Override
                    public void changePassword(String s, String s1) {

                    }

                    @Override
                    public boolean userExists(String s) {
                        return false;
                    }

                    @Override
                    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
                        return readerRepository.findByUserName(userName);
                    }
                });
    }

}
