package com.frontendkantor.view;

import com.frontendkantor.domain.crypto.CryptoCurrencyDto;
import com.frontendkantor.service.CryptoService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "crypto", layout = MainView.class)
public class AllCryptoViev extends Div {
    @Autowired
    CryptoService cryptoService;
    private CryptoCurrencyDto cryptoCurrencyDto;
    private Grid<CryptoCurrencyDto> cryptoCurrencyGrid = new Grid<>();
    private Button getAllCryptoCurrency; //= new Button("Get All Stock");

    public AllCryptoViev() {
        addCryptoCurriencyGridColumns();
        add(cryptoCurrencyGrid);
        refreshCryptoCurrencyButton();
        add(getAllCryptoCurrency);
    }

    private void addCryptoCurriencyGridColumns() {
        cryptoCurrencyGrid.addColumn(cryptoCurrencyDto -> cryptoCurrencyDto.getRealtimeCurrencyExchangeRatedDto().get_id())
                .setHeader("ID")
                .setSortable(true)
                .setFlexGrow(0);
        cryptoCurrencyGrid.addColumn(cryptoCurrencyDto -> cryptoCurrencyDto.getRealtimeCurrencyExchangeRatedDto().getDate())
                .setHeader("DATE")
                .setSortable(true);
        cryptoCurrencyGrid.addColumn(cryptoCurrencyDto -> cryptoCurrencyDto.getRealtimeCurrencyExchangeRatedDto().getCode())
                .setHeader("CODE")
                .setSortable(true);
        cryptoCurrencyGrid.addColumn(cryptoCurrencyDto -> cryptoCurrencyDto.getRealtimeCurrencyExchangeRatedDto().getMid())
                .setHeader("PRICE")
                .setSortable(true);

    }

    private void refreshCryptoCurrencyGrid(Grid<CryptoCurrencyDto> grid) {
        grid.setItems(cryptoService.getAllCrypto());
    }

    private void refreshCryptoCurrencyButton() {
        getAllCryptoCurrency = new Button("GET ALL CRYPTO", click -> {

            refreshCryptoCurrencyGrid(cryptoCurrencyGrid);
        });
    }

}



