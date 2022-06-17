package tk.jacobcraft.lucifersplugin.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHelloworld implements CommandExecutor {
    @Override
    public boolean onCommand (CommandSender sender, Command command, String label, String[] args){
        if(command.getName().equals("helloworld")){
            if(sender.hasPermission("luciferessentials.helloworld")){
                sender.sendMessage("hello world!");
            }else{
                sender.sendMessage("§1[§4lucifers§1] §4you are not authorised, get recked!");
                return false;
            }
            return true;
        }
        return false;
    }
}
