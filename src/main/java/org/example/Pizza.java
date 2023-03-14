package org.example;

import java.util.HashSet;
import java.util.Set;

public final class Pizza {


    private final Set<Component> pizza = new HashSet<>();

    public void add(Component component) {
        pizza.add(component);
    }

    public void delete(String name) {
        pizza.removeIf(component -> component.getName().equals(name));
    }

    public boolean contains(String name) {
        for (Component component : pizza) {
            if (component.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Set<Component> getPizza() {
        return pizza;
    }

    public String quantity(String name) {
        for (Component component : pizza) {
            if (component.getName().equals(name)) {
                return component.getAmount() + " " + component.getDimension();
            }
        }
        return "0";
    }

    public void deleteAll() {
        pizza.clear();
        ;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Component component : pizza) {
            s.append(component.toString()).append("\n");
        }
        return s.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Pizza) {
            Pizza other = (Pizza) obj;
            if (this.pizza.size() != other.pizza.size()) return false;
            boolean flag = true;
            for (Component component : other.pizza) {
                if (!this.pizza.contains(component)) {
                    flag = false;
                    break;
                }
            }
            return flag;
        } else return false;
    }
}
