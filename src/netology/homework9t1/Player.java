package netology.homework9t1;

import netology.homework9t1.weaponTypes.*;

public class Player {
    private Weapon[] weaponSlots;

    public Player() {
        weaponSlots = new Weapon[] {
                new WaterPistol(),
                new Slingshot(),
                new Pistol(),
                new AssaultRifle(),
                new RPG()
        };
    }

    public int getSlotsCount() {
        return weaponSlots.length;
    }

    public void shotWithWeapon(int slot) {
        try {
            Weapon weapon = weaponSlots[slot];
            weapon.shot();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }
}
