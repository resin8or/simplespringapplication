package com.example.spring;

import com.example.entities.BaseballGame;
import com.example.entities.Game;
import com.example.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.text.NumberFormat;
import java.util.List;

/**
 * Created by tobinj on 03/05/2018.
 */
@Configuration
@ComponentScan (basePackages = "com.example")
// Search current directory and component dirs
// Could use @Import to import another config file.
public class AppConfig {
    // Go find this wherever it exists.
    // Only works if only one bean (class or interface)
    // of that type available.
    @Autowired
    private DataSource ds;

    @Autowired @Qualifier("redSox")
    private Team home;
    @Autowired @Qualifier("cubs")
    private Team away;

    @Autowired
    private List<Team> teams;

    // When not using the XML Config to get the NumberFormat
    // Class this can be done instead (comment out if using
    // the XML Config example
    @Bean
    public NumberFormat nf(){
        return NumberFormat.getCurrencyInstance();
    }

    // @Resource wlll autowire by name.  java standard.
    // Might not want this if you want to use the types
    // and swap the implementation etc.
    //@Resource
    //private Team royals;

    // Default scope for Spring beans is Singleton!
    //@Bean @Scope("prototype")
    // Note when the scope is prototype (not singleton)
    // the pre destroy method does not run!
    @Bean
    public Game game(){
        BaseballGame baseballGame
                = new BaseballGame(teams.get(0), teams.get(1));
        baseballGame.setDataSource(ds);
        return baseballGame;
    }

}
