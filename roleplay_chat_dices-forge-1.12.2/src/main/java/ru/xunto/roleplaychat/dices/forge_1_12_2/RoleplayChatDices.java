package ru.xunto.roleplaychat.dices.forge_1_12_2;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = RoleplayChatDices.MODID, version = RoleplayChatDices.VERSION, acceptableRemoteVersions = "*", dependencies = "required-after:roleplaychat")
public class RoleplayChatDices
{
    public static final String MODID = "@@MODID@@";
    public static final String VERSION = "@@VERSION@@";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
