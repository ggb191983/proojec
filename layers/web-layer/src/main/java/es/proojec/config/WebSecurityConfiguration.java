package es.proojec.config;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * Created by ggb191983 on 10/09/2017.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${auth0.apiAudience}")
    private String apiAudience;

    @Value("${auth0.issuer}")
    private String issuer;

    @Value(value = "${auth0.domain}")
    private String domain;

    @Value(value = "${auth0.clientId}")
    private String clientId;

    @Value(value = "${auth0.clientSecret}")
    private String clientSecret;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .authorizeRequests()
                .antMatchers("/callback", "/login").permitAll()
                .antMatchers("/**").authenticated()
                .and()
                .logout().permitAll();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);

        JwtWebSecurityConfigurer
                .forRS256(apiAudience, issuer)
                .configure(http)
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/login").permitAll()
                .antMatchers(HttpMethod.GET, "/photos/**").hasAuthority("read:photos")
                .antMatchers(HttpMethod.POST, "/photos/**").hasAuthority("create:photos")
                .antMatchers(HttpMethod.PUT, "/photos/**").hasAuthority("update:photos")
                .antMatchers(HttpMethod.DELETE, "/photos/**").hasAuthority("delete:photos")
                .anyRequest().authenticated();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/assets/**")
                .antMatchers("/static/**")
                .antMatchers("/resources/**")
                .antMatchers("/public/**");
    }

    public String getApiAudience() {
        return apiAudience;
    }

    public String getIssuer() {
        return issuer;
    }

    public String getDomain() {
        return domain;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }
}