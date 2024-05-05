package src;

import java.util.function.Consumer;

public class Option<T> {
    private T option;
    private String text;

    public Option(T option, String text) {
        this.option = option;
        this.text = text;
    }

    public T getOption() {
        return option;
    }

    public void setOption(T option) {
        this.option = option;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void ifPresent(Consumer<? super T> action) {
        if (option != null) {
            action.accept(option);
        }
    }
}
