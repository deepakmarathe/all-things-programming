package com.deepakm.stock.bo;

import com.deepakm.stock.model.Stock;

/**
 * Created by dmarathe on 2/15/16.
 */
public interface StockBO {
    public void save(Stock stock);
    public void update(Stock stock);
    public void delete(Stock stock);
    public Stock findStockByCode(String code);
}
