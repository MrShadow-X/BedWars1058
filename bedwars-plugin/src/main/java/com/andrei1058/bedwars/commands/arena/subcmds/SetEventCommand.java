package com.andrei1058.bedwars.commands.arena.subcmds;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.arena.NextEvent;
import com.andrei1058.bedwars.api.command.ParentCommand;
import com.andrei1058.bedwars.api.command.SubCommand;
import com.andrei1058.bedwars.api.configuration.ConfigPath;
import com.andrei1058.bedwars.api.language.Messages;
import com.andrei1058.bedwars.arena.Arena;
import com.andrei1058.bedwars.commands.bedwars.MainCommand;
import com.andrei1058.bedwars.configuration.Permissions;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static com.andrei1058.bedwars.api.language.Language.getMsg;

public class SetEventCommand extends SubCommand {

    public SetEventCommand(ParentCommand parent, String name) {
        super(parent, name);
        setPriority(1);
        showInList(true);
        setDisplayInfo(com.andrei1058.bedwars.commands.bedwars.MainCommand.createTC("§6 ▪ §7/"+ MainCommand.getInstance().getName()+" "+getSubCommandName(), "/"+getParent().getName()+" "+getSubCommandName(), "§fSets current event for arena."));
    }

    @Override
    public List<String> getTabComplete()  {
        return Arrays.asList("Diamond-II", "Diamond-III", "Emerald-II", "Emerald-III", "Beds-Destruction", "Sudden-Death", "Game-End");
    }

    @Override
    public boolean execute(String[] args, CommandSender s) {
        if (s instanceof ConsoleCommandSender) return false;
        Player p = (Player) s;
        if (!(p.hasPermission(Permissions.PERMISSION_ALL) || p.hasPermission(Permissions.PERMISSION_ARENA_SETEVENT))) {
            p.sendMessage(getMsg(p, Messages.COMMAND_FORCESTART_NO_PERM));
            return true;
        }

        IArena arena = Arena.getArenaByName(args[0]);
        if (arena == null) {
            p.sendMessage(getMsg(p, Messages.COMMAND_JOIN_GROUP_OR_ARENA_NOT_FOUND).replace("{name}", args[0]));
            return true;
        }
        if (arena.getStatus() != GameState.playing) {
            p.sendMessage("§cWybrana przez Ciebie arena musi być rozpoczęta.");
            return true;
        }

        String event = args[1];

        if (event == null) {
            p.sendMessage("§cMusisz podać nazwę wydarzenia, które chcesz ustawić.");
            return true;
        }

        boolean changed = false;
        String currentEvent = null;

        if (event.equalsIgnoreCase("diamond-ii")) {
            arena.setNextEvent(NextEvent.EMERALD_GENERATOR_TIER_II);
            arena.sendDiamondsUpgradeMessages();
            currentEvent = "§b§lDiament II";
            changed = true;
        } else if (event.equalsIgnoreCase("diamond-iii")) {
            arena.setNextEvent(NextEvent.EMERALD_GENERATOR_TIER_III);
            arena.sendDiamondsUpgradeMessages();
            currentEvent = "§b§lDiament III";
            changed = true;
        } else if (event.equalsIgnoreCase("emerald-ii")) {
            arena.setNextEvent(NextEvent.DIAMOND_GENERATOR_TIER_III);
            arena.sendEmeraldsUpgradeMessages();
            currentEvent = "§a§lEmerald II";
            changed = true;
        } else if (event.equalsIgnoreCase("emerald-iii")) {
            arena.setNextEvent(NextEvent.BEDS_DESTROY);
            arena.sendEmeraldsUpgradeMessages();
            currentEvent = "§a§lEmerald III";
            changed = true;
        } else if (event.equalsIgnoreCase("beds-destruction")) {
            arena.setNextEvent(NextEvent.ENDER_DRAGON);
            currentEvent = "§c§lDestrukcja Łóżek";
            changed = true;
        } else if (event.equalsIgnoreCase("sudden-death")) {
            arena.setNextEvent(NextEvent.GAME_END);
            currentEvent = "§4§lNagła Śmierć";
            changed = true;
        } else if (event.equalsIgnoreCase("game-end")) {
            arena.setStatus(GameState.restarting);
            currentEvent = "§6§lKoniec Gry";
            changed = true;
        }

        if (changed) {
            p.sendMessage("§aWydarzenie " + currentEvent + " §azostało ustawione na §6" + arena.getDisplayName() + "§8 (" + arena.getArenaName() + "§8)§a.");
        } else {
            p.sendMessage("§cNie udało się zmienić wydarzenia na arenie §6" + arena.getDisplayName() + " §8(" + arena.getArenaName() + "§8) §c.");
        }
        return true;
    }

}
