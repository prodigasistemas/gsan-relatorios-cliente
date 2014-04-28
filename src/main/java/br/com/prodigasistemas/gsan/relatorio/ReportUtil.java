package br.com.prodigasistemas.gsan.relatorio;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;

public class ReportUtil {
	
	public List<ReportField> headerFieldsFromClass(Class t) {
		return fieldsFromClass(t, false, true);
	}

	public List<ReportField> groupFieldsFromClass(Class t) {
		return fieldsFromClass(t, true, false);
	}
	
	public List<ReportField> fieldsFromClass(Class t, boolean group, boolean header) {
		Field[] campos = t.getDeclaredFields();
		List<ReportField> fields = new ArrayList<ReportField>();
		for (Field field : campos) {
			if (field.isAnnotationPresent(ReportElementType.class)){
				ReportElementType campo  = field.getAnnotation(ReportElementType.class);
				if ((group && campo.group()) || (header && campo.header())){
					fields.add(new ReportField(field.getName(), campo.description()));
				}
			}
		}
		
		return fields;
	}
	
}
