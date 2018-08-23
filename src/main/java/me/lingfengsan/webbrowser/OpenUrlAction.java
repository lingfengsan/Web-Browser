package me.lingfengsan.webbrowser;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

/**
 * @author: 元昱
 * @create: 2018-08-15 21:23
 **/
public class OpenUrlAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        WebBrowser.openUrl((String)e.getInputEvent().getSource());
    }
}
