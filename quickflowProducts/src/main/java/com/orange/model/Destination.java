package com.orange.model;

/**
 * @author Arnaud VAN DEN REYSEN
 */
public class Destination {
    private String hostname;
    private String login;
    private String pwd;

    public String getHostname() {
        return this.hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }    

    public Destination() {

    }

    public Destination(String hostname, String login, String pwd) {
        this.hostname = hostname;
        this.login = login;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "{" +
            " hostname='" + getHostname() + "'" +
            ", login='" + getLogin() + "'" +
            ", pwd='" + getPwd() + "'" +
            "}";
    }

}