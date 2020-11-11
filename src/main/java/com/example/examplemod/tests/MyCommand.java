package com.example.examplemod.tests;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class MyCommand extends CommandBase {

    private List aliases;

    public MyCommand(){
        aliases = new ArrayList();
        aliases.add("testCom");
    }

    @Override
    public String getCommandName() {
        return "testCom";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "testCom <text>";
    }

    @Override
    public List<String> getCommandAliases() {
        return this.aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

        if (args.length == 0) {
            EntityPlayer entityplayer = getCommandSenderAsPlayer(sender);
            System.out.println(entityplayer);
            entityplayer.onKillCommand();
        }
        else
        {
            Entity entity = getEntity(server, sender, args[0]);
            System.out.println(entity);

            entity.onKillCommand();
        }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return index == 0;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}
