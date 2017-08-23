package com.github.chen0040.androidcodeview;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.webkit.WebView;

/**
 * Created by chen0 on 22/8/2017.
 */

public class SourceCodeView extends WebView {
    public SourceCodeView(Context context) {
        super(context);
    }

    public void setJavaCode(String content) {
        setCode(content, "java");
    }

    public void setCode(String content, String language) {
        this.clearCache(true);
        this.clearHistory();
        this.getSettings().setJavaScriptEnabled(true);
        this.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        StringBuilder sb = new StringBuilder();
        sb.append("<html><head>");
        sb.append("<link rel=\"stylesheet\" href=\"file:///android_asset/default.min.css\">");
        sb.append("<script src=\"file:///android_asset/highlight.min.js\"></script>");
        sb.append("<script>hljs.initHighlightingOnLoad();</script>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<pre><code class=\"").append(language).append("\">");
        sb.append(HtmlUtils.encodeHtml(content));
        sb.append("</code></pre>");
        sb.append("</body></html>");

        String html_string = sb.toString();

        this.loadDataWithBaseURL("file:///android_asset/", html_string, "text/html", "UTF-8", "");
    }

    public void enableDebugging(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (0 != (context.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE))
            { WebView.setWebContentsDebuggingEnabled(true); }
        }
    }
}
