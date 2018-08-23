package me.lingfengsan.webbrowser;

import com.intellij.openapi.ui.SimpleToolWindowPanel;

/**
 * @author: 元昱
 * @create: 2018-08-15 20:53
 **/
public class WebBrowserToolWindowPanel extends SimpleToolWindowPanel {
    public WebBrowserToolWindowPanel(boolean vertical, boolean borderless) {
        super(true,true);
        setContent(new WebBrowser().getWebPanel());
    }


}
