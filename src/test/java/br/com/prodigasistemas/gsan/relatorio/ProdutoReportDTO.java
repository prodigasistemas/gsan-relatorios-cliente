package br.com.prodigasistemas.gsan.relatorio;


public class ProdutoReportDTO implements ReportItemDTO{
	private static final long serialVersionUID = -5224725130381064147L;

	
	@ReportElementType(description="Município", group=true)
	private String municipio;

	@ReportElementType(description="Localidade", group=true, header=true)
	private String localidade;

	@ReportElementType(description="Descri\u00E7\u00E3o", header=true)
	private String descricao;
	
	@ReportElementType(description="Unidade de Medida", header=true)
	private String unidadeMedida;
	
	public ProdutoReportDTO(){
	}
	
	public ProdutoReportDTO(String municipio, String localidade, String descricao, String unidadeMedida) {
		super();
		this.municipio = municipio;
		this.localidade = localidade;
		this.descricao = descricao;
		this.unidadeMedida = unidadeMedida;
	}

	public String getMunicipio() {
		return municipio;
	}
	
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
	public String getLocalidade() {
		return localidade;
	}
	
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public String toString() {
		return "ProdutoReport [descricao=" + descricao + ", unidadeMedida=" + unidadeMedida + "]";
	}
}
