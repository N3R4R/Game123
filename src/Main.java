import Gun.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        int slot;
        int count;

        while (true) {
            System.out.format("У вас %d слотов с оружием,"
                            + " введите номер слота, чтобы использовать его,"
                            + " -1 чтобы выйти%n",
                    player.getSlotsCount()
            );

            count = player.getSlotsCount();

            slot = scanner.nextInt();
            if (slot < count && slot >= 0){
                player.shotWithWeapon(slot);
            }else {
                System.out.println("Слот не имеет оружи");
            }
            if (slot == -1){
                break;
            }
        }
        System.out.println("Уже все?");
    }
}

class Player {
    private Weapon[] weaponSlots;

    public Player() {
        weaponSlots = new Weapon[] {
                new Bow(),
                new Fireball(),
                new Sword(),


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
