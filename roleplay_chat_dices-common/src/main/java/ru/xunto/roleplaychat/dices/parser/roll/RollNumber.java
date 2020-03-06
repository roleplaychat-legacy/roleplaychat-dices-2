package ru.xunto.roleplaychat.dices.parser.roll;

import ru.xunto.roleplaychat.dices.parser.IResult;
import ru.xunto.roleplaychat.dices.parser.IRoll;
import ru.xunto.roleplaychat.dices.parser.result.ResultNumber;

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
