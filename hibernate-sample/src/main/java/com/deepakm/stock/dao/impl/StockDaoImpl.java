package com.deepakm.stock.dao.impl;

import com.deepakm.stock.dao.StockDAO;
import com.deepakm.stock.model.Stock;
import com.deepakm.util.CustomHibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dmarathe on 2/15/16.
 */
@Repository("stockDao")
public class StockDaoImpl extends CustomHibernateDaoSupport implements StockDAO {

    @Override
    public void save(Stock stock) {
        getHibernateTemplate().setCheckWriteOperations(false);
        getHibernateTemplate().save(stock);
    }

    @Override
    public void update(Stock stock) {
        getHibernateTemplate().setCheckWriteOperations(false);
        getHibernateTemplate().update(stock);
    }

    @Override
    public void delete(Stock stock) {
        getHibernateTemplate().setCheckWriteOperations(false);
        getHibernateTemplate().delete(stock);
    }

    @Override
    public Stock findStockByCode(String code) {
        getHibernateTemplate().setCheckWriteOperations(false);
        List<Stock> list = (List<Stock>) getHibernateTemplate().find("from Stock where stockCode=?", code);
        return list.get(0);
    }
}
