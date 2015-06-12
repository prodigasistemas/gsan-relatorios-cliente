package br.com.prodigasistemas.gsan.relatorio;

import java.util.ArrayList;
import java.util.List;

public class InvokeReportService {

	public static void main(String[] args) throws Exception {
		
		ReportDTO report = new ReportDTO("", null, TesteReportDTO.class);
		report.setFormato(FormatoRelatorio.XLS);
		
		List<ReportItemDTO> linhas = new ArrayList<ReportItemDTO>();
		ReportItemDTO i1 = new TesteReportDTO("belem", "marco", "agua ardente", "2");
		linhas.add(i1);
		i1 = new TesteReportDTO("ananindeua", "marco", "cano", "66");
		linhas.add(i1);
		i1 = new TesteReportDTO("belem", "marco", "cano", "2");
		linhas.add(i1);
		i1 = new TesteReportDTO("ananindeua", "marco", "agua", "5");
		linhas.add(i1);
		i1 = new TesteReportDTO("belem", "pedreira", "soda", "55");
		linhas.add(i1);
		i1 = new TesteReportDTO("belem", "marco", "agua", "4");
		linhas.add(i1);
		i1 = new TesteReportDTO("ananindeua", "pedreira", "agua", "5");
		linhas.add(i1);
		i1 = new TesteReportDTO("belem", "marco", "cano", "6");
		linhas.add(i1);
		i1 = new TesteReportDTO("belem", "marco", "soda", "565");
		linhas.add(i1);
		i1 = new TesteReportDTO("belem", "pedreira", "agua", "5");
		linhas.add(i1);
		i1 = new TesteReportDTO("ananindeua", "guanabara", "agua", "5");
		linhas.add(i1);
		
		report.addLinhas(linhas);
		
		new ReportUtil().invokeReport(report);
		
		System.out.println("Url do report: ");
//		System.out.println("Url do report: " + jsonRetorno.getUrl());
	}
}
