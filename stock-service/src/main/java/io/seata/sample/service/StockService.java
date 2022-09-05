package io.seata.sample.service;

import io.seata.sample.entity.Stock;
import io.seata.sample.repository.StockDAO;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.EntityManager;

/**
 * Description：
 *
 * @author fangliangsheng
 * @date 2019-04-04
 */
@Service
public class StockService {
    @Autowired
    private StockDAO stockDAO;

    @Transactional
    public void deduct(String commodityCode, int count) {
        stockDAO.deduct(commodityCode, count);
    }

}
