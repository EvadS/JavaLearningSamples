package com.rest.samples.helpers;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class PathsHelper {

    private PathsHelper() {
    }

    public static Path getPath(String path) {
        return Paths.get(Objects.requireNonNull(PathsHelper.class.getClassLoader()
                .getResource(path)).getPath());
    }
}
