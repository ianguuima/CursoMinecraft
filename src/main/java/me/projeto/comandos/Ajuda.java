package me.projeto.comandos;

import me.projeto.utils.Item;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Ajuda implements CommandExecutor {

    private HashMap<Player, Long> ajuda = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if (!(s instanceof Player)) return false;
        Player p = (Player) s;

        if (c.getName().equalsIgnoreCase("ajuda")) {

            if (ajuda.containsKey(p) && !(System.currentTimeMillis() >= ajuda.get(p))){
                p.sendMessage("§7Aguarde, comando em cooldown. Aguarde §c" + converter(p) + " §7segundos!");
                return false;
            } else ajuda.remove(p);



            ajuda.put(p, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(10));

            if (args.length == 0) {
                p.sendMessage("");
                p.sendMessage("Digite /ajuda 1 - para o servidor");
                p.sendMessage("Digite /ajuda 2 - para youtube");
                p.sendMessage("");
                return true;
            }

            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("1")) {

                    p.sendMessage("§7O servidor está na versão 1.9 até a 1.12.2");

                    ItemStack diamante = new Item(Material.DIAMOND, 1, (short) 0)
                            .setNome("§6Um diamante bem legal!")
                            .setLore(Collections.singletonList("§cUm diamante bem brilhoso!"))
                            .getItemStack();

                    ItemStack ouro = new Item(Material.GOLD_INGOT, 1, (short) 0)
                            .setNome("&6Um ouro bem legal!")
                            .setLore(Collections.singletonList("§cUm ouro bem brilhoso!"))
                            .setEncanto(Enchantment.DURABILITY, 1)
                            .esconderEncantos()
                            .getItemStack();

                    p.getInventory().addItem(diamante);
                    p.getInventory().addItem(ouro);
                    return true;
                }

                if (args[0].equalsIgnoreCase("2")) {
                    p.sendMessage("§cO nosso canal do youtube está indisponível.");
                    return true;
                }
            }


        }


        return false;
    }

    private Long converter(Player p){
        long tempo = System.currentTimeMillis() - ajuda.get(p);
        return 1 + TimeUnit.MILLISECONDS.toSeconds(tempo) * -1;
    }
}
