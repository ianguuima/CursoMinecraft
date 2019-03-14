package me.projeto.eventos;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerEvents implements Listener {

    @EventHandler
    public void quandoPingar(ServerListPingEvent e){
        if (!Bukkit.hasWhitelist()) e.setMotd("§aVenha jogar no nosso servidor!");
        else e.setMotd("§cO servidor está em manutenção!");
    }


}
