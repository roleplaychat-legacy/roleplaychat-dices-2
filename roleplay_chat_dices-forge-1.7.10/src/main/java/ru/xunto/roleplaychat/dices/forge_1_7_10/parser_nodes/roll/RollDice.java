package ru.xunto.roleplaychat.dices.forge_1_7_10.parser_nodes.roll;

import ru.xunto.roleplaychat.dices.forge_1_7_10.parser_nodes.IResult;
import ru.xunto.roleplaychat.dices.forge_1_7_10.parser_nodes.IRoll;
import ru.xunto.roleplaychat.dices.forge_1_7_10.parser_nodes.result.ResultDices;
import ru.xunto.roleplaychat.dices.forge_1_7_10.parser_nodes.result.ResultNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RollDice implements IRoll {
    public static Random random = new Random();

    private int amount;
    private int sides;

    public RollDice(int amount, int sides) {
        this.amount = amount;
        this.sides = sides;
    }

    @Override
    public IResult roll() {
        List<ResultNumber> dices = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            dices.add(new ResultNumber(random.nextInt(this.sides) + 1));
        }

        return new ResultDices(dices);
    }

    @Override
    public String getHumanReadable() {
        StringBuilder builder = new StringBuilder();

        if (this.amount > 1) builder.append(this.amount);

        builder.append("d");
        builder.append(this.sides);

        return builder.toString();
    }
}
