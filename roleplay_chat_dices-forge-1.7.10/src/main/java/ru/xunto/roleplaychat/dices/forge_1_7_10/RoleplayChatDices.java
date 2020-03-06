package ru.xunto.roleplaychat.dices.forge_1_7_10;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;

@Mod(modid = RoleplayChatDices.MODID, version = RoleplayChatDices.VERSION, acceptableRemoteVersions = "*")
public class RoleplayChatDices {
    public static final String MODID = "@@MODID@@";
    public static final String VERSION = "@@VERSION@@";

    @Mod.EventHandler
    public void startServer(FMLServerStartingEvent event) {
        MinecraftServer server = MinecraftServer.getServer();
        ICommandManager command = server.getCommandManager();
        ServerCommandManager manager = (ServerCommandManager) command;

        manager.registerCommand(new DiceCommand());
    }
}
