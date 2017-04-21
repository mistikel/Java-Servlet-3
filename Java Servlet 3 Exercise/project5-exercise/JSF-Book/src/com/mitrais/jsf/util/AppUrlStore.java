package com.mitrais.jsf.util;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@ApplicationScoped
public class AppUrlStore implements Serializable {
	private static final long serialVersionUID = 1L;

	private String baseUrl = null;
	private String simpleCrudUrl = null;

	public String getBaseUrl() {return baseUrl; }
	public String getSimpleCrudUrl() { return simpleCrudUrl; }

	@PostConstruct
    public void init() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		String baseUrl = externalContext.getInitParameter("BaseUrl");

		this.baseUrl = baseUrl;
		this.simpleCrudUrl = baseUrl + "index.xhtml";
    }
}
