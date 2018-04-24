package com.dev.auth;

import java.io.Serializable;

public class Url implements Serializable {

	private static final long serialVersionUID = 4179563824044675522L;
	public Url() {
	}

	public Url(String url) {
		super();
		this.url = url;
	}

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Url [url=" + url + "]";
	}

}
