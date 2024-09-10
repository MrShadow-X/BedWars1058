package com.andrei1058.bedwars.listeners;

import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.arena.Arena;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import java.util.ArrayList;
import java.util.List;

public class AntiDropListener implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        if (e.isCancelled()) return;
        Player p = e.getPlayer();
        IArena a = Arena.getArenaByPlayer(p);
        if (a == null) return;
        if (!a.isPlayer(p)) return;
        if (!a.getStatus().equals(GameState.playing)) return;

        List<Block> blocks = new ArrayList();
        blocks.add(p.getLocation().clone().subtract(0.0D, 0.1D, 0.0D).getBlock());

        for(int i = 1; i <= 4; ++i) {
            blocks.add(p.getLocation().clone().subtract(0.0D, i, 0.0D).getBlock());
        }

        if (blocks.stream().allMatch((b) -> b.getType().equals(Material.AIR))) {
            e.setCancelled(true);
        }
    }

}
