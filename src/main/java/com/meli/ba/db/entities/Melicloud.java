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
@Entity
@Table(schema = "genius", name = "melicloud")
public class Melicloud {

    @Id
    @Column(name = "id") public int id;
    @Column(name = "_id") public String _id;
    @Column(name = "app") public String app;
    @Column(name = "ignored") public String ignored;
    @Column(name = "scope") public String scope;
    @Column(name = "datacenter") public String datacenter;
    @Column(name = "type") public String type;
    @Column(name = "alerted_instances") public String alerted_instances;
    @Column(name = "pool") public String pool;
    @Column(name = "gav") public String gav;
    @Column(name = "created_at") public String created_at;
    @Column(name = "serv") public String serv;
    @Column(name = "dept") public String dept;
    @Column(name = "instance_count") public String instance_count;
}
