package ru.xunto.roleplaychat.dices;

import ru.xunto.roleplaychat.RoleplayChatCore;

public class RoleplayChatDicesCore {
    public static void init() {
        RoleplayChatCore.instance.register(new RollCommand());
    }
}
