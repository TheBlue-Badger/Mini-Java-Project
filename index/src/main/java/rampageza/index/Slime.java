/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rampageza.index;

/**
 *
 * @author Taicy Mandundu
 */
public class Slime extends Enemy {
    public Slime() {
        super("Slime", 18);
    }

    @Override
    public boolean isWeakTo(AttackType attack) {
        return attack == AttackType.MODULUS_STRIKE && (hp % 3 == 0);
    }
}
