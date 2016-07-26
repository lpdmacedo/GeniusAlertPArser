package com.meli.ba.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.ba.dao.AlertDAO;
import com.meli.ba.db.domain.*;
import com.meli.ba.db.entities.*;
import com.meli.ba.db.entities.Detail;
import com.meli.ba.db.entities.Notification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by lpdmacedo on 7/7/16.
 */

@Component("alertMapper")
@Scope("singleton")
public class AlertMapper {

    private int count;
    private ObjectMapper mapper;
    private AlertMeliCloud[] alertMeliCloud;
    private AlertNewRelic[] alertNewRelic;
    private AlertDataDog[] alertDataDog;
    private Melicloud melicloud;
    private DataDog dataDog;
    private Notification notification;
    private NewRelic newRelic;
    private PhysicalHost physicalHost;
    private Detail detail;
    private com.meli.ba.db.domain.Detail detailDomain;
    private List<String> listAlertId;

    @Autowired private FileHelper fileHelper;
    @Autowired private AlertDAO alertDAO;

    private final static Logger LOGGER = Logger.getLogger(AlertMapper.class.getName());

    @PostConstruct
    void init() {
        count = 1;
        mapper = new ObjectMapper();
        alertMeliCloud = null;
        alertNewRelic = null;
        alertDataDog = null;
        listAlertId = new ArrayList<String>();
    }

    /**
     * String to JSONObject
     * @param jsonAlert
     * @return JSONObject
     */
    public JSONArray toJson(String jsonAlert) {
        return new JSONArray(jsonAlert);
    }

    /**
     * Parse Json Arrays
     * @param jsonPath
     * @return List Objects
     */
    public List<AlertMeliCloud> mapper(String jsonPath) {
        List<AlertMeliCloud> alerts = null;
        String data = fileHelper.readFile(jsonPath);
        try {
            alerts = mapper.readValue(data, mapper.getTypeFactory().constructCollectionType(List.class, AlertMeliCloud.class));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Cannot parse json file: " + jsonPath);
        }
        return alerts;
    }

    public void parser(String rootPath) {
        String data = "";
        JSONArray array;
        File[] files = fileHelper.scanDir(rootPath);

        for(File file : files) {
            if(file.getAbsolutePath().contains(".json")) {
                data = fileHelper.readFile(file.getAbsolutePath());
                array = toJson(data);
                loadObject(array);
            }
        }
    }

    private void loadObject(JSONArray alerts) {
        JSONObject json = null;

        for(int i=0; i < alerts.length(); i++) {
            toObject(new JSONArray().put(alerts.get(i)));
        }
    }

    private void toObject(JSONArray json) {
        switch (json.getJSONObject(0).get("type").toString()) {
            case "melicloud":
                saveMeliCloud(getMeliCloudObject(json));
                break;
            case "datadog":
                saveDataDog(getDataDogObject(json));
                break;
            case "newrelic":
                saveNewRelic(getNewRelicObject(json));
                break;
            case "physical_host":
                //savePhysicalHost(getPhysicalHost(json));
                break;
            default:
                LOGGER.log(Level.WARNING, "Type of object not found");
        }
        ++count;
    }

    private void savePhysicalHost(AlertPhysicalHost obj) {
        if(!listAlertId.contains(obj.notifications.get(0).alert_id)) {
            alertDAO.savePhysicalHost(getPhysicalHostObject(obj));
            savePhysicalHostNotifications(obj);
            saveCommonDetails(obj.notifications, obj._id);
            listAlertId.add(obj.notifications.get(0).alert_id);
        }else {
            LOGGER.log(Level.INFO, "[Repeat Physical Host] " + obj.notifications.get(0).alert_id);
        }
    }

    private void savePhysicalHostNotifications(AlertPhysicalHost obj) {
        for(int i=0; i < obj.notifications.size(); i++) {
            notification = new Notification();
            notification._id = obj._id;
            notification.status_code = obj.notifications.get(i).status_code;
            notification.tags = "";
            notification.message = obj.notifications.get(i).message;
            notification.teams = obj.notifications.get(i).teams;
            notification.source = obj.notifications.get(i).source;
            notification.recipients = obj.notifications.get(i).recipients;
            notification.alias = obj.notifications.get(i).alias;
            notification.provider = obj.notifications.get(i).provider;
            notification.alert_id = obj.notifications.get(i).alert_id;
            alertDAO.saveNotification(notification);
        }
    }

