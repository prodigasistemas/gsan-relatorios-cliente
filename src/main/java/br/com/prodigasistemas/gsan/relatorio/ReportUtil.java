package br.com.prodigasistemas.gsan.relatorio;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReportUtil {

	public static List<ReportHeader> headerFields(Class item) {
		Field[] campos = item.getDeclaredFields();
		List<ReportHeader> headers = new ArrayList<ReportHeader>();
		for (Field field : campos) {
			if (field.isAnnotationPresent(ReportHeaderType.class)){
				ReportHeaderType campo  = field.getAnnotation(ReportHeaderType.class);
				headers.add(new ReportHeader(field.getName(), campo.description()));
			}
		}
		
		return headers;
	}
}
