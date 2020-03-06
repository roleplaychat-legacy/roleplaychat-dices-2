package ru.xunto.roleplaychat.dices.forge_1_7_10.parser_nodes.roll;

import ru.xunto.roleplaychat.dices.forge_1_7_10.parser_nodes.IResult;
import ru.xunto.roleplaychat.dices.forge_1_7_10.parser_nodes.IRoll;
import ru.xunto.roleplaychat.dices.forge_1_7_10.parser_nodes.result.ResultSub;

public class RollSub implements IRoll {
    private final IRoll roll1;
    private final IRoll roll2;

    public RollSub(IRoll roll1, IRoll roll2) {
        this.roll1 = roll1;
        this.roll2 = roll2;
    }

    @Override
    public IResult roll() {
        return new ResultSub(
                this.roll1.roll(),
                this.roll2.roll()
        );
    }

    @Override
    public String getHumanReadable() {
        return String.format("%s-%s", roll1.getHumanReadable(), roll2.getHumanReadable());
    }
}
