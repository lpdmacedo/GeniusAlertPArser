package com.meli.ba.db.domain;

import lombok.Data;

import java.util.List;

/**
 * Created by lpdmacedo on 7/7/16.
 */

@Data
public class AlertMeliCloud {
    public  String app;
    public  String ignored;
    public  String scope;
    public  String datacenter;
    public  String type;
    public  String alerted_instances;
    public  String _id;
    public  List<Notification> notifications;
    public  String pool;
    public  String gav;
    public  String created_at;
    public  String serv;
    public  String dept;
    public  String instance_count;
}
