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
@Table(schema = "genius", name = "detail")
public class Detail {

    @Id
    @Column(name = "id") public int id;
    @Column(name = "_id") public String _id;
    @Column(name = "events") public String events;
    @Column(name = "related_links") public String related_links;
}
