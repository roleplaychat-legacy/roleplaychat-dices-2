package ru.xunto.roleplaychat.dices.forge_1_12_2;

import net.minecraftforge.fml.common.Mod;
import ru.xunto.roleplaychat.dices.RoleplayChatDicesCore;

@Mod(modid = RoleplayChatDices.MODID, version = RoleplayChatDices.VERSION, acceptableRemoteVersions = "*", dependencies = "required-after:roleplaychat")
public class RoleplayChatDices {
    public static final String MODID = "@@MODID@@";
    public static final String VERSION = "@@VERSION@@";

    static {
        RoleplayChatDicesCore.init();
    }
}
