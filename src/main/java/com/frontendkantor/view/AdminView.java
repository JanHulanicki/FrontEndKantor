package com.frontendkantor.view;

import com.frontendkantor.domain.sandbox.Address;
import com.frontendkantor.domain.sandbox.Person;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Route;


import java.util.ArrayList;
import java.util.List;

@Route(value = "admin", layout = MainLayout.class)
public class AdminView extends Div {
    public AdminView() {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person(100, "Lucas", "Kane", 68,
                new Address("12080", "Washington"), "127-942-237"));
        personList.add(new Person(101, "Peter", "Buchanan", 38,
                new Address("93849", "New York"), "201-793-488"));
        personList.add(new Person(102, "Samuel", "Lee", 53,
                new Address("86829", "New York"), "043-713-538"));
        personList.add(new Person(103, "Anton", "Ross", 37,
                new Address("63521", "New York"), "150-813-6462"));
        personList.add(new Person(104, "Aaron", "Atkinson", 18,
                new Address("25415", "Washington"), "321-679-8544"));
        personList.add(new Person(105, "Jack", "Woodward", 28,
                new Address("95632", "New York"), "187-338-588"));

        Grid<Person> grid = new Grid<>(Person.class);
        grid.setItems(personList);

        grid.removeColumnByKey("id");

// The Grid<>(Person.class) sorts the properties and in order to
// reorder the properties we use the 'setColumns' method.
        grid.setColumns("firstName", "lastName", "age", "address",
                "phoneNumber");


        add(new Span("Admin view content"));
        add(grid);
    }
}
