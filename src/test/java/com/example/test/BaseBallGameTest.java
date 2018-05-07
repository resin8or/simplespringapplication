package com.example.test;

import com.example.entities.Game;
import com.example.entities.Team;
import com.example.spring.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by tobinj on 07/05/2018.
 */
// SpringJunit4ClassRunner allows you to cache the App Ctx (so not calling twice).
@RunWith(SpringJUnit4ClassRunner.class)
// Specify the name of the class where the config info is contained.
@ContextConfiguration(classes = AppConfig.class)
public class BaseBallGameTest {
    @Autowired // Remove the annotation if want to use @Before
    private Game game;

    @Autowired // Remove the annotation if want to use @Before
    private ApplicationContext ctx; // Loading once and then cached.

    // Don't need the before now as using the SpringJunit4ClassRunnner and
    // have autowired the classes needed for the testing.
//    @Before
//    public void setUp(){
//        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        game = ctx.getBean("game", Game.class);
//    }

    @Test
    public void testPlayGame() throws Exception{
        String home = game.getHomeTeam().getName();
        String away = game.getAwayTeam().getName();

        String result = game.playGame();

        assertTrue(result.contains(home) || result.contains(away));
        //assertTrue(result.contains("jamie"));
    }

    public void testGetAndSetHomeTeam() throws Exception{
        Team royals = ctx.getBean("royals", Team.class);
        game.setHomeTeam(royals);
        assertEquals(royals.getName(), game.getHomeTeam().getName());
    }
}
