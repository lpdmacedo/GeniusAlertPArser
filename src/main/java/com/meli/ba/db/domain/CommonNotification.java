package com.meli.ba.db.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by lpdmacedo on 10/7/16.
 */

@Data
public class CommonNotification {
    @JsonProperty("alias") public String alias;
    @JsonProperty("recipients") public String recipients;
    @JsonProperty("teams") public String teams;
    @JsonProperty("message") public String message;
    @JsonProperty("source") public String source;
    @JsonProperty("details") public Detail details;
    @JsonProperty("provider") public String provider;
    @JsonProperty("status_code") public String status_code;
    @JsonProperty("alert_id") public String alert_id;
}
