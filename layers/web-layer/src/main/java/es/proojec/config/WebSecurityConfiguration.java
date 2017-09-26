package es.proojec.config;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by ggb191983 on 10/09/2017.
 */
@Configuration
@EnableWebSecurity(debug = true)
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@ConditionalOnProperty(prefix = "auth0", value = "secret", matchIfMissing = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static Logger logger = getLogger(WebSecurityConfiguration.class);

    @Value("${auth0.apiAudience}")
    private String apiAudience;

    @Value("${auth0.issuer}")
    private String issuer;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("Configuring for Jwt token with iss {} & aud {}", issuer, apiAudience);

        http.csrf().disable();
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/callback", "/login", "/signup").permitAll()
                .antMatchers("/api/**").fullyAuthenticated()
                .and()
                .logout().permitAll();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);

        JwtWebSecurityConfigurer
                .forRS256(apiAudience, issuer)
                .configure(http)
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/v1/**").permitAll()
                .antMatchers(HttpMethod.GET, "/signup").permitAll()
                .antMatchers(HttpMethod.GET, "/login").permitAll()
                .antMatchers(HttpMethod.GET, "/signup").permitAll()
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
}