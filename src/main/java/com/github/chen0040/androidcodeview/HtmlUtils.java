package com.github.chen0040.androidcodeview;

/**
 * Created by chen0 on 23/8/2017.
 */

public class HtmlUtils {
    public static String encodeHtml(String content) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < content.length(); ++i) {
            sb.append(encode(content.charAt(i)));
        }
        return sb.toString();
    }

    private static String encode(char c) {
        /*
         & --> &amp;
         < --> &lt;
         > --> &gt;
         " --> &quot;
         ' --> &#x27;     &apos; not recommended because its not in the HTML spec (See: section 24.4.1) &apos; is in the XML and XHTML specs.
         / --> &#x2F;     forward slash is included as it helps end an HTML entity
         */
        if(c == '&') return "&amp;";
        else if(c == '<') return "&lt;";
        else if(c == '>') return "&gt;";
        else if(c == '"') return "&quot;";
        else if(c == '\'') return "&#x27;";
        else if(c == '/') return "&#x2F;";
        return "" + c;
    }
}
