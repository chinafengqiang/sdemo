package com.feng.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by FQ.CHINA on 2017/10/19.
 */
public class Lambda2 {
    public static void main(String[] args) {
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API",
                "Date and Time API");
        features.forEach(n -> System.out.println(n));

        features.forEach(System.out::println);

    }
}
