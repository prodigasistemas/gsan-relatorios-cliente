package br.com.prodigasistemas.gsan.relatorio;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.prodigasistemas.gsan.relatorio.TesteReportDTO;
import br.com.prodigasistemas.gsan.relatorio.ReportDTO;
import br.com.prodigasistemas.gsan.relatorio.ReportItemDTO;
import br.com.prodigasistemas.gsan.relatorio.ReportUtil;

import com.google.gson.Gson;

public class TestaGeracaoJson {

	@Test
	public void testaJsonUmItem() throws UnsupportedEncodingException {
		String retorno = new String("{\"descricao\":\"agua ardente\",\"unidadeMedida\":\"2Kg\"}".getBytes(), "UTF-8");
		ReportItemDTO item = new TesteReportDTO(null, null, "agua ardente", "2Kg");
		Gson gson = new Gson();
		
		assertEquals(retorno, gson.toJson(item));
	}

	@Test
	public void testaGrupo() throws UnsupportedEncodingException{
		String header = new String("[{\"name\":\"municipio\",\"description\":\"Município\"},{\"name\":\"localidade\",\"description\":\"Localidade\"}]".getBytes(), "UTF-8");
		
		Gson gson = new Gson();
		
		assertEquals(header, new String(gson.toJson(new ReportUtil().groupFieldsFromClass(TesteReportDTO.class)).getBytes(), "UTF-8"));
	}
	
	@Test
	public void testaGrupoTambemNoHeader() throws UnsupportedEncodingException{
		StringBuilder builder = new StringBuilder();
		builder.append("{")
		.append("\"titulo\":\"\"")
		.append(",")
		.append("\"cabecalho\":")
		.append("[{\"name\":\"municipio\",\"description\":\"Município\"},{\"name\":\"localidade\",\"description\":\"Localidade\"},{\"name\":\"descricao\",\"description\":\"Descrição\"},{\"name\":\"unidadeMedida\",\"description\":\"Unidade de Medida\"}]")
		.append(",")
		.append("\"dados\":")
		.append("[")
		.append("{\"descricao\":\"agua ardente\",\"unidadeMedida\":\"2Kg\"}")
		.append("],")
		.append("\"formato\":\"PDF\"")
		.append(",")
		.append("\"grupos\":[{\"name\":\"municipio\",\"description\":\"Município\"},{\"name\":\"localidade\",\"description\":\"Localidade\"}]")
		.append("}");
		
		ReportDTO report = new ReportDTO("", TesteReportDTO.class);
		
		ReportItemDTO i1 = new TesteReportDTO(null, null, "agua ardente", "2Kg");
		List<ReportItemDTO> linhas = new ArrayList<ReportItemDTO>();
		linhas.add(i1);
		
		report.addLinhas(linhas);
		
		Gson gson = new Gson();
		
		System.out.println(gson.toJson(report));
		
		assertEquals(new String(builder.toString().getBytes(), "UTF-8"), new String(gson.toJson(report).getBytes(), "UTF-8"));
	}
}
