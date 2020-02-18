package com.predo.commands;

import com.predo.items.GodClock;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Relogio implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        ItemStack clock = new GodClock().create();
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            if(strings.length == 0){
                p.sendMessage(ChatColor.GREEN + "Como usar: /relogio modo nome_do_modo");
            }
            else if(strings[0].compareTo("criar") == 0){
                p.getInventory().addItem(clock);
                p.sendMessage(ChatColor.GREEN + "Relógio adicionado ao seu inventário");
            }
            else if(strings[0].compareTo("modo") == 0){
                if(strings[1].compareTo("horario") == 0){
                    if(GodClock.getmodeTime()){
                        GodClock.changeMode();
                        p.sendMessage(ChatColor.GREEN + "Relógio configurado para HORÁRIO");
                    }
                    else{
                        p.sendMessage(ChatColor.GREEN + "Relógio configurado para HORÁRIO");
                    }
                }
                else if(strings[1].compareTo("clima") == 0){
                    if(!GodClock.getmodeTime()){
                        GodClock.changeMode();
                        p.sendMessage(ChatColor.GREEN + "Relógio configurado para CLIMA");
                    }
                    else{
                        p.sendMessage(ChatColor.GREEN + "Relógio configurado para CLIMA");
                    }
                }
                else{
                    p.sendMessage(ChatColor.GREEN + "Modo desconhecido! (Modos: horario | clima)");
                }
            }
        }
        return true;
    }
}
