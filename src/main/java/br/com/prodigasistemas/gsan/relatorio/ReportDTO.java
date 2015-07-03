package br.com.prodigasistemas.gsan.relatorio;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class ReportDTO implements Serializable {

	private static final long serialVersionUID = 6953518374306894571L;

	private String name;

	private String titulo;

	private FormatoRelatorio formato = FormatoRelatorio.PDF;

	private List<ReportField> cabecalho;

	private List<ReportField> grupos = new LinkedList<ReportField>();

	private List<ReportField> totalizadores = new LinkedList<ReportField>();

	private List<ReportItemDTO> dados = new LinkedList<ReportItemDTO>();

	public ReportDTO(String titulo, String name, Class dataClass) {
		this.titulo = titulo;
		this.name = name;
		this.cabecalho = new ReportUtil().headerFieldsFromClass(dataClass);
		this.grupos = new ReportUtil().groupFieldsFromClass(dataClass);
		this.totalizadores = new ReportUtil().totalizerFieldsFromClass(dataClass);
	}

	public String getTitulo() {
		return titulo;
	}

	public String getName() {
		return name;
	}

	public List<ReportItemDTO> getDados() {
		return dados;
	}

	public void addLinhas(List<ReportItemDTO> linhas) {
		this.dados.addAll(linhas);
	}

	public FormatoRelatorio getFormato() {
		return formato;
	}

	public void setFormato(FormatoRelatorio formato) {
		this.formato = formato;
	}

	public List<ReportField> getCabecalho() {
		return cabecalho;
	}

	public void setCabecalho(List<ReportField> cabecalho) {
		this.cabecalho = cabecalho;
	}

	public List<ReportField> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<ReportField> grupos) {
		this.grupos = grupos;
	}

	public List<ReportField> getTotalizadores() {
		return totalizadores;
	}

	public void setTotalizadores(List<ReportField> totalizadores) {
		this.totalizadores = totalizadores;
	}
}
