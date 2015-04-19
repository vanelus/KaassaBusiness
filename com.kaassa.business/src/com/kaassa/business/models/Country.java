package com.kaassa.business.models;

public class Country {
	
	String name_e_n;
	String name_f_r;
	String slug;
	
	 // setter
	public void setNameEn(String name_e_n) { this.name_e_n = name_e_n; }
	public void setNameFr(String name_f_r) { this.name_f_r = name_f_r; }
	public void setSlug(String slug) { this.slug = slug; }	

	
	// getters
	public String getNameEn() { return name_e_n; }
	public String getNameFr() { return name_f_r; }
	public String getSlug() { return slug; }

}
