package me.projeto;

import me.projeto.comandos.Ajuda;
import me.projeto.eventos.InventoryClick;
import me.projeto.eventos.PlayerEvents;
import me.projeto.eventos.ServerEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Projeto extends JavaPlugin {

    @Override
    public void onEnable() {
        carregarConfig();
        registrarEventos();
        registrarComandos();
    }


    private void registrarEventos(){
        Bukkit.getPluginManager().registerEvents(new PlayerEvents(), this);
        Bukkit.getPluginManager().registerEvents(new ServerEvents(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClick(), this);
    }

    private void registrarComandos(){
        getCommand("ajuda").setExecutor(new Ajuda());
    }


    private void carregarConfig(){
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }
}
