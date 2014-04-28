package br.com.prodigasistemas.gsan.relatorio;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class ReportDTO implements Serializable {
	
	private static final long serialVersionUID = 6953518374306894571L;

	private List<ReportField> cabecalho;
	
	private List<ReportItemDTO> dados = new LinkedList<ReportItemDTO>();
	
	private FormatoRelatorio formato = FormatoRelatorio.PDF;
	
	private List<ReportField> grupos = new LinkedList<ReportField>();
	
	public ReportDTO(Class c) {
		cabecalho = new ReportUtil().headerFieldsFromClass(c); 
		grupos    = new ReportUtil().groupFieldsFromClass(c); 
	}
	
	public List<ReportField> getCabecalho() {
		return cabecalho;
	}
	
	public void setCabecalho(List<ReportField> cabecalho) {
		this.cabecalho = cabecalho;
	}

	public List<ReportItemDTO> getDados() {
		return dados;
	}

	public void addLinhas(List<ReportItemDTO> linhas){
		this.dados.addAll(linhas);
	}

	public FormatoRelatorio getFormato() {
		return formato;
	}

	public void setFormato(FormatoRelatorio formato) {
		this.formato = formato;
	}

	public List<ReportField> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<ReportField> grupos) {
		this.grupos = grupos;
	}
}
