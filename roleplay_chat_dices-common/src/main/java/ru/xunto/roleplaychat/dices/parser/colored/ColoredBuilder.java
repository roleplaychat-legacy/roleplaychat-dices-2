package ru.xunto.roleplaychat.dices.parser.colored;

import java.util.ArrayList;
import java.util.List;

public class ColoredBuilder {
    private static String DEFAULT = "default";

    private String marker = DEFAULT;
    private StringBuilder builder = new StringBuilder();

    private List<TextPart> parts = new ArrayList<>();

    public ColoredBuilder add(String content) {
        return this.add(content, DEFAULT);
    }

    private void finishPart() {
        this.parts.add(new TextPart(builder.toString(), this.marker));
        this.builder = new StringBuilder();
    }

    public ColoredBuilder add(String content, String marker) {
        if (!marker.equals(this.marker)) {
            this.finishPart();
            this.marker = marker;
        }

        builder.append(content);
        return this;
    }

    public List<TextPart> build() {
        this.finishPart();
        return parts;
    }
}
