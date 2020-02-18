package com.predo.main;

import com.predo.commands.Relogio;
import com.predo.items.GodClock;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        this.getCommand("relogio").setExecutor(new Relogio());
        clockCrafing();
        System.out.println("[God Clock] - Inicializado!");
    }

    @Override
    public void onDisable() {
        System.out.println("[God Clock] - Finalizando...");
    }

    @EventHandler
    public void onClockUsage(PlayerInteractEvent e){
        Player p = e.getPlayer();

        ItemStack clockItem = new GodClock().create();
        if(p.getInventory().getItemInMainHand().isSimilar(clockItem)){
            if(GodClock.getmodeTime()){
                GodClock.checkTime(p);
                if(GodClock.getisRaining()){
                    p.sendTitle(ChatColor.RED + "O TEMPO MUDA", ChatColor.WHITE +"SEGUNDO SUA VONTADE!", 3,50,3);
                    p.getWorld().playEffect(p.getLocation(), Effect.ENDERDRAGON_GROWL, 1);
                    p.getWorld().setStorm(false);
                    GodClock.changeDay();
                }
                else{
                    p.sendTitle(ChatColor.RED + "O TEMPO MUDA", ChatColor.WHITE +"SEGUNDO SUA VONTADE!", 3,50,3);
                    p.getWorld().playEffect(p.getLocation(), Effect.ENDERDRAGON_GROWL, 1);
                    p.getWorld().setStorm(true);
                    GodClock.changeDay();
                }
            }
            else{
                GodClock.checkTime(p);
                if(GodClock.getisDay()){
                    p.sendTitle(ChatColor.RED + "O TEMPO MUDA", ChatColor.WHITE +"SEGUNDO SUA VONTADE!", 3,50,3);
                    p.getWorld().playEffect(p.getLocation(), Effect.ENDERDRAGON_GROWL, 1);
                    p.getWorld().setTime(19000);
                    GodClock.changeDay();
                }
                else{
                    p.sendTitle(ChatColor.RED + "O TEMPO MUDA", ChatColor.WHITE +"SEGUNDO SUA VONTADE!", 3,50,3);
                    p.getWorld().playEffect(p.getLocation(), Effect.ENDERDRAGON_GROWL, 1);
                    GodClock.checkTime(p);
                    p.getWorld().setTime(0);
                    GodClock.changeDay();
                }
            }
        }
    }

    private void clockCrafing(){
        ItemStack clockItem = new GodClock().create();

        NamespacedKey key = new NamespacedKey(this, "clock");
        ShapedRecipe clockCraft = new ShapedRecipe(key ,clockItem);

        clockCraft.shape("AGA", "GNG", "AGA");
        clockCraft.setIngredient('A', Material.AIR);
        clockCraft.setIngredient('G', Material.GOLD_INGOT);
        clockCraft.setIngredient('N', Material.NETHER_STAR);

        getServer().addRecipe(clockCraft);
    }
}
