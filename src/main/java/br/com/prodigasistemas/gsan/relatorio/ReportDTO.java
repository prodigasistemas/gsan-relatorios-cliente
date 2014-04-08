package br.com.prodigasistemas.gsan.relatorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReportDTO implements Serializable {
	
	private static final long serialVersionUID = 6953518374306894571L;

	private List<ReportHeader> cabecalho;
	
	private List<ReportItemDTO> dados = new ArrayList<ReportItemDTO>();
	
	private FormatoRelatorio formato = FormatoRelatorio.XLS;
	
	public ReportDTO(Class item) {
		cabecalho = ReportUtil.headerFields(item); 
	}

	public List<ReportHeader> getCabecalho() {
		return cabecalho;
	}
	
	public void setCabecalho(List<ReportHeader> cabecalho) {
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
}
