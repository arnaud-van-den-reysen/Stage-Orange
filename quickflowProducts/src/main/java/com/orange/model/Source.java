package com.orange.model;

/**
 * @author Arnaud VAN DEN REYSEN
 */
public class Source {

    private String hostname;
    private String login;
    private String pwd;

    public String getHostname() {
        return hostname;
    }

    public String getLogin() {
        return login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Source() {

    }

    public Source(String hostname, String login, String pwd) {
        this.hostname = hostname;
        this.login = login;
        this.pwd = pwd;
    }

    @Override
	public String toString() {
		return "{" + hostname + ", " + login + ", " + pwd + "}";
	}
}