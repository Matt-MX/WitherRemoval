package com.mattmx.witherremoval;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;

import java.util.List;

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Player-only command");
            return false;
        }
        Player p = (Player) sender;
        if (!p.hasPermission("clearwither.use")) return Utils.noPerms(p);
        if (args.length > 0) {
            try {
                int r = Integer.parseInt(args[1]);
                int c = 0;
                for (Entity e : p.getNearbyEntities(r, r, r)) {
                    if (e instanceof Wither) {
                        e.remove();
                        c++;
                    }
                }
                p.sendMessage(Utils.chat(Witherremoval.PRE + " &9&l> &fKilled &c" + c + " &fwithers in a range of &c" + r + " &fblocks!"));
            } catch (Exception e) {
                p.sendMessage(Utils.chat(Witherremoval.PRE + " &9&l> &fNeed to specify a valid range!"));
            }
        } else p.sendMessage(Utils.chat(Witherremoval.PRE + " &9&l> &fNeed to specify a range!"));
        return false;
    }
}
