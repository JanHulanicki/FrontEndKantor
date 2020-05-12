package com.frontendkantor.view;

import com.frontendkantor.domain.nbp.NbpCurrencyDto;
import com.frontendkantor.service.NbpCurrencyService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

@Route(value = "allnbpcurrency", layout = MainLayout.class)
public class AllNbpCurrencyView extends Div {
    @Autowired
    NbpCurrencyService nbpCurrencyService;
    private NbpCurrencyDto nbpCurrencyDto;
    private Grid<NbpCurrencyDto> nbpCurrencyGrid = new Grid<>();
    private Button getAllNbpCurrency; //= new Button("Get All Stock");

    public AllNbpCurrencyView() {
        addNbpCurriencyGridColumns();
        add(nbpCurrencyGrid);
        refreshNbpCurrencyButton();
        add(getAllNbpCurrency);
    }

    private void addNbpCurriencyGridColumns() {
        nbpCurrencyGrid.addColumn(nbpCurrencyDto -> nbpCurrencyDto.get_id())
                .setHeader("ID")
                .setSortable(true)
                .setFlexGrow(0);
        nbpCurrencyGrid.addColumn(nbpCurrencyDto -> Arrays.stream(nbpCurrencyDto.getRates()).iterator().next().getEffectiveDate())
                .setHeader("DATE")
                .setSortable(true);
        nbpCurrencyGrid.addColumn(nbpCurrencyDto -> nbpCurrencyDto.getCode())
                .setHeader("CODE")
                .setSortable(true);
        nbpCurrencyGrid.addColumn(nbpCurrencyDto -> Arrays.stream(nbpCurrencyDto.getRates()).iterator().next().getMid())
                .setHeader("PRICE")
                .setSortable(true);

    }

    private void refreshNbpCurrencyGrid(Grid<NbpCurrencyDto> grid) {
        grid.setItems(nbpCurrencyService.getAllNbpCurrencies());
    }

    private void refreshNbpCurrencyButton() {
        getAllNbpCurrency = new Button("GET_ALL_NBP", click -> {

            refreshNbpCurrencyGrid(nbpCurrencyGrid);
        });
    }

}
