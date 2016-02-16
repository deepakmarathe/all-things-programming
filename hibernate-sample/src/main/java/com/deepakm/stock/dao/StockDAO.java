package com.deepakm.stock.dao;

import com.deepakm.stock.model.Stock;

/**
 * Created by dmarathe on 2/15/16.
 */
public interface StockDAO {
    void save(Stock stock);
    void update(Stock stock);
    void delete(Stock stock);
    Stock findStockByCode(String code);
}
