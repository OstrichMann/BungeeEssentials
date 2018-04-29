package com.pantherman594.gssentials.command.general;

import com.pantherman594.gssentials.Permissions;
import com.pantherman594.gssentials.command.BECommand;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

@SuppressWarnings("unused")
public class HubCommand extends BECommand {
    public HubCommand() {
        super("hub", Permissions.General.HUB);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer) {

            ProxiedPlayer player = (ProxiedPlayer) sender;
            ServerInfo info = ProxyServer.getInstance().getServerInfo("lobby");

            if (info.canAccess(player)) {
                sender.sendMessage(ChatColor.LIGHT_PURPLE + "Attempting to connect you to Lobby!");
                player.connect(info);
            } else {
                sender.sendMessage(ProxyServer.getInstance().getTranslation("no_server_permission"));
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Console cannot join servers");
        }
    }
}

