package io.seata.sample.repository;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

/**
 * Description：
 *
 * @author fangliangsheng
 * @date 2019-04-04
 */
@Repository
public class StockDAO  {
    @PersistenceContext
    private EntityManager entityManager;

    public void deduct(String commodityCode, int count) {
        String sql = "UPDATE stock_tbl SET count=count-"+count+" WHERE commodity_code = '"+commodityCode +"'";
        entityManager.unwrap(Session.class).createSQLQuery(sql).executeUpdate();
        sql = "INSERT INTO p_p (id, p_a_id, p_code, p_type, p_value_type, p_value, p_version, c_time) VALUES ('"+ UUID.randomUUID().toString() +"','dbbcdf52-5b1c-407a-a50a-3d2fc5cb788f','applyCreateTime','00','string','2022-09-05 15:21:26',0,now())  ON DUPLICATE KEY UPDATE p_a_id=values(p_a_id),p_code=values(p_code),p_type=values(p_type),p_value_type=values(p_value_type),p_value=values(p_value),p_version=values(p_version),c_time=values(c_time);";
        System.out.println(sql);
        entityManager.unwrap(Session.class).createSQLQuery(sql).executeUpdate();
        System.out.println("OK");
    }
}
