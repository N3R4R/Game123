import Gun.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        int slot;
        int count;

        while (true) {
            System.out.format("У игрока %d слотов с оружием,"
                            + " введите номер, чтобы выстрелить,"
                            + " -1 чтобы выйти%n",
                    player.getSlotsCount()
            );

            count = player.getSlotsCount();

            slot = scanner.nextInt();
            if (slot < count && slot >= 0){
                player.shotWithWeapon(slot);
            }else {
                System.out.println("В этом слоте нет оружия");
            }
            if (slot == -1){
                break;
            }
        }
        System.out.println("Game over!");
    }
}

class Player {
    private Weapon[] weaponSlots;

    public Player() {
        weaponSlots = new Weapon[] {
                // TODO заполнить слоты оружием
                new Kirka(),

        };
    }

    public int getSlotsCount() {
        return weaponSlots.length;
    }

    public void shotWithWeapon(int slot) {
        Weapon weapon = weaponSlots[slot];
        weapon.shot();
    }
}
