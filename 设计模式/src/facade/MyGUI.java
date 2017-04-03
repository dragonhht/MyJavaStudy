package facade;

/**
 * 使用门面层，简化接口
 * <p>
 * User : Dragon_hht
 * Date : 17-4-3
 * Time : 下午2:42
 */
public class MyGUI {
    private GUIContent guiContent;
    private GUIMenu guiMenu;
    private GUITitleBar guiTitleBar;

    public MyGUI() {
        guiContent = new GUIContent();
        guiMenu = new GUIMenu();
        guiTitleBar = new GUITitleBar();
    }

    public void drawGUI() {
        guiMenu.drawMenuButtons();
        guiTitleBar.showTitleBar();
        guiContent.showTextFields();
    }
}
