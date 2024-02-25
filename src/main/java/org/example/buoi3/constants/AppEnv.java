package org.example.buoi3.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:environment.properties")
public class AppEnv {
    public static String secretKey;
    @Value("${secret.key1}")
    public void setSecretKey(String secretKey){
        AppEnv.secretKey = secretKey;
    }
    public static Integer timeExpiration;

    @Value("${time.expiration}")
    public void setTimeExpiration(Integer timeExpiration){
        AppEnv.timeExpiration = timeExpiration;
    }
}
