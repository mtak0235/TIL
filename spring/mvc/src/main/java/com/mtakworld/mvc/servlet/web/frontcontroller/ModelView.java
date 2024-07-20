package com.mtakworld.mvc.servlet.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;

public class ModelView {
	private String viewname;
	private Map<String, Object> model = new HashMap<String, Object>();
	public ModelView(String viewname) {
		this.viewname = viewname;
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public String getViewname() {
		return viewname;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}

	public void setViewname(String viewname) {
		this.viewname = viewname;
	}
}
