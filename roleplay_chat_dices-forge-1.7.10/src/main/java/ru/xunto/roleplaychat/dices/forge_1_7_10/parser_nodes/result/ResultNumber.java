package ru.xunto.roleplaychat.dices.forge_1_7_10.parser_nodes.result;

import ru.xunto.roleplaychat.dices.forge_1_7_10.parser_nodes.IResult;

public class ResultNumber implements IResult {
    private int result;

    public ResultNumber(int result) {
        this.result = result;
    }

    @Override
    public int getFinalResult() {
        return this.result;
    }

    @Override
    public String getHumanReadable() {
        return Integer.toString(this.result);
    }
}
