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

public class TestaGeracaoJson {

	@Test
	public void testaJsonUmItem() {
		String retorno = "{\"descricao\":\"agua ardente\",\"unidadeMedida\":\"2Kg\"}";
		ReportItemDTO item = new ProdutoReportDTO(null, null, "agua ardente", "2Kg");
		Gson gson = new Gson();
		
		assertEquals(retorno, gson.toJson(item));
	}

	@Test
	public void testaGrupo(){
		String header = "[{\"name\":\"municipio\",\"description\":\"Município\"},{\"name\":\"localidade\",\"description\":\"Localidade\"}]";
		
		Gson gson = new Gson();
		
		assertEquals(header, gson.toJson(new ReportUtil().groupFieldsFromClass(ProdutoReportDTO.class)));
	}
	
	@Test
	public void testaGrupoTambemNoHeader(){
		StringBuilder builder = new StringBuilder();
		builder.append("{")
		.append("\"cabecalho\":")
		.append("[{\"name\":\"localidade\",\"description\":\"Localidade\"},{\"name\":\"descricao\",\"description\":\"Descrição\"},{\"name\":\"unidadeMedida\",\"description\":\"Unidade de Medida\"}]")
		.append(",")
		.append("\"dados\":")
		.append("[")
		.append("{\"descricao\":\"agua ardente\",\"unidadeMedida\":\"2Kg\"}")
		.append("],")
		.append("\"formato\":\"PDF\"")
		.append(",")
		.append("\"grupos\":[{\"name\":\"municipio\",\"description\":\"Município\"},{\"name\":\"localidade\",\"description\":\"Localidade\"}]")
		.append("}");
		
		System.out.println(builder.toString());
		
		ReportDTO report = new ReportDTO(ProdutoReportDTO.class);
		
		ReportItemDTO i1 = new ProdutoReportDTO(null, null, "agua ardente", "2Kg");
		List<ReportItemDTO> linhas = new ArrayList<ReportItemDTO>();
		linhas.add(i1);
		
		report.addLinhas(linhas);
		
		Gson gson = new Gson();
		
		System.out.println(gson.toJson(report));
		
		assertEquals(builder.toString(), gson.toJson(report));
	}
}
