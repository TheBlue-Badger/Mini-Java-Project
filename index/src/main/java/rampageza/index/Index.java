/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package rampageza.index;

/**
 *
 * @author Taicy Mandundu
 */
import java.util.*;
import java.io.*;

public class Index {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Step 1: Get Player Name
        String playerName;
        do {
            System.out.print("Enter your name (letters only): ");
            playerName = scanner.nextLine();
        } while (!playerName.matches("[a-zA-Z]+"));

        Player player = new Player(playerName);
        Enemy enemy = random.nextBoolean() ? new Slime() : new Goblin();

        System.out.println("\nA wild " + enemy.getName() + " appeared! HP: " + enemy.getHp());

        // Step 2: Battle loop
        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\nChoose your attack:");
            System.out.println("1. Basic Strike");
            System.out.println("2. Prime Strike");
            System.out.println("3. Modulus Strike");

            int choice = 0;
            while (choice < 1 || choice > 3) {
                System.out.print("Enter your choice (1-3): ");
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException ignored) {}
            }

            AttackType attack = switch (choice) {
                case 2 -> AttackType.PRIME_STRIKE;
                case 3 -> AttackType.MODULUS_STRIKE;
                default -> AttackType.BASIC_STRIKE;
            };

            System.out.println(player.getName() + "\n uses " + attack + "!");

            boolean effective = attack == AttackType.BASIC_STRIKE || enemy.isWeakTo(attack);
            if (effective) {
                enemy.reduceHp(5);
                player.increaseScore(10);
                System.out.println("The attack was effective!");
            } else {
                System.out.println("The attack had no effect.");
            }

            if (!enemy.isAlive()) break;

            int counterDamage = random.nextInt(4) + 3; // 3 to 6
            player.reduceHp(counterDamage);
            System.out.println(enemy.getName() + " counterattacks! Deals " + counterDamage + " damage.");

            System.out.println(player.getName() + " HP: " + player.getHp());
            System.out.println(enemy.getName() + " HP: " + enemy.getHp());
        }

        // Step 3: End of Game
        if (player.isAlive()) {
            System.out.println("\nYou defeated the " + enemy.getName() + "!");
        } else {
            System.out.println("\nYou were defeated by the " + enemy.getName() + "...");
        }

        System.out.println(player.getName() + "'s Final Score: " + player.getScore());

        // Step 4: Save score
        try (FileWriter writer = new FileWriter("src/main/java/rampageza/index/scores.txt", true);
) {
            writer.write(player.getName() + " - Score: " + player.getScore() + "\n");
            System.out.println("Score saved to scores.txt");
        } catch (IOException e) {
            System.out.println("Could not save score.");
        }
    }
}


// remember to add documentatioin


