package com.meli.ba.db.entities;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lpdmacedo on 11/7/16.
 */

@Data
@Component("notification")
@Scope("prototype")
@Entity
@Table(schema = "genius", name = "notification")
public class Notification {

    @Id
    @Column(name = "id") public int id;
    @Column(name = "_id") public String _id;
    @Column(name = "tags") public String tags;
    @Column(name = "message") public String message;
    @Column(name = "teams") public String teams;
    @Column(name = "source") public String source;
    @Column(name = "recipients") public String recipients;
    @Column(name = "alias") public String alias;
    @Column(name = "provider") public String provider;
    @Column(name = "alert_id") public String alert_id;
    @Column(name = "status_code") public String status_code;
}
