package com.epam.tc.hw7.data;

import com.jdiai.tools.DataClass;
import java.util.ArrayList;
import java.util.List;

public class Info extends DataClass<Info> {

    private List<String> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public Info(List<String> summary, List<String> elements, String colors,
                String metals, List<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = colors;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public List<String> getExpectedLogs() {
        List<String> logs = new ArrayList<>();
        logs.add(String.format("Summary: %d",
            Integer.parseInt(summary.get(0)) + Integer.parseInt(summary.get(1))));
        logs.add(String.format("Elements: %s", String.join(", ", elements)));
        logs.add(String.format("Color: %s", color));
        logs.add(String.format("Metal: %s", metals));
        logs.add(String.format("Vegetables: %s", String.join(", ", vegetables)));
        return logs;
    }

    public List<String> getSummary() {
        return summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetals() {
        return metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    @Override
    public String toString() {
        return "Info{"
            + "summary=" + summary
            + ", elements=" + elements
            + ", color='" + color + '\''
            + ", metals='" + metals + '\''
            + ", vegetables=" + vegetables + '}';
    }
}
