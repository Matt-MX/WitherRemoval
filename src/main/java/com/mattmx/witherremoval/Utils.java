package com.mattmx.witherremoval;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    private static final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");
    public static String chat (String s) {
        if (Bukkit.getVersion().contains("1.16")) {
            Matcher match = pattern.matcher(s);
            while (match.find()) {
                String color = s.substring(match.start(), match.end());
                s = s.replace(color, ChatColor.of(color) + "");
                match = pattern.matcher(s);
            }
        }
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static boolean noPerms(Player p) {
        p.sendMessage(Utils.chat(Witherremoval.PRE + " &9&l> &fYou do not have permissions to do this command!"));
        return false;
    }
}