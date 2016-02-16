package com.deepakm.util;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;


/**
 * Created by dmarathe on 2/15/16.
 */
public class CustomHibernateDaoSupport extends HibernateDaoSupport {

    @Autowired
    public void anyMethodName(SessionFactory sessionFactory){

        setSessionFactory(sessionFactory);
    }
}
