package br.com.prodigasistemas.gsan.relatorio;

public class AlteracaoImovelDTO implements ReportItemDTO{
	private static final long serialVersionUID = -5224725130381064147L;

	@ReportElementType(description="Imóvel")
	private String imovel;

	@ReportElementType(description="Altera\u00E7\u00E3o")
	private String alteracao;
	
	@ReportElementType(description="Valor Anterior")
	private String valorAnterior;
	
	@ReportElementType(description="Valor Atual")
	private String valorAtual;

	public String getImovel() {
		return imovel;
	}

	public void setImovel(String imovel) {
		this.imovel = imovel;
	}

	public String getAlteracao() {
		return alteracao;
	}

	public void setAlteracao(String alteracao) {
		this.alteracao = alteracao;
	}

	public String getValorAnterior() {
		return valorAnterior;
	}

	public void setValorAnterior(String valorAnterior) {
		this.valorAnterior = valorAnterior;
	}

	public String getValorAtual() {
		return valorAtual;
	}

	public void setValorAtual(String valorAtual) {
		this.valorAtual = valorAtual;
	}
}
