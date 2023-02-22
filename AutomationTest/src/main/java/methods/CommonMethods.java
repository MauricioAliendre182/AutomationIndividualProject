package methods;

import ui.PageTransporter;
import ui.admin.components.TopBarMenu;
import utils.LoggerManager;

public class CommonMethods {
    private static final LoggerManager log = LoggerManager.getInstance();
    private static final PageTransporter pageTransporter = PageTransporter.getInstance();
    private static TopBarMenu topBarMenu;

    public static void logout() {
        if (!pageTransporter.isOnLoginPage()) {
            log.info("User logout");
            topBarMenu = new TopBarMenu();
            topBarMenu.logout();
        }
    }
}
