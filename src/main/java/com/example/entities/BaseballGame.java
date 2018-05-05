package com.example.entities;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

public class BaseballGame implements Game {
    private Team homeTeam;
    private Team awayTeam;
    DataSource ds;

    public BaseballGame() {}

    public BaseballGame(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    @PostConstruct
    public void startGame() {
        System.out.println("Playing National Anthem");
    }

    @PreDestroy
    public void endGame() {
        System.out.println("Sending highlights to MLB");
    }

    public void setDataSource(DataSource dataSource) {
        this.ds = dataSource;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    @Override
    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    @Override
    public Team getAwayTeam() {
        return awayTeam;
    }

    @Override
    public String playGame() {
        return "Winner of the game = " +
                (Math.random() < 0.5 ? getHomeTeam().getName() :
                getAwayTeam().getName());
    }

    @Override
    public String toString() {
        return String.format("Game between %s at %s", awayTeam.getName(), homeTeam.getName());
    }
}