    private PhysicalHost getPhysicalHostObject(AlertPhysicalHost obj) {
        physicalHost = new PhysicalHost();
        physicalHost._id = obj._id;
        physicalHost.type = obj.type;
        physicalHost.instance = obj.instance;
        physicalHost.pool = obj.pool;
        physicalHost.host = obj.host;
        physicalHost.state = obj.state;
        physicalHost.description = obj.description;
        physicalHost.from = obj.from;
        physicalHost.to = obj.to;
        physicalHost.ignored = obj.ignored;
        physicalHost.created_at = obj.created_at;
        return physicalHost;
    }

    private AlertPhysicalHost getPhysicalHost(JSONArray json) {
        try {
            return mapper.readValue(json.toString(), AlertPhysicalHost[].class)[0];
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error trying to convert object physical host");
            return null;
        }
    }

    private void saveNewRelic(AlertNewRelic obj) {
       if(!listAlertId.contains(obj.notifications.get(0).alert_id)) {
            alertDAO.saveNewRelic(getNewRelic(obj));
            saveNewRelicNotifications(obj);
            saveCommonDetails(obj.notifications, obj._id);
            listAlertId.add(obj.notifications.get(0).alert_id);
       }else {
           LOGGER.log(Level.INFO, "[Repeat New Relic] " + obj.notifications.get(0).alert_id);
       }
    }

    private void saveNewRelicNotifications(AlertNewRelic obj) {
        for(int i=0; i < obj.notifications.size(); i++) {
            notification = new Notification();
            notification._id = obj._id;
            notification.status_code = obj.notifications.get(i).status_code;
            notification.tags = "";
            notification.message = obj.notifications.get(i).message;
            notification.teams = obj.notifications.get(i).teams;
            notification.source = obj.notifications.get(i).source;
            notification.recipients = obj.notifications.get(i).recipients;
            notification.alias = obj.notifications.get(i).alias;
            notification.provider = obj.notifications.get(i).provider;
            notification.alert_id = obj.notifications.get(i).alert_id;
            alertDAO.saveNotification(notification);
        }
    }

    private NewRelic getNewRelic(AlertNewRelic obj) {
        newRelic = new NewRelic();
        newRelic._id = obj._id;
        newRelic.alert_policy_name = obj.alert_policy_name;
        newRelic.application_name = obj.application_name;
        newRelic.account_name = obj.account_name;
        newRelic.severity = obj.severity;
        newRelic.message = obj.message;
        newRelic.short_description = obj.short_description;
        newRelic.long_description = obj.long_description;
        newRelic.alert_url = obj.alert_url;
        newRelic.type = obj.type;
        newRelic.opened_at = obj.opened_at;
        newRelic.open_since = obj.open_since;
        newRelic.ignored = obj.ignored;
        newRelic.created_at = obj.created_at;
        return newRelic;
    }

    private AlertNewRelic getNewRelicObject(JSONArray json) {
        try {
            return mapper.readValue(json.toString(), AlertNewRelic[].class)[0];
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error trying to convert object new relic");
            return null;
        }
    }

    private void saveDataDog(AlertDataDog obj) {
        if(!listAlertId.contains(obj.notifications.get(0).alert_id)) {
            alertDAO.saveDataDog(getDataDog(obj));
            saveDataDogNotification(obj);
            saveCommonDetails(obj.notifications, obj._id);
        }else {
            LOGGER.log(Level.INFO, "[Repeat DataDog] " + obj.notifications.get(0).alert_id);
        }
    }

    private DataDog getDataDog(AlertDataDog obj) {
        dataDog = new DataDog();
        dataDog._id = obj._id;
        dataDog.body = obj.body;
        dataDog.last_updated = obj.last_updated;
        dataDog.event_type = obj.event_type;
        dataDog.title = obj.title.split("]")[1].trim();
        dataDog.id = obj.id;
        dataDog.type = obj.type;
        dataDog.url = obj.url;
        dataDog.ignored = obj.ignored;
        dataDog.created_at = obj.created_at;
        return dataDog;
    }

