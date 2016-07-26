package com.meli.ba.db.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lpdmacedo on 13/7/16.
 */

@Data
@Entity
@Table(schema = "genius", name = "physical_host")
public class PhysicalHost {
    @Id
    @Column(name = "_id") public String _id;
    @Column(name = "type") public String type;
    @Column(name = "instance") public String instance;
    @Column(name = "pool") public String pool;
    @Column(name = "host") public String host;
    @Column(name = "state") public String state;
    @Column(name = "description") public String description;
    @Column(name = "from") public String from;
    @Column(name = "to") public String to;
    @Column(name = "ignored") public String ignored;
    @Column(name = "created_at") public String created_at;
}
