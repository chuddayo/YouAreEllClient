package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

/*
 * POJO for an Id object
 *
 * {
    "userid": "fe2a019648f78cac751186a8d3860bfbde3a2b04",
    "name": "bobbert",
    "github": "kaiiscool"
  }
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "userid",
        "name",
        "github"
})
public class Id {
    @JsonProperty("userid")
    private String userid = "";
    @JsonProperty("name")
    private String name = "";
    @JsonProperty("github")
    private String github = "";
    public Id (String name, String githubId) {
        this.name = name;
        this.github = githubId;
    }
    @JsonProperty("userid")
    public String getUserid() {
        return userid;
    }
    @JsonProperty("userid")
    public void setUserid(String userid) {
        this.userid = userid;
    }
    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty("github")
    public String getGithub() {
        return github;
    }
    @JsonProperty("github")
    public void setGithub(String github) {
        this.github = github;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.github + ") ";
    }
}