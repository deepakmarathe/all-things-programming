package com.deepakm.stock.model;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by dmarathe on 2/15/16.
 */

@Entity
@Table(name = "stock", catalog = "deepak_test", uniqueConstraints = {
        @UniqueConstraint(columnNames = "STOCK_NAME"),
        @UniqueConstraint(columnNames = "STOCK_CODE")
})
public class Stock implements Serializable {
    private Integer stockId;
    private String stockCode;
    private String stockName;


    public Stock() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STOCK_ID", unique = true, nullable = false)
    public Integer getStockId(){
        return this.stockId;
    }

    public void setStockId(Integer stockId){
        this.stockId = stockId;
    }

    @Column(name = "STOCK_CODE", unique = true, nullable = false, length = 10)
    public String getStockCode() {
        return stockCode;
    }


    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    @Column(name = "STOCK_NAME", nullable = false, unique = true, length = 20)
    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    @Override
    public String toString(){
        return "Stock [stockCode=" + stockCode + ", stockId=" + stockId + ", stockName=" + stockName + "]";
    }
}
