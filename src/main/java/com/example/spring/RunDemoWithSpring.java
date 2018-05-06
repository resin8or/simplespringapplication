package com.example.spring;

import com.example.entities.Game;
import com.example.entities.Team;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.NumberFormat;

/**
 * Created by tobinj on 03/05/2018.
 */
public class RunDemoWithSpring {
    public static void main(String args[]) {

        // This is the annotation config
        ApplicationContext ctx
                = new AnnotationConfigApplicationContext(AppConfig.class);

        // This is the XML config approach
//        ApplicationContext ctx
//                = new ClassPathXmlApplicationContext("applicationContext.xml");

        Game game = ctx.getBean("game", Game.class);
        System.out.println("Away Team = " + game.getAwayTeam());
        System.out.println("Home Team = " + game.getHomeTeam());
        System.out.println(game.toString());
        System.out.println(game.playGame());

        Team royals = ctx.getBean("royals", Team.class);
        game.setAwayTeam(royals);
        System.out.println(game.toString());
        System.out.println(game.playGame());
        System.out.println("There are " + ctx.getBeanDefinitionCount() + " beans");
        for (String name :
                ctx.getBeanDefinitionNames()){
            System.out.println(name);
        }

        // Numberformat example for use with Beans example
        //NumberFormat nf = ctx.getBean(NumberFormat.class);

        // This example uses the AppConfig Bean definition.
        // Comment out when using Beans.
        NumberFormat nf = ctx.getBean("nf", NumberFormat.class);
        double amount = 12345678.9012345;
        System.out.println(new StringBuilder().append("Formatted number = ").append(nf.format(amount)).toString());
    }
}
