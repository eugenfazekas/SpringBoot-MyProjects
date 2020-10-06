package com.myproject.entity;

public class ServiceEntity {

	private String html_page;
	
	private String html_element;
	
	private String service_db;
	
	private String search;
	
	private String multilanguage;
	
	private String animation;
	
	private String auth;
	
	private String newsletter;
	
	private String height;
	
	

	public ServiceEntity(String html_page, String html_element, String service_db, String search, String multilanguage,
			String animation, String auth, String newsletter, String height) {
		this.html_page = html_page;
		this.html_element = html_element;
		this.service_db = service_db;
		this.search = search;
		this.multilanguage = multilanguage;
		this.animation = animation;
		this.auth = auth;
		this.newsletter = newsletter;
		this.height = height;
	}

	public String getHtml_page() {
		return html_page;
	}

	public void setHtml_page(String html_page) {
		this.html_page = html_page;
	}

	public String getHtml_element() {
		return html_element;
	}

	public void setHtml_element(String html_element) {
		this.html_element = html_element;
	}

	public String getService_db() {
		return service_db;
	}

	public void setService_db(String service_db) {
		this.service_db = service_db;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getMultilanguage() {
		return multilanguage;
	}

	public void setMultilanguage(String multilanguage) {
		this.multilanguage = multilanguage;
	}

	public String getAnimation() {
		return animation;
	}

	public void setAnimation(String animation) {
		this.animation = animation;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getNewsletter() {
		return newsletter;
	}

	public void setNewsletter(String newsletter) {
		this.newsletter = newsletter;
	}
	
	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "serviceEntity [html_page=" + html_page + ", html_element=" + html_element + ", service_db=" + service_db
				+ ", search=" + search + ", multilanguage=" + multilanguage + ", animation=" + animation + ", auth="
				+ auth + ", newsletter=" + newsletter + "]";
	}
 
}
