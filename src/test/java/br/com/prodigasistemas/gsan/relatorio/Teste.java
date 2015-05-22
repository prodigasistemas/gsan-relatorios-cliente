package br.com.prodigasistemas.gsan.relatorio;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Teste {
    
    public static void main(String[] args) throws Exception {
     
        ReportDTO report = new ReportDTO("", TesteReportDTO.class);
        
        List<ReportItemDTO> linhas = new ArrayList<ReportItemDTO>();
        ReportItemDTO i1 = new TesteReportDTO("belem", "marco", "agua ardente", "2Kg");
        linhas.add(i1);
        i1 = new TesteReportDTO("belem", "marco", "cano", "2");
        linhas.add(i1);
        i1 = new TesteReportDTO("belem", "marco", "agua", "4");
        linhas.add(i1);
        i1 = new TesteReportDTO("belem", "marco", "coco", "6");
        linhas.add(i1);
        i1 = new TesteReportDTO("belem", "marco", "soda", "565");
        linhas.add(i1);
        i1 = new TesteReportDTO("belem", "pedreira", "agua", "5");
        linhas.add(i1);
        i1 = new TesteReportDTO("ananindeua", "guanabara", "agua", "5");
        linhas.add(i1);
        
        report.addLinhas(linhas);
        
        Gson gson = new Gson();
        
        String json = gson.toJson(report);
        
        Client client = Client.create();
        
        WebResource webResource = client.resource("http://localhost:3000/relatorios");
        
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
