package com.andrei1058.bedwars.listeners;

import com.andrei1058.bedwars.Main;
import com.andrei1058.bedwars.api.ServerType;
import com.andrei1058.bedwars.api.TeamColor;
import com.andrei1058.bedwars.arena.Arena;
import org.bukkit.Material;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import java.util.HashMap;

public class EggBridge implements Listener {

    //Active eggBridges
    private static HashMap<Egg, TeamColor> bridges = new HashMap<>();

    /*@EventHandler
    public void onThrow(PlayerInteractEvent e) {
        ItemStack i = Main.plugin.nms.getItemInHand(e.getPlayer());
        if (i == null) return;
        if (i.getType() != Material.EGG) return;
        Arena a = Arena.getArenaByPlayer(e.getPlayer());
        if (a != null){
            if (a.isPlayer(e.getPlayer())){

            }
        }
    }*/

    @EventHandler
    public void onLaunch(ProjectileLaunchEvent e) {
        if (Main.getServerType() != ServerType.BUNGEE){
            if (e.getEntity().getLocation().getWorld().getName().equalsIgnoreCase(Main.getLobbyWorld())) {
                e.setCancelled(true);
                return;
            }
        }
        if (e.getEntity() instanceof Egg) {
            if (e.getEntity().getShooter() instanceof Player) {
                Player p = (Player) e.getEntity().getShooter();
                Arena a = Arena.getArenaByPlayer(p);
                if (a != null) {
                    if (a.isPlayer(p)) {
                        bridges.put((Egg) e.getEntity(), a.getTeam(p).getColor());
                    }
                }
            }
        }
    }

    @EventHandler
    public void onHit(ProjectileHitEvent e) {
        if (e.getEntity() instanceof Egg) {
            removeEgg((Egg) e.getEntity());
        }
    }

    /**
     * Remove an egg from the active eggs list
     *
     * @since API 7
     */
    public static void removeEgg(Egg e) {
        if (bridges.containsKey(e)) {
            bridges.remove(e);
        }
    }

    /**
     * Get active egg bridges
     *
     * @since API 7
     */
    public static HashMap<Egg, TeamColor> getBridges() {
        return new HashMap<>(bridges);
    }
}
