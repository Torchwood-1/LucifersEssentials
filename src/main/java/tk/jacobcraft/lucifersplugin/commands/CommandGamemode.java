package tk.jacobcraft.lucifersplugin.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;

public class CommandGamemode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command,String label, String[] args){
        GameMode gameMode;
        Player player = null;
        if(matchGameMode(label)!= null){
            gameMode = matchGameMode (label);
        }
        else{
            gameMode = matchGameMode(args[0]);
        }

        try {
            player = sender.getServer().getPlayer(String.valueOf(args [args.length -1]));
        }
        catch(ArrayIndexOutOfBoundsException error){}

        if (player == null){
            if (sender instanceof Player){
                player = (Player) sender;
            }
            else {
                sender.sendMessage("§4You are not a player.\n §eSpecify a player to change their gamemode");
                return false;
            }
        }

        if (gameMode == null){
            sender.sendMessage("§4Invalid gamemode");
            return false;
        }

        player.setGameMode(gameMode);
        sender.sendMessage("§achanged gamemode of §6"+player.getName()+" §ato §6"+gameMode.name());
        return true;
    }
    private GameMode matchGameMode(String modeString){
        GameMode mode = null;
        modeString = modeString.toLowerCase();
        switch (modeString){
            case "gmc":
            case "creative":
            case "1":
                mode = GameMode.CREATIVE;
                break;
            case "gms":
            case "survival":
            case "0":
                mode = GameMode.SURVIVAL;
                break;
            case "gmsp":
            case "spectator":
            case "3":
                mode = GameMode.SPECTATOR;
                break;
        }
        return mode;
    }
}
