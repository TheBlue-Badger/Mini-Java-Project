/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaproject;

/**
 *
 * @author Taicy Mandundu
 * 
 */




public class Goblin extends Enemy {
    public Goblin() {
        super("Goblin", 17); 
    }

    @Override
    public boolean isWeakTo(AttackType attack) {
        return attack == AttackType.PRIME_STRIKE && isPrime(hp);
    }

    private boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) 
            if (number % i == 0) return false;
        
        return true; 
    }
}