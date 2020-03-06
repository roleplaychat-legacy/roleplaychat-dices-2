package ru.xunto.roleplaychat.dices.parser.colored;

public class TextPart {
    private final String content;
    private final String marker;

    public TextPart(String content, String marker) {
        this.content = content;
        this.marker = marker;
    }

    public String getContent() {
        return content;
    }

    public String getMarker() {
        return marker;
    }

    @Override
    public String toString() {
        return "TextPart{" +
                "content='" + content + '\'' +
                ", marker='" + marker + '\'' +
                '}';
    }
}
