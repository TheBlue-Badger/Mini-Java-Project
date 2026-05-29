/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaproject;

/**
 *
 * @author Taicy Mandundu
 */
public class Player {
    private String name;
    private int hp = 20;
    private int score = 0;

    public Player(String name) {
        this.name = name;
        this.hp =20;
        this.score = 0;
    }

    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getScore() { return score; }

    public void reduceHp(int amount) { this.hp -= amount; }
    public void increaseScore(int amount) { this.score += amount; }
    public boolean isAlive() { return hp > 0; }
}

