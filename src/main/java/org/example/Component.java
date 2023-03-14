package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Component {
    private final String name;
    private final int amount;

    private final String dimension;

    Component(String name, int amount, String dimension) {
        this.name = name;
        this.amount = amount;
        this.dimension = dimension;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public String getDimension() {
        return dimension;
    }

    @Override
    public String toString() {
        return name + " " + amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Component) {
            Component other = (Component) obj;
            return this.name.equals(other.name)
                    && this.amount == other.amount
                    && this.dimension.equals(other.dimension);
        } else return false;
    }

    public Component toComponent(String s) {
        if (!s.matches("[а-я ]+ \\d+(.\\d+)? [а-я]+"))
            throw new IllegalArgumentException("String inconvertible to Component");
        String comp = s.split("\\d+")[0];
        String dim = s.split("\\d+")[1];
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(s);
        int amnt = Integer.parseInt(matcher.toString());
        return new Component(comp, amnt, dim);

    }
}
