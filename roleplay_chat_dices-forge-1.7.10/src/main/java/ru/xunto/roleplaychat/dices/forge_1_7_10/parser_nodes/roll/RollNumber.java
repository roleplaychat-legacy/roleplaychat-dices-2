package ru.xunto.roleplaychat.dices.forge_1_7_10.parser_nodes.roll;

import ru.xunto.roleplaychat.dices.forge_1_7_10.parser_nodes.IResult;
import ru.xunto.roleplaychat.dices.forge_1_7_10.parser_nodes.IRoll;
import ru.xunto.roleplaychat.dices.forge_1_7_10.parser_nodes.result.ResultNumber;

public class RollNumber implements IRoll {
    private int number;

    public RollNumber(int number) {
        this.number = number;
    }

    @Override
    public IResult roll() {
        return new ResultNumber(this.number);
    }

    @Override
    public String getHumanReadable() {
        return Integer.toString(this.number);
    }
}
