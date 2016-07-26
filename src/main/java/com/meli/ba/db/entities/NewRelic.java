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
@Table(schema = "genius", name = "newrelic")
public class NewRelic {
    @Id
    @Column(name = "_id") public String _id;
    @Column(name = "alert_policy_name") public String alert_policy_name;
    @Column(name = "application_name") public String application_name;
    @Column(name = "account_name") public String account_name;
    @Column(name = "severity") public String severity;
    @Column(name = "message") public String message;
    @Column(name = "short_description") public String short_description;
    @Column(name = "long_description") public String long_description;
    @Column(name = "alert_url") public String alert_url;
    @Column(name = "type") public String type;
    @Column(name = "opened_at") public String opened_at;
    @Column(name = "open_since") public String open_since;
    @Column(name = "ignored") public String ignored;
    @Column(name = "created_at") public String created_at;
}
