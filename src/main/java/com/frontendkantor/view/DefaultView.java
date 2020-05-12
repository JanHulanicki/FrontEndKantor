package com.frontendkantor.view;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Route;

@Route(value = "default", layout = MainLayout.class)
public class DefaultView extends Div {
    public DefaultView() {
        add(new Span("Default view content"));
    }
}
