package me.projeto.eventos;

import me.projeto.entities.WelcomeInventory;
import me.projeto.utils.Item;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerEvents implements Listener {

    @EventHandler
    public void quandoQuebrarBloco(BlockBreakEvent e){
        Player p = e.getPlayer();
        Block b = e.getBlock();

        if (b.getType() != Material.GRASS) return;

        p.sendMessage("§7Você quebrou um bloco de grama e ganhou pressa! §aParabéns!!");
        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20 * 10, 1, false, true));


        ItemStack item = p.getInventory().getItem(0);

        ItemStack elmo = new Item(Material.IRON_HELMET, 1, (short) 0).setNome("&cElmo Mágico").getItemStack();


        if (item == null) p.getInventory().setItem(0, elmo);

        if (item != null && item.getType() == Material.DIAMOND) p.sendMessage("Que legal, você tem um diamante no inventário!");

    }

    @EventHandler
    public void quandoEntrarServidor(PlayerJoinEvent e){
        Player p = e.getPlayer();
        p.sendMessage("Olá jogador, seja bem vindo ao servidor do Ian!");
    }

    @EventHandler
    public void quandoChamarComando(PlayerCommandPreprocessEvent e){
        Player p = e.getPlayer();
        if (e.getMessage().equalsIgnoreCase("/youtube")) {
            p.openInventory(new WelcomeInventory().getInventory());
            p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 10, 10);
            e.setCancelled(true);
        }
    }

}
