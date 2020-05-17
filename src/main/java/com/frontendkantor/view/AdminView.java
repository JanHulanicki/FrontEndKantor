package com.frontendkantor.view;

import com.frontendkantor.domain.user.UserDto;
import com.frontendkantor.service.UserService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;


@Route(value = "admin", layout = MainLayout.class)
public class AdminView extends Div {
    @Autowired
    UserService userService;
    private TextField textFieldName = new TextField("Name");
    private TextField textFieldSurname = new TextField("Surname");
    private TextField textFieldEmail = new TextField("Email");
    private TextField textFieldNick = new TextField("Nick");
    private TextField textPassword = new TextField("Password");
    private Label labelTitle = new Label("Create new user");

    private Button buttonSave = new Button("Save User");

    public AdminView() {
        removeAll();
        setWidth("50%");

        HorizontalLayout row1 = new HorizontalLayout();
        HorizontalLayout row2 = new HorizontalLayout();
        HorizontalLayout row3 = new HorizontalLayout();
        HorizontalLayout row4 = new HorizontalLayout();
        row1.setVerticalComponentAlignment(FlexComponent.Alignment.CENTER, row1);
        row2.setVerticalComponentAlignment(FlexComponent.Alignment.CENTER, row2);
        row3.setVerticalComponentAlignment(FlexComponent.Alignment.CENTER, row3);
        row4.setVerticalComponentAlignment(FlexComponent.Alignment.CENTER, row4);
        row1.add(labelTitle);
        row2.add(textFieldName, textFieldSurname, textFieldNick);
        row3.add(textFieldEmail, textPassword);
        row4.add(buttonSave);

        add(row1);
        add(row2);
        add(row3);
        add(row4);
        buttonSave.addClickListener(event -> saveUser());



       /* List<Person> personList = new ArrayList<>();

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


        grid.setColumns("firstName", "lastName", "age", "address",
                "phoneNumber");


        add(new Span("Admin view content"));
        add(grid);*/
    }

    private void saveUser() {
        LocalDateTime expiredDate = LocalDateTime.now().plusHours(2);

        userService.saveUser(new UserDto(
                textFieldNick.getValue(),
                textPassword.getValue(),
                textFieldEmail.getValue(),
                textFieldName.getValue(),
                textFieldSurname.getValue(),
                false,
                "initKey",
                expiredDate));

    }
}
