package com.deepakm.common;

import com.deepakm.stock.bo.StockBO;
import com.deepakm.stock.model.Stock;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dmarathe on 2/15/16.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/config/BeanLocations.xml");
        StockBO stockBO = (StockBO) applicationContext.getBean("stockBo");


        Stock stock1 = stockBO.findStockByCode("1234");
        System.out.println(stock1);

        stock1.setStockName("MARA");
        stockBO.update(stock1);

        Stock stock2 = stockBO.findStockByCode("1234");
        System.out.println(stock2);

//        stockBO.delete(stock2);
        System.out.println("Done");

//        Stock stock = new Stock();
//        stock.setStockCode("1234");
//        stock.setStockName("DEEP");
//        stockBO.save(stock);

    }
}
