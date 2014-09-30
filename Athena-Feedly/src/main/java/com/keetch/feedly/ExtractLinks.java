package com.keetch.feedly;

import com.keetch.feedly.model.Link;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by keetchc on 30/09/2014.
 */
public class ExtractLinks {

    private static String SLIDESHARE = "slideshare";
    private static String YOUTUBE = "youtube";

    public static List<Link> process(String html, String parentUrl) throws IOException {
        List<Link> linksList = new ArrayList<Link>();
        Document doc = Jsoup.parse(html);
        Elements links = doc.select("a[href]");

        // href ...
        for (Element link : links) {
            if (link.attr("abs:href").indexOf(SLIDESHARE) != -1 ||
                    link.attr("abs:href").indexOf(YOUTUBE) != -1) {
                Link l = new Link();
                l.setName(link.text());
                l.setUrl(link.attr("abs:href"));
                l.setParentArticleUrl(parentUrl);
                linksList.add(l);
                // System.out.println(link.attr("abs:href") + ":" + link.text());

            }

        }


        return linksList;

    }


}
