package com.example.spring;

import entities.Game;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by tobinj on 03/05/2018.
 */
public class RunDemoWithSpring {
    public static void main(String args[]) {

        ApplicationContext ctx
                = new AnnotationConfigApplicationContext(AppConfig.class);

        Game game = ctx.getBean("game", Game.class);
        System.out.println("Away Team = " + game.getAwayTeam());
        System.out.println("Home Team = " + game.getHomeTeam());
        System.out.println(game.playGame());

        System.out.println("There are " + ctx.getBeanDefinitionCount() + " beans");
        for (String name :
                ctx.getBeanDefinitionNames()){
            System.out.println(name);
        }
    }
}
