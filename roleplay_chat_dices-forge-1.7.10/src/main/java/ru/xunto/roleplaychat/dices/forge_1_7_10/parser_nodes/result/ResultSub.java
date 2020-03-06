package ru.xunto.roleplaychat.dices.forge_1_7_10.parser_nodes.result;

import ru.xunto.roleplaychat.dices.forge_1_7_10.parser_nodes.IResult;

public class ResultSub implements IResult {
    private final IResult result1;
    private final IResult result2;

    public ResultSub(IResult result1, IResult result2) {
        this.result1 = result1;
        this.result2 = result2;
    }

    @Override
    public int getFinalResult() {
        return this.result1.getFinalResult() - this.result2.getFinalResult();
    }

    @Override
    public String getHumanReadable() {
        return String.format("%s-%s", this.result1.getHumanReadable(), this.result2.getHumanReadable());
    }
}
