package com.frontendkantor.view;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Route;

@Route(value = "dashboard", layout = MainLayout.class)
public class DashboardView extends Div {
    public DashboardView() {
        add(new Span("Dashboard view content"));
    }
}
