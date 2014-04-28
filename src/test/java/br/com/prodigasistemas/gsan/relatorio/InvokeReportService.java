package br.com.prodigasistemas.gsan.relatorio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class InvokeReportService {

	public static void main(String[] args) throws Exception {
		
		ReportDTO report = new ReportDTO(ProdutoReportDTO.class);
		
		ReportItemDTO i1 = new ProdutoReportDTO("belem", "marco", "agua ardente", "2Kg");
		List<ReportItemDTO> linhas = new ArrayList<ReportItemDTO>();
		linhas.add(i1);
		
		report.addLinhas(linhas);
		
		Gson gson = new Gson();
		
		String json = gson.toJson(report);
		
		Client client = Client.create();
		
		WebResource webResource = client.resource("http://192.168.0.16:3000/produtos_quimicos");
		
		ClientResponse response = webResource
				.type("application/json")
				.post(ClientResponse.class, json);
		
		InputStream input = response.getEntityInputStream();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		
		StringBuilder builder = new StringBuilder();
		String linha = null;
		while ((linha = reader.readLine()) != null){
			builder.append(linha);
		}
		
		if (builder.length() == 0 || response.getStatus() != 200){
			throw new Exception("Erro ao acessar servico");
		}
		
		ReportJsonReturn jsonRetorno = gson.fromJson(builder.toString(), ReportJsonReturn.class);
		
		if (jsonRetorno.temErro()){
			throw new Exception("Erro no retorno: " + jsonRetorno.getErro());
		}
		
		System.out.println("Url do report: " + jsonRetorno.getUrl());
	}
}