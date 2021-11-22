package com.epam.tc.hw7.data;

import com.jdiai.tools.DataClass;
import java.util.ArrayList;
import java.util.List;

public class Info extends DataClass<Info> {

    private static final List<String> summaryData = List.of("4", "3");
    private static final List<String> elementsData = List.of("Water", "Fire");
    private static final String colorData = "Red";
    private static final String metalsData = "Gold";
    private static final List<String> vegetablesData = List.of("Cucumber", "Onion");
    public static final Info TEST_DATA = new Info(summaryData,
        elementsData, colorData, metalsData, vegetablesData);

    public static final String LOG_TEMPLATE = "Summary: sum(data[%s].summary)\n"
                                            + "Elements: data[%s].elements\n"
                                            + "Color: data[%s].color\n"
                                            + "Metal: data[%s].metal\n"
                                            + "Vegetables: data[%s].vegetables";

    public List<String> summary;
    public List<String> elements;
    public String color;
    public String metals;
    public List<String> vegetables;

    public Info() {
    }

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