    private void saveDataDogNotification(AlertDataDog obj) {
        for(int i=0; i < obj.notifications.size(); i++) {
            notification = new Notification();
            notification._id = obj._id;
            notification.status_code = obj.notifications.get(i).status_code;
            notification.tags = "";
            notification.message = obj.notifications.get(i).message;
            notification.teams = obj.notifications.get(i).teams;
            notification.source = obj.notifications.get(i).source;
            notification.recipients = obj.notifications.get(i).recipients;
            notification.alias = obj.notifications.get(i).alias.split("]")[1].trim();
            notification.provider = obj.notifications.get(i).provider;
            notification.alert_id = obj.notifications.get(i).alert_id;
            alertDAO.saveNotification(notification);
        }
    }

    private void saveMeliCloud(AlertMeliCloud obj) {
        if(!listAlertId.contains(obj.notifications.get(0).alert_id)) {
            alertDAO.saveMelicloud(getMelicloud(obj));
            saveMeliClouNotifications(obj);
            saveDetails(obj.notifications, obj._id);
            listAlertId.add(obj.notifications.get(0).alert_id);
        }else {
            LOGGER.log(Level.INFO, "[Repeat Melicloud] " + obj.notifications.get(0).alert_id);
        }
    }

    private void saveMeliClouNotifications(AlertMeliCloud obj) {
        for(int i=0; i < obj.notifications.size(); i++) {
            notification = new Notification();
            notification._id = obj._id;
            notification.status_code = obj.notifications.get(i).status_code;
            notification.tags = obj.notifications.get(i).tags;
            notification.message = obj.notifications.get(i).message;
            notification.teams = obj.notifications.get(i).teams;
            notification.source = obj.notifications.get(i).source;
            notification.recipients = obj.notifications.get(i).recipients;
            notification.alias = obj.notifications.get(i).alias;
            notification.provider = obj.notifications.get(i).provider;
            notification.alert_id = obj.notifications.get(i).alert_id;
            alertDAO.saveNotification(notification);
        }
    }

    private void saveDetails(List<com.meli.ba.db.domain.Notification> notifications, String _id) {
        detail = new Detail();
        detailDomain = new com.meli.ba.db.domain.Detail();

        for(int i=0; i < notifications.size(); i++) {
            detailDomain = notifications.get(i).details;
            detail._id = _id;
            detail.events = notifications.get(i).details.event;
            detail.related_links = notifications.get(i).details.related_links.toString();
            alertDAO.saveDetails(detail);
        }
    }

    private Melicloud getMelicloud(AlertMeliCloud obj) {
        melicloud = new Melicloud();
        melicloud._id = obj._id;
        melicloud.app = obj.app;
        melicloud.ignored = obj.ignored;
        melicloud.scope = obj.scope;
        melicloud.datacenter = obj.datacenter;
        melicloud.type = obj.type;
        melicloud.alerted_instances = obj.alerted_instances;
        melicloud.pool = obj.pool;
        melicloud.gav = obj.gav;
        melicloud.created_at = obj.created_at;
        melicloud.serv = obj.serv;
        melicloud.dept = obj.dept;
        melicloud.instance_count = obj.instance_count;
        return melicloud;
    }

    private AlertMeliCloud getMeliCloudObject(JSONArray json) {
        try {
            return mapper.readValue(json.toString(), AlertMeliCloud[].class)[0];
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error trying to convert object melicloud");
            return null;
        }
    }

    private AlertDataDog getDataDogObject(JSONArray json) {
        try {
            return mapper.readValue(json.toString(), AlertDataDog[].class)[0];
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error trying to convert object datadog");
            return null;
        }
    }

    private void saveCommonDetails(List<CommonNotification> notifications, String _id) {
        detail = new Detail();
        detailDomain = new com.meli.ba.db.domain.Detail();

        for(int i=0; i < notifications.size(); i++) {
            detailDomain = notifications.get(i).details;
            detail._id = _id;
            detail.events = notifications.get(i).details.event;
            detail.related_links = notifications.get(i).details.related_links.toString();
            alertDAO.saveDetails(detail);
        }
    }
}
