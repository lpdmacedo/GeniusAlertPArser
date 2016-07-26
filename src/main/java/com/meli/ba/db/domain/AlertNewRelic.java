package com.meli.ba.db.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by lpdmacedo on 7/7/16.
 */

@Data
public class AlertNewRelic {
    @JsonProperty("_id") public String _id;
    @JsonProperty("alert_policy_name") public String alert_policy_name;
    @JsonProperty("application_name") public String application_name;
    @JsonProperty("account_name") public String account_name;
    @JsonProperty("severity") public String severity;
    @JsonProperty("message") public String message;
    @JsonProperty("short_description") public String short_description;
    @JsonProperty("long_description") public String long_description;
    @JsonProperty("alert_url") public String alert_url;
    @JsonProperty("type") public String type;
    @JsonProperty("opened_at") public String opened_at;
    @JsonProperty("open_since") public String open_since;
    @JsonProperty("ignored") public String ignored;
    @JsonProperty("notifications") public List<CommonNotification> notifications;
    @JsonProperty("created_at") public String created_at;
}
