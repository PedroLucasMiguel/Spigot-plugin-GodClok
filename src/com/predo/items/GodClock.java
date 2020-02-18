package com.predo.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GodClock {
    public static boolean isDay;
    public static boolean isRaining;
    public static boolean modeTime = false; //true = clima || false = horario

    public static void checkTime(Player p){
        if(p.getWorld().getTime() >= 12000){
            isDay = false;
        }
        else{
            isDay = true;
        }

        if(p.getWorld().hasStorm()){
            isRaining = true;
        }
        else{
            isRaining = false;
        }
    }

    public static boolean getmodeTime(){
        return modeTime;
    }

    public static boolean getisRaining(){
        return isRaining;
    }

    public static boolean getisDay(){
        return isDay;
    }

    public static boolean changeMode(){
        if(modeTime){
            modeTime = false;
        }
        else{
            modeTime = true;
        }
        return modeTime;
    }

    public static boolean changeRaining(){
        if(isRaining){
            isRaining = false;
        }
        else{
            isRaining = true;
        }
        return isRaining;
    }

    public static boolean changeDay(){
        if(isDay){
            isDay = false;
        }
        else{
            isDay = true;
        }
        return isDay;
    }

    public ItemStack create(){
        ItemStack clock = new ItemStack(Material.CLOCK);
        ItemMeta meta = clock.getItemMeta();

        ArrayList <String> lore = new ArrayList<String>();;
        lore.add("Use seus poderes para mudar o tempo!");

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&lRELÓGIO SAGRADO"));
        meta.setLore(lore);
        clock.setItemMeta(meta);
        clock.addUnsafeEnchantment(Enchantment.DURABILITY, 5);

        return clock;
    }

}
