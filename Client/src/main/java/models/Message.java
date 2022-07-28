package models;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

/*
 * POJO for an Message object
 *
 *   {
    "sequence": "-",
    "timestamp": "_",
    "fromid": "xt0fer",
    "toid": "kristofer",
    "message": "Hello, Kristofer!"
  },
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "sequence",
        "timestamp",
        "fromid",
        "toid",
        "message"
})
public class Message {
    @JsonProperty("message")
    private String message = "";
    @JsonProperty("toid")
    private String toId = "";
    @JsonProperty("fromid")
    private String fromId = "";
    @JsonIgnore
    private String timestamp = "";
    @JsonProperty("sequence")
    private String seqId = "";
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @Override
    public String toString() {
        return "to: " + this.toId + "\nfrom: "+ this.fromId + "\n" + this.message + "\n----\n";
    }
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }
    @JsonProperty("toid")
    public String getToId() {
        return toId;
    }
    @JsonProperty("toid")
    public void setToId(String toId) {
        this.toId = toId;
    }
    @JsonProperty("fromid")
    public String getFromId() {
        return fromId;
    }
    @JsonProperty("fromid")
    public void setFromId(String fromId) {
        this.fromId = fromId;
    }
    @JsonIgnore
    public String getTimestamp() {
        return timestamp;
    }
    @JsonIgnore
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    @JsonProperty("sequence")
    public String getSeqId() {
        return seqId;
    }
    @JsonProperty("sequence")
    public void setSeqId(String seqId) {
        this.seqId = seqId;
    }
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}