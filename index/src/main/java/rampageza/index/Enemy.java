/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rampageza.index;

/**
 *
 * @author Taicy Mandundu
 */

// Must be abstract: so that i cannot accidently create a enemy class but only its subclasses

public abstract class Enemy {
    protected String name;
    protected int hp;

    public Enemy(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public String getName() { return name; }
    public int getHp() { return hp; }

    public void reduceHp(int amount) { this.hp -= amount; }
    public boolean isAlive() { return hp > 0; }

    public abstract boolean isWeakTo(AttackType attack);
}
