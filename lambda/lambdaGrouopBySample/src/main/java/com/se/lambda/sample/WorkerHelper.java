package com.se.lambda.sample;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WorkerHelper {
    public static Map<String, List<Worker>> groupingByPositions(List<Worker> workers)
    {
        Map<String, List<Worker>> map = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition));

        return map;
    }
}
