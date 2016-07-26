package com.meli.ba.db.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by lpdmacedo on 7/7/16.
 */

@Data
public class Detail {
    @JsonProperty("events") public String event;
    @JsonProperty("related_links") public List<String> related_links;
}
