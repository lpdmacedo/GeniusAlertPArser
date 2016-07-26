package com.meli.ba.db.entities;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lpdmacedo on 11/7/16.
 */

@Data
@Entity
@Table(schema = "genius", name = "datadog")
public class DataDog {

    @Id
    @Column(name = "idDataDog") public int idDataDog;
    @Column(name = "_id") public String _id;
    @Column(name = "body") public String body;
    @Column(name = "last_updated") public String last_updated;
    @Column(name = "event_type") public String event_type;
    @Column(name = "title") public String title;
    @Column(name = "id") public String id;
    @Column(name = "type") public String type;
    @Column(name = "url") public String url;
    @Column(name = "ignored") public String ignored;
    @Column(name = "created_at") public String created_at;
}
