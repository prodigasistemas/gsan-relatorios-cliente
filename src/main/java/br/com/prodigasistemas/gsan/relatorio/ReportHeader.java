package br.com.prodigasistemas.gsan.relatorio;

import java.io.Serializable;

public class ReportHeader implements Serializable{
	private static final long serialVersionUID = -2430178319754351498L;

	private String name;
	
	private String description;

	public ReportHeader(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
