package com.tide.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;

public class ViewLoader {
    private static URL decodeViewPath(String viewPath) {
        String viewSeparator = ".";
        String systemSeparator = System.getProperty("file.separator");
        String filePath = viewPath.replace(viewSeparator, systemSeparator);
        StringBuilder builder = new StringBuilder();
        ClassLoader loader = ViewLoader.class.getClassLoader();

        builder.append("com"); builder.append(systemSeparator);
        builder.append("tide"); builder.append(systemSeparator);
        builder.append("view"); builder.append(systemSeparator);
        builder.append(filePath); builder.append(".fxml");

        return loader.getResource(builder.toString());
    }

    public static Parent load(String viewPath) throws IOException {
        URL resource = decodeViewPath(viewPath);
        return FXMLLoader.load(resource);
    }
}
