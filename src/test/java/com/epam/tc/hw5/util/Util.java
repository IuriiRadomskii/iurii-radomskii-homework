package com.epam.tc.hw5.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    public static List<String> collectRow(Integer index, List<String> col1, List<String> col2) {
        List<String> res = new ArrayList<>();
        res.add(index.toString());
        res.add(col1.get(index - 1));
        res.add(col2.get(index - 1));
        return res;
    }

    public static List<List<String>> removeTableHeaderFrom(List<List<String>> table) {
        return table.stream().skip(1).collect(Collectors.toList());
    }
}
