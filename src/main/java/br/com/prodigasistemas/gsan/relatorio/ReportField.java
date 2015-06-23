package br.com.prodigasistemas.gsan.relatorio;

import java.io.Serializable;

public class ReportField implements Serializable {

	private static final long serialVersionUID = 4322745170791148124L;

	private String name;

	private String description;

	private String align;

	public ReportField(String name, String description, String align) {
		super();
		this.name = name;
		this.description = description;
		this.align = align;
	}
	
	public ReportField(String name, String description) {
		super();
		this.name = name;
		this.description = description;
		this.align = null;
	}
	
	public ReportField(String name) {
		super();
		this.name = name;
		this.description = null;
		this.align = null;
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

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}
}
