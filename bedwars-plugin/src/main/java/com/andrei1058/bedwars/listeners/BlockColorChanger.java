package com.andrei1058.bedwars.listeners;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.arena.team.TeamColor;
import com.andrei1058.bedwars.api.server.ServerType;
import com.andrei1058.bedwars.arena.Arena;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class BlockColorChanger implements Listener {

    @EventHandler
    public void onItemPickup(EntityPickupItemEvent e) {
        if (e.isCancelled()) return;
        Player p = (Player) e.getEntity();
        IArena a = Arena.getArenaByPlayer(p);
        if (a == null) return;
        if (!a.isPlayer(p)) return;
        if (!a.getStatus().equals(GameState.playing)) return;

        Item item = e.getItem();
        int amount = e.getItem().getItemStack().getAmount();

        if (item.getItemStack().getType().name().contains("WOOL")) {
            DyeColor color = a.getTeam(p).getColor().dye();
            if (item.getItemStack().getType().name().equals(color + "_WOOL")) return;

            ItemStack i = new ItemStack(Objects.requireNonNull(Material.getMaterial(color + "_WOOL")));
            i.setAmount(amount);
            item.setItemStack(i);

        } else if (item.getItemStack().getType().name().contains("CONCRETE")) {
            DyeColor color = a.getTeam(p).getColor().dye();
            if (item.getItemStack().getType().name().equals(color + "_CONCRETE")) return;

            ItemStack i = new ItemStack(Objects.requireNonNull(Material.getMaterial(color + "_CONCRETE")));
            i.setAmount(amount);
            item.setItemStack(i);

        } else if (item.getItemStack().getType().name().contains("TERRACOTTA")) {
            DyeColor color = a.getTeam(p).getColor().dye();
            if (item.getItemStack().getType().name().equals(color + "_TERRACOTTA")) return;

            ItemStack i = new ItemStack(Objects.requireNonNull(Material.getMaterial(color + "_TERRACOTTA")));
            i.setAmount(amount);
            item.setItemStack(i);

        } else if (item.getItemStack().getType().name().contains("STAINED_GLASS")) {
            DyeColor color = a.getTeam(p).getColor().dye();
            if (item.getItemStack().getType().name().equals(color + "_STAINED_GLASS")) return;

            ItemStack i = new ItemStack(Objects.requireNonNull(Material.getMaterial(color + "_STAINED_GLASS")));
            i.setAmount(amount);
            item.setItemStack(i);

        }

    }


    // Change Wool and Concrete drop to be colored in player team color (DISABLED RIGHT NOW BUT IT'S WORKING)
//    @EventHandler
//    public void onBlockDestroy(BlockBreakEvent e) {
//        if (e.isCancelled()) return;
//        Player p = e.getPlayer();
//        if (!p.getGameMode().equals(GameMode.SURVIVAL)) return;
//        if (p.getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) return;
//
//        IArena a = Arena.getArenaByPlayer(p);
//        if (a == null) return;
//        if (!a.isPlayer(p)) return;
//        if (!a.getStatus().equals(GameState.playing)) return;
//
//        World w = p.getWorld();
//        Block b = e.getBlock();
//
//        if (b.getType().name().contains("WOOL")) {
//            DyeColor color = a.getTeam(p).getColor().dye();
//            if (b.getType().name().equals(color + "_WOOL")) return;
//
//            ItemStack i = new ItemStack(Objects.requireNonNull(Material.getMaterial(color + "_WOOL")));
//            e.setDropItems(false);
//            w.dropItemNaturally(b.getLocation(), i);
//
//        } else if (b.getType().name().contains("CONCRETE")) {
//            DyeColor color = a.getTeam(p).getColor().dye();
//            if (b.getType().name().equals(color + "_CONCRETE")) return;
//
//            ItemStack i = new ItemStack(Objects.requireNonNull(Material.getMaterial(color + "_CONCRETE")));
//            e.setDropItems(false);
//            w.dropItemNaturally(b.getLocation(), i);
//
//        } else if (b.getType().name().contains("TERRACOTTA")) {
//            DyeColor color = a.getTeam(p).getColor().dye();
//            if (b.getType().name().equals(color + "_TERRACOTTA")) return;
//
//            ItemStack i = new ItemStack(Objects.requireNonNull(Material.getMaterial(color + "_TERRACOTTA")));
//            e.setDropItems(false);
//            w.dropItemNaturally(b.getLocation(), i);
//
//        }
//
//    }
}
