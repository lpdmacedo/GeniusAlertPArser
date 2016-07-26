package com.meli.ba.db.domain;

import lombok.Data;

/**
 * Created by lpdmacedo on 7/7/16.
 */

@Data
public class Notification {
    public String status_code;
    public String tags;
    public String message;
    public String teams;
    public Detail details;
    public String source;
    public String recipients;
    public String alias;
    public String provider;
    public String alert_id;

}
