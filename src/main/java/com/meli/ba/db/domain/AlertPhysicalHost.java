package com.meli.ba.db.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by lpdmacedo on 13/7/16.
 */
public class AlertPhysicalHost {
    @JsonProperty("_id") public String _id;
    @JsonProperty("type") public String type;
    @JsonProperty("instance") public String instance;
    @JsonProperty("pool") public String pool;
    @JsonProperty("host") public String host;
    @JsonProperty("state") public String state;
    @JsonProperty("description") public String description;
    @JsonProperty("from") public String from;
    @JsonProperty("to") public String to;
    @JsonProperty("ignored") public String ignored;
    @JsonProperty("notifications") public List<CommonNotification> notifications;
    @JsonProperty("created_at") public String created_at;
}
