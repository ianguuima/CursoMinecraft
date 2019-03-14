package me.projeto.entities;

import me.projeto.utils.Item;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class WelcomeInventory {

    private Inventory inventory;

    public WelcomeInventory() {
        inventory = Bukkit.createInventory(null, 9 * 3, "§7Bem vindo ao servidor!");
        insertItens();
    }

    private void insertItens(){
        ItemStack i = new Item(Material.DIAMOND, 1, (short) 0).setNome("§aItem 1").getItemStack();
        ItemStack i2 = new Item(Material.GOLD_INGOT, 1, (short) 0).setNome("§aItem 2").getItemStack();

        inventory.setItem(12, i);
        inventory.setItem(14, i2);
    }

    public Inventory getInventory() {
        return inventory;
    }
}
