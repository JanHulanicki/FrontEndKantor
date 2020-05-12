package com.frontendkantor.view;

import com.frontendkantor.domain.stock.StockDto;
import com.frontendkantor.service.StockService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "allstock", layout = MainLayout.class)
public class AllStockViev extends Div {
    @Autowired
    StockService stockService;
    private StockDto stockDto;
    private Grid<StockDto> stockGrid = new Grid<>();
    private Button getAllstock; //= new Button("Get All Stock");

    public AllStockViev() {
        addStockGridColumns();
        add(stockGrid);
        refreshStockButton();
        add(getAllstock);
    }

    private void addStockGridColumns() {
        stockGrid.addColumn(stockDto -> stockDto.getGlobalQuoteDto().get_id())
                .setHeader("ID")
                .setSortable(true)
                .setFlexGrow(0);
        stockGrid.addColumn(stockDto -> stockDto.getGlobalQuoteDto().getLatestTradingDay())
                .setHeader("DATE")
                .setSortable(true);
        stockGrid.addColumn(stockDto -> stockDto.getGlobalQuoteDto().getSymbol())
                .setHeader("CODE")
                .setSortable(true);
        stockGrid.addColumn(stockDto -> stockDto.getGlobalQuoteDto().getPrice())
                .setHeader("PRICE")
                .setSortable(true);

    }

    private void refreshStockGrid(Grid<StockDto> grid) {
        grid.setItems(stockService.getAllStock());
    }

    private void refreshStockButton() {
        getAllstock = new Button("GET_ALL_STOCK", click -> {

            refreshStockGrid(stockGrid);
        });

    }

}
