package ui.admin;

import ui.BasePageObject;
import ui.admin.components.TopBarMenu;

public abstract class BaseAdminPage extends BasePageObject {
    public TopBarMenu topBarMenu;

    public BaseAdminPage() {
        topBarMenu = new TopBarMenu();
    }
}
