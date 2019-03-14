package me.projeto.eventos;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener {


    @EventHandler
    public void quandoClicar(InventoryClickEvent e){
        if (!e.getInventory().getName().equalsIgnoreCase("§7Bem vindo ao servidor!")) return;
        e.setCancelled(true);

        ItemStack i = e.getCurrentItem();
        Player p = (Player) e.getWhoClicked();
        /* VERIFICAÇÃO POR TIPO
        if (i.getType() == Material.DIAMOND){
            p.closeInventory();
            p.sendMessage("Você está clicando num diamante!");
        }

        if (i.getType() == Material.GOLD_INGOT){
            p.closeInventory();
            p.sendMessage("Você está clicando num ouro!");
        }
        */
        if (!(i.hasItemMeta() && i.getItemMeta().hasDisplayName())) return;


        p.closeInventory();

        if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aItem 1"))
            p.sendMessage("Você está clicando num diamante!");



        if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aItem 2"))
            p.sendMessage("Você está clicando num ouro!");




    }


}
