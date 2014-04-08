package br.com.prodigasistemas.gsan.relatorio;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.prodigasistemas.gsan.relatorio.ProdutoReportDTO;
import br.com.prodigasistemas.gsan.relatorio.ReportDTO;
import br.com.prodigasistemas.gsan.relatorio.ReportItemDTO;
import br.com.prodigasistemas.gsan.relatorio.ReportUtil;

import com.google.gson.Gson;

public class TestaGeracaoRelatorioComJson {

	@Test
	public void testaJsonUmItem() {
		String retorno = "{\"descricao\":\"agua ardente\",\"unidadeMedida\":\"2Kg\"}";
		ReportItemDTO item = new ProdutoReportDTO("agua ardente", "2Kg");
		Gson gson = new Gson();
		
		assertEquals(retorno, gson.toJson(item));
	}
	
	@Test
	public void testaHeader(){
		String header = "[{\"name\":\"descricao\",\"description\":\"Descrição\"},{\"name\":\"unidadeMedida\",\"description\":\"Unidade de Medida\"}]";
		
		ReportItemDTO item = new ProdutoReportDTO();
		
		Gson gson = new Gson();
		
		assertEquals(header, gson.toJson(ReportUtil.headerFields(item.getClass())));
	}
	
	@Test
	public void testaRelatorio(){
		StringBuilder builder = new StringBuilder();
		builder.append("{")
		.append("\"cabecalho\":")
		.append("[{\"name\":\"descricao\",\"description\":\"Descrição\"},{\"name\":\"unidadeMedida\",\"description\":\"Unidade de Medida\"}]")
		.append(",")
		.append("\"dados\":")
		.append("[")
		.append("{\"descricao\":\"agua ardente\",\"unidadeMedida\":\"2Kg\"}")
		.append("],")
		.append("\"formato\":\"XLS\"")
		.append("}");
		
		ReportDTO report = new ReportDTO(ProdutoReportDTO.class);
		
		ReportItemDTO i1 = new ProdutoReportDTO("agua ardente", "2Kg");
		List<ReportItemDTO> linhas = new ArrayList<ReportItemDTO>();
		linhas.add(i1);
		
		report.addLinhas(linhas);

		Gson gson = new Gson();
		
		System.out.println(gson.toJson(report));
		
		assertEquals(builder.toString(), gson.toJson(report));
	}
}
