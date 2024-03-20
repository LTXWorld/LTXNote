package com.ltx.summer.io;

import com.sun.org.apache.xpath.internal.operations.Variable;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import jdk.internal.loader.Resource;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName: ResourceResolver
 * Package:com.ltx.summer.io
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/19 20:42
 */
public class ResourceResolver {
    Logger logger = LoggerFactory.getLogger(getClass());
    String basePackage;

    public ResourceResolver(String basePackage) {
        this.basePackage = basePackage;
    }
    public <R>List<> scan(Function<Resource, R> mapper){
        String basePackagePath = this.basePackage.replace(".", "/");
        String path = basePackagePath;
        try {
            ArrayList<R> collector = new ArrayList<>();
            scan
        }
    }

    //
    <R> void scan0(String basePackagePath, String path, List<R> collector, Function<Resource, R> mapper)
        throws IOException, URISyntaxException{
        logger.atDebug().log("scan path: {}", path);
        Enumeration<URL> en = getContextClassLoader().getResources(path);
        while (en.hasMoreElements()){
            URL url = en.nextElement();
        }
    }
}
