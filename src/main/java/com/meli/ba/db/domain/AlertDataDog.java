package com.meli.ba.db.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.LinkedList;

/**
 * Created by lpdmacedo on 7/7/16.
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlertDataDog {

    @JsonProperty("_id") public  String _id;
    @JsonProperty("body") public  String body;
    @JsonProperty("last_updated") public  String last_updated;
    @JsonProperty("event_type") public  String event_type;
    @JsonProperty("title") public  String title;
    @JsonProperty("id") public  String id;
    @JsonProperty("type") public  String type;
    @JsonProperty("url") public  String url;
    @JsonProperty("ignored") public  String ignored;
    @JsonProperty("notifications") public  LinkedList<CommonNotification> notifications;
    @JsonProperty("created_at") public  String created_at;
    @JsonProperty("opened_at") public  String opened_at;
    @JsonProperty("open_since") public  String open_since;

}
