package com.example.spring;

import entities.*;

/**
 * Created by tobinj on 03/05/2018.
 */
public class RunDemoWithoutSpring {

    public static void main (String[] args){

        Team redSox = new RedSox();
        Team cubs = new Cubs();
        Game game = new BaseballGame(redSox, cubs);
        System.out.println(game.playGame());

    }
}
