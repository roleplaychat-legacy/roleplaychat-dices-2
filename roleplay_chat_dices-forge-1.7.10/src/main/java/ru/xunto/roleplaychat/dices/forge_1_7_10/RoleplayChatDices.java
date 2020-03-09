package ru.xunto.roleplaychat.dices.forge_1_7_10;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import ru.xunto.roleplaychat.RoleplayChatCore;
import ru.xunto.roleplaychat.dices.RollCommand;

@Mod(modid = RoleplayChatDices.MODID, version = RoleplayChatDices.VERSION, acceptableRemoteVersions = "*", dependencies = "required-after:roleplaychat")
public class RoleplayChatDices {
    public static final String MODID = "@@MODID@@";
    public static final String VERSION = "@@VERSION@@";

    static {
        RoleplayChatCore.instance.register(new RollCommand());
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
    }
}
