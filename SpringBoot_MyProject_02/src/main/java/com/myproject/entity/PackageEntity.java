package com.myproject.entity;

public class PackageEntity {

	private int number_of_pages, number_of_page_elements, price;
	
	private boolean  ssl, message_sending,  multi_language, site_search, blogging, animations, user_authentication, newsletter_service, pagination;
	
	private String database_type,title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumber_of_pages() {
		return number_of_pages;
	}

	public void setNumber_of_pages(int number_of_pages) {
		this.number_of_pages = number_of_pages;
	}

	public int getNumber_of_page_elements() {
		return number_of_page_elements;
	}

	public void setNumber_of_page_elements(int number_of_page_elements) {
		this.number_of_page_elements = number_of_page_elements;
	}

	public boolean isSsl() {
		return ssl;
	}

	public void setSsl(boolean ssl) {
		this.ssl = ssl;
	}

	public boolean isMessage_sending() {
		return message_sending;
	}

	public void setMessage_sending(boolean message_sending) {
		this.message_sending = message_sending;
	}

	public boolean isMulti_language() {
		return multi_language;
	}

	public void setMulti_language(boolean multi_language) {
		this.multi_language = multi_language;
	}

	public boolean isSite_search() {
		return site_search;
	}

	public void setSite_search(boolean site_search) {
		this.site_search = site_search;
	}

	public boolean isBlogging() {
		return blogging;
	}

	public void setBlogging(boolean blogging) {
		this.blogging = blogging;
	}

	public boolean isAnimations() {
		return animations;
	}

	public void setAnimations(boolean animations) {
		this.animations = animations;
	}

	public boolean isUser_authentication() {
		return user_authentication;
	}

	public void setUser_authentication(boolean user_authentication) {
		this.user_authentication = user_authentication;
	}

	public boolean isNewsletter_service() {
		return newsletter_service;
	}

	public void setNewsletter_service(boolean newsletter_service) {
		this.newsletter_service = newsletter_service;
	}

	public boolean isPagination() {
		return pagination;
	}

	public void setPagination(boolean pagination) {
		this.pagination = pagination;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDatabase_type() {
		return database_type;
	}

	public void setDatabase_type(String database_type) {
		this.database_type = database_type;
	}

	@Override
	public String toString() {
		return "PackageEntity [number_of_pages=" + number_of_pages + ", number_of_page_elements="
				+ number_of_page_elements + ", price=" + price + ", ssl=" + ssl + ", message_sending=" + message_sending
				+ ", multi_language=" + multi_language + ", site_search=" + site_search + ", blogging=" + blogging
				+ ", animations=" + animations + ", user_authentication=" + user_authentication
				+ ", newsletter_service=" + newsletter_service + ", pagination=" + pagination + ", database_type="
				+ database_type + ", title=" + title + "]";
	}
	
}
