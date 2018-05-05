package com.example.spring;

import entities.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

/**
 * Created by tobinj on 03/05/2018.
 */
@Configuration
@Import(InfraConfig.class)
// Could use @Import to import another config file.
public class AppConfig {

    @Bean
    public Game game(DataSource ds){
        BaseballGame baseballGame = new BaseballGame(redsox(), cubs());
        baseballGame.setDataSource(ds);
        return baseballGame;
    }

    @Bean
    public Team redsox(){return new RedSox();}

    @Bean
    public Team cubs(){return new Cubs();}

}
