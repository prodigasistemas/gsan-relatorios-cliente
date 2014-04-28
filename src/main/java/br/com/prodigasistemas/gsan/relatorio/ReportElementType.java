package br.com.prodigasistemas.gsan.relatorio;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) 
@Retention(RetentionPolicy.RUNTIME)
public @interface ReportElementType {
	String description() default "";
	boolean header() default false;
	boolean group() default false;
}
