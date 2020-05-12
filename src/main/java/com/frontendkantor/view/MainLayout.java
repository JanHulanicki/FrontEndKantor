package com.frontendkantor.view;

import com.frontendkantor.view.sandbox.SandBoxViev;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;

import java.util.HashMap;
import java.util.Map;

import static com.frontendkantor.config.CoreConfig.APPLICATION_URL;

@Viewport("width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes, viewport-fit=cover")
@PWA(name = "My Application", shortName = "My App")
public class MainLayout extends AppLayout implements BeforeEnterObserver {

    private Button logoutButton;
    private Tabs tabs = new Tabs();
    private Map<Class<? extends Component>, Tab> navigationTargetToTab = new HashMap<>();

    public MainLayout() {
        addMenuTab("Main", DefaultView.class);
        addMenuTab("Admin", AdminView.class);
        addMenuTab("Dashboard", DashboardView.class);
        addMenuTab("SandBox", SandBoxViev.class);
        addMenuTab("All Stock", AllStockViev.class);
        addMenuTab("All NBP Currencies", AllNbpCurrencyView.class);
        addMenuTab("All Crypto Currencies", AllCryptoViev.class);

        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        addToDrawer(tabs);
        addToNavbar(new DrawerToggle());
        addToNavbar(new Button("Logout", click -> {

            UI.getCurrent().getPage().setLocation(APPLICATION_URL + "logout");
        }));

    }

    private void addMenuTab(String label, Class<? extends Component> target) {
        Tab tab = new Tab(new RouterLink(label, target));
        navigationTargetToTab.put(target, tab);
        tabs.add(tab);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        tabs.setSelectedTab(navigationTargetToTab.get(event.getNavigationTarget()));
    }
}

