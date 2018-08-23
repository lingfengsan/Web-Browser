package me.lingfengsan.webbrowser;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.apache.commons.lang.StringUtils;
import org.jdom.Element;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author: 元昱
 * @create: 2018-08-14 17:46
 **/
@State(
        name = "WebBrowserPluginSetting",
        storages = {@Storage(
                file = "$APP_CONFIG$/browserSetting.xml"
        )}
)
public class WebBrowserSetting implements ApplicationComponent, Configurable, PersistentStateComponent<Element> {
    private JTextField defaultPageUrlTextField;
    private JLabel defaultPageLabel;
    private JPanel mainPanel;
    private JPanel blankPanel;
    public static String indexPageUrl = "https://www.google.com/";


    @Nls
    @Override
    public String getDisplayName() {
        return "webbrowser";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        Element element = getState();
        if (element != null) {
            loadState(element);
        }
        defaultPageUrlTextField.setText(indexPageUrl);
        return mainPanel;
    }

    @Override
    public boolean isModified() {
        return !indexPageUrl.equals(defaultPageUrlTextField.getText());
    }

    @Override
    public void apply() throws ConfigurationException {
        indexPageUrl = defaultPageUrlTextField.getText();
    }

    /**
     * @return getState, loadState方法为持久化相关
     */
    @Nullable
    @Override
    public Element getState() {
        Element element = new Element("WebBrowserPluginSetting");
        element.setAttribute("indexPageUrl", indexPageUrl);
        return element;
    }

    @Override
    public void loadState(@NotNull Element element) {
        String url = element.getAttributeValue("indexPageUrl");
        indexPageUrl = StringUtils.isBlank(url) ? indexPageUrl : url;
    }
}
