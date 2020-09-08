
package com.codderMonkey.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

/**
 *
 * @author gajen
 */

//Note: Do not use @Repository, @Service, @Component here
abstract public class BaseDAO extends NamedParameterJdbcDaoSupport{
    
    @Autowired
    public void setDataSource2(DataSource ds) {
        super.setDataSource(ds);
        
    }
    
}
