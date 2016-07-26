package com.meli.ba.dao;

import com.meli.ba.db.domain.AlertPhysicalHost;
import com.meli.ba.db.entities.*;
import com.meli.ba.db.utils.CustomHibernateDaoSupport;
import org.springframework.stereotype.Component;

/**
 * Created by lpdmacedo on 11/7/16.
 */

@Component("melicoudDAO")
public class AlertDAO extends CustomHibernateDaoSupport {

    public void saveMelicloud(Melicloud melicloud) {
        getHibernateTemplate().save(melicloud);
    }

    public void saveDataDog(DataDog dataDog) {
        getHibernateTemplate().save(dataDog);
    }

    public void saveNotification(Notification notification) {
        getHibernateTemplate().save(notification);
    }

    public void saveNewRelic(NewRelic newRelic) {

        getHibernateTemplate().save(newRelic);
    }

    public void saveDetails(Detail detail) {
        getHibernateTemplate().save(detail);
    }

    public void savePhysicalHost(PhysicalHost physicalHostObject) {
        getHibernateTemplate().save(physicalHostObject);
    }
}
