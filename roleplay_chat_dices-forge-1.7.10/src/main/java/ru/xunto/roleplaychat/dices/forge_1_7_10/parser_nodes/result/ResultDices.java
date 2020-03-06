package ru.xunto.roleplaychat.dices.forge_1_7_10.parser_nodes.result;

import ru.xunto.roleplaychat.dices.forge_1_7_10.parser_nodes.IResult;

import java.util.List;
import java.util.Optional;

public class ResultDices implements IResult {
    private List<ResultNumber> dices;

    public ResultDices(List<ResultNumber> dices) {
        this.dices = dices;
    }

    @Override
    public int getFinalResult() {
        Optional<Integer> reduce = this.dices.stream().map(ResultNumber::getFinalResult).reduce(Integer::sum);
        return reduce.get();
    }

    @Override
    public String getHumanReadable() {
        if (dices.size() > 10) return String.format("{%d}", this.getFinalResult());

        Optional<String> reduce = this.dices.stream().map(ResultNumber::getHumanReadable).reduce((a, b) -> a + "," + b);
        return "[" + reduce.get() + "]";
    }
}
