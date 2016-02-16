package com.deepakm.stock.bo.impl;

import com.deepakm.stock.bo.StockBO;
import com.deepakm.stock.dao.StockDAO;
import com.deepakm.stock.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dmarathe on 2/15/16.
 */
@Service("stockBo")
public class StockBoImpl implements StockBO {

    @Autowired
    StockDAO stockDAO;


    public StockDAO getStockDAO() {
        return stockDAO;
    }

    public void setStockDAO(StockDAO stockDAO) {
        this.stockDAO = stockDAO;
    }

    @Override
    @Transactional
    public void save( Stock stock) {
        stockDAO.save(stock);
    }

    @Transactional
    @Override
    public void update(  Stock stock) {
        stockDAO.update(stock);
    }

    @Override
    public void delete(Stock stock) {
        stockDAO.delete(stock);
    }

    @Override
    public Stock findStockByCode(String code) {
        return stockDAO.findStockByCode(code);
    }
}
