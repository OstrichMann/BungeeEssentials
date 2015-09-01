/*
 * BungeeEssentials: Full customization of a few necessary features for your server!
 * Copyright (C) 2015  David Shen (PantherMan594)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.pantherman594.gssentials.command.admin;

import com.pantherman594.gssentials.BungeeEssentials;
import com.pantherman594.gssentials.command.ServerSpecificCommand;
import com.pantherman594.gssentials.utils.Dictionary;
import com.pantherman594.gssentials.utils.Messenger;
import com.pantherman594.gssentials.utils.Permissions;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;

@SuppressWarnings("deprecation")
public class CSpyCommand extends ServerSpecificCommand {
    public CSpyCommand() {
        super(BungeeEssentials.CSpy_MAIN, Permissions.Admin.SPY_COMMAND, BungeeEssentials.CSpy_ALIAS);
    }

    @Override
    public void run(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            if (args != null && args.length == 1) {
                if (args[0].equals("on")) {
                    Messenger.enableCSpy(player);
                    player.sendMessage(Dictionary.format(Dictionary.CSPY_ENABLED));
                } else if (args[0].equals("off")) {
                    Messenger.disableCSpy(player);
                    player.sendMessage(Dictionary.format(Dictionary.CSPY_DISABLED));
                }
            } else {
                if (Messenger.toggleCSpy(player)) {
                    player.sendMessage(Dictionary.format(Dictionary.CSPY_ENABLED));
                } else {
                    player.sendMessage(Dictionary.format(Dictionary.CSPY_DISABLED));
                }
            }
        } else {
            sender.sendMessage(Dictionary.colour("&cConsole may not toggle command spy"));
        }
    }
}