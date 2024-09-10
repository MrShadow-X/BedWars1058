package com.andrei1058.bedwars.listeners;

import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.arena.Arena;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class BlockChangeName implements Listener {

//    @EventHandler
//    public void onItemPickup(EntityPickupItemEvent e) {
//        if (e.isCancelled()) return;
//        Player p = (Player) e.getEntity();
//        IArena a = Arena.getArenaByPlayer(p);
//        if (a == null) return;
//        if (!a.isPlayer(p)) return;
//        if (!a.getStatus().equals(GameState.playing)) return;
//
//        ItemStack itemStack = e.getItem().getItemStack();
//        Material itemType = itemStack.getType();
//        int amount = e.getItem().getItemStack().getAmount();
//        String displayName = null;
//
//        if (itemType.name().contains("WOOL")) {
//            displayName = "§aWełna";
//        } else if (itemType.name().contains("TERRACOTTA")) {
//            displayName = "§aUtwardzona Glina";
//        } else if (itemType.name().contains("STAINED_GLASS")) {
//            displayName = "§aWzmocnione Szkło";
//        } else if (itemType.equals(Material.END_STONE)) {
//            displayName = "§aKamień Kresu";
//        } else if (itemType.equals(Material.LADDER)) {
//            displayName = "§aDrabina";
//        } else if (itemType.equals(Material.OAK_PLANKS)) {
//            displayName = "§aDrewno";
//        } else if (itemType.equals(Material.OBSIDIAN)) {
//            displayName = "§aObsydian";
//        } else if (itemType.equals(Material.SPONGE)) {
//            displayName = "§aGąbka";
//        } else if (itemType.equals(Material.WET_SPONGE)) {
//            displayName = "§aMokra Gąbka";
//        } else if (itemType.equals(Material.COBWEB)) {
//            displayName = "§aPajęczyna";
//        }
//
//        if (displayName != null) {
//            ItemMeta meta = itemStack.getItemMeta();
//            if (Objects.requireNonNull(meta).getDisplayName().equals(displayName)) return;
//            Objects.requireNonNull(meta).setDisplayName(displayName);
//            itemStack.setItemMeta(meta);
//            itemStack.setAmount(amount);
//            e.getItem().setItemStack(itemStack);
//        }
//    }
}
