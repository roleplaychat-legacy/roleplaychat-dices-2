package ru.xunto.roleplaychat.dices.spigot;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import ru.xunto.roleplaychat.dices.RoleplayChatDicesCore;

public final class RoleplayChatDices extends JavaPlugin implements Listener {
    @Override
    public void onLoad() {
        RoleplayChatDicesCore.init();
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }
}
