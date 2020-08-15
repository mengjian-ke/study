package com.extra.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/6/20 20:42
 */
public class JsoupTest {

    public static String WEB_SITE_PREFIX = "https://www.diyibanzhu5.pro";

    @Test
    public void demo1() {
        try {
            String Url = "https://www.diyibanzhu5.pro/16/16255/336787.html";
            Document document = Jsoup
                    .connect(Url)
                    .timeout(10000)
                    .ignoreContentType(true)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36")
                    .get();

            Elements element = document.select("img[src^=\"/toimg/data/\"]");
            final List<String> imgsrcs = element.eachAttr("src");
            final List<String> collect = imgsrcs
                    .stream()
                    .map(src -> WEB_SITE_PREFIX + src)
                    .collect(Collectors.toList());
            collect.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
