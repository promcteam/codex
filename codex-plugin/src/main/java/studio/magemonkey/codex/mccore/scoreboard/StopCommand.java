/**
 * Codex
 * studio.magemonkey.codex.mccore.scoreboard.StopCommand
 * <p>
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2024 MageMonkeyStudio
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software") to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package studio.magemonkey.codex.mccore.scoreboard;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import studio.magemonkey.codex.mccore.commands.CommandHandler;
import studio.magemonkey.codex.mccore.commands.ICommand;
import studio.magemonkey.codex.mccore.commands.SenderType;

/**
 * Stops a player's scoreboard from cycling
 */
public class StopCommand implements ICommand {

    /**
     * Executes the command
     *
     * @param handler command handler
     * @param plugin  plugin reference
     * @param sender  sender of the command
     * @param args    command arguments
     */
    @Override
    public void execute(CommandHandler handler, Plugin plugin, CommandSender sender, String[] args) {
        PlayerBoards board = BoardManager.getPlayerBoards(sender.getName());
        if (!board.isCycling())
            sender.sendMessage(ChatColor.DARK_RED + "Your scoreboard is already stopped");
        else {
            board.stopCycling();
            sender.sendMessage(ChatColor.DARK_GREEN + "Your scoreboard is no longer cycling");
        }
    }

    /**
     * @return permission needed for this command
     */
    @Override
    public String getPermissionNode() {
        return ScoreboardNodes.STOP.getNode();
    }

    /**
     * @return args string
     */
    @Override
    public String getArgsString() {
        return "";
    }

    /**
     * @return description
     */
    @Override
    public String getDescription() {
        return "Stops cycling the scoreboard";
    }

    /**
     * Sender required for the command
     */
    @Override
    public SenderType getSenderType() {
        return SenderType.PLAYER_ONLY;
    }
}
