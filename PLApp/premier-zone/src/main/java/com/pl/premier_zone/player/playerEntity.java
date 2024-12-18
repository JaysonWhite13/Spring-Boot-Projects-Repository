package com.pl.premier_zone.player;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "player_statistic")
public class playerEntity {
    //Entity represents the data model in the app and it maps directly to the database table.
    @Id
    @Column(name = "player_name", unique = true)
    private String name;
    private String nation;
    private String position;
    private Integer age;
    private Integer mp;
    private  Integer starts;
    private Double minutes;
    private Double goals;
    private Double ast;
    private Double pScored;
    private Double yCards;
    private Double rCards;
    private Double xGoals;
    private Double xAst;
    private String teamName;


    public playerEntity() {
    }

    public playerEntity(String name, String nation, String position, Integer age, Integer mp, Integer starts, Double minutes, Double goals, Double ast, Double pScored, Double yCards, Double rCards, Double xGoals, Double xAst, String teamName) {
        this.name = name;
        this.nation = nation;
        this.position = position;
        this.age = age;
        this.mp = mp;
        this.starts = starts;
        this.minutes = minutes;
        this.goals = goals;
        this.ast = ast;
        this.pScored = pScored;
        this.yCards = yCards;
        this.rCards = rCards;
        this.xGoals = xGoals;
        this.xAst = xAst;
        this.teamName = teamName;
    }

    public playerEntity(String name) {
        this.name = name;
    }

    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMp() {
        return mp;
    }

    public void setMp(Integer mp) {
        this.mp = mp;
    }

    public Integer getStarts() {
        return starts;
    }

    public void setStarts(Integer starts) {
        this.starts = starts;
    }

    public Double getMinutes() {
        return minutes;
    }

    public void setMinutes(Double minutes) {
        this.minutes = minutes;
    }

    public Double getGoals() {
        return goals;
    }

    public void setGoals(Double goals) {
        this.goals = goals;
    }

    public Double getAst() {
        return ast;
    }

    public void setAst(Double ast) {
        this.ast = ast;
    }

    public Double getpScored() {
        return pScored;
    }

    public void setpScored(Double pScored) {
        this.pScored = pScored;
    }

    public Double getyCards() {
        return yCards;
    }

    public void setyCards(Double yCards) {
        this.yCards = yCards;
    }

    public Double getrCards() {
        return rCards;
    }

    public void setrCards(Double rCards) {
        this.rCards = rCards;
    }

    public Double getxGoals() {
        return xGoals;
    }

    public void setxGoals(Double xGoals) {
        this.xGoals = xGoals;
    }

    public Double getxAst() {
        return xAst;
    }

    public void setxAst(Double xAst) {
        this.xAst = xAst;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
