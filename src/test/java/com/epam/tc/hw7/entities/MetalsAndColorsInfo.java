package com.epam.tc.hw7.entities;

import com.jdiai.tools.DataClass;

public class MetalsAndColorsInfo extends DataClass<MetalsAndColorsInfo> {

    int[] summary;
    String[] elements;
    String colors;
    String metals;
    String[] vegetables;

    public MetalsAndColorsInfo(int[] summary, String[] elements, String colors, String metals, String[] vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.colors = colors;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public int[] getSummary() {
        return summary;
    }

    public void setSummary(int[] summary) {
        this.summary = summary;
    }

    public String[] getElements() {
        return elements;
    }

    public void setElements(String[] elements) {
        this.elements = elements;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getMetals() {
        return metals;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public String[] getVegetables() {
        return vegetables;
    }

    public void setVegetables(String[] vegetables) {
        this.vegetables = vegetables;
    }

}
