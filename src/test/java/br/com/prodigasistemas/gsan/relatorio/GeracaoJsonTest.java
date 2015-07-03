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

public class GeracaoJsonTest {

	@Test
	public void testaJsonUmItem() throws UnsupportedEncodingException {
		String retorno = new String("{\"descricao\":\"agua ardente\",\"unidadeMedida\":\"2Kg\"}".getBytes(), "UTF-8");
		ReportItemDTO item = new TesteReportDTO(null, null, "agua ardente", "2Kg");
		Gson gson = new Gson();
		
		assertEquals(retorno, gson.toJson(item));
	}

	@Test
	public void testaGrupo() throws UnsupportedEncodingException{
		StringBuilder builder = new StringBuilder();
		builder.append("[")
		.append("{\"name\":\"municipio\",\"description\":\"Município\"}")
		.append(",{\"name\":\"localidade\",\"description\":\"Localidade\"}")
		.append("]");
		String header = new String(builder.toString().getBytes(), "UTF-8");
		
		Gson gson = new Gson();
		
		assertEquals(header, new String(gson.toJson(new ReportUtil().groupFieldsFromClass(TesteReportDTO.class)).getBytes(), "UTF-8"));
	}
	
	@Test
	public void testaApenasHeader() throws UnsupportedEncodingException{
		StringBuilder builder = new StringBuilder();
		builder.append("[")
		.append("{\"name\":\"municipio\",\"description\":\"Município\",\"align\":\"left\"}")
		.append(",{\"name\":\"localidade\",\"description\":\"Localidade\",\"align\":\"left\"}")
		.append(",{\"name\":\"descricao\",\"description\":\"Descrição\",\"align\":\"left\"}")
		.append(",{\"name\":\"unidadeMedida\",\"description\":\"Unidade de Medida\",\"align\":\"right\"}")
		.append("]");
		String header = new String(builder.toString().getBytes(), "UTF-8");
		
		Gson gson = new Gson();
		
		assertEquals(header, new String(gson.toJson(new ReportUtil().headerFieldsFromClass(TesteReportDTO.class)).getBytes(), "UTF-8"));
	}

	@Test
	public void testaGrupoTambemNoHeader() throws UnsupportedEncodingException{
		StringBuilder builder = new StringBuilder();
		builder.append("{")
		.append("\"titulo\":\"\"")
		.append(",")
		.append("\"cabecalho\":")
		.append("[{\"name\":\"municipio\",\"description\":\"Município\",\"align\":\"left\"},{\"name\":\"localidade\",\"description\":\"Localidade\",\"align\":\"left\"},{\"name\":\"descricao\",\"description\":\"Descrição\",\"align\":\"left\"},{\"name\":\"unidadeMedida\",\"description\":\"Unidade de Medida\",\"align\":\"right\"}]")
		.append(",")
		.append("\"dados\":")
		.append("[")
		.append("{\"descricao\":\"agua ardente\",\"unidadeMedida\":\"2Kg\"}")
		.append("],")
		.append("\"formato\":\"PDF\"")
		.append(",")
		.append("\"grupos\":[{\"name\":\"municipio\",\"description\":\"Município\"},{\"name\":\"localidade\",\"description\":\"Localidade\"}")
		.append("],")
		.append("\"totalizadores\":[{\"name\":\"unidadeMedida\"}")
		.append("]")
		.append("}");
		
		ReportDTO report = new ReportDTO("", null, TesteReportDTO.class);
		
		ReportItemDTO i1 = new TesteReportDTO(null, null, "agua ardente", "2Kg");
		List<ReportItemDTO> linhas = new ArrayList<ReportItemDTO>();
		linhas.add(i1);
		
		report.addLinhas(linhas);
		
		Gson gson = new Gson();
		
		System.out.println(gson.toJson(report));
		
		assertEquals(new String(builder.toString().getBytes(), "UTF-8"), new String(gson.toJson(report).getBytes(), "UTF-8"));
	}
}
