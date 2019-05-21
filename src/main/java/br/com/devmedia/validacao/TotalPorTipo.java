package br.com.devmedia.validacao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.TYPE) // alvo da anotação, no caso anotação de uma classe
@Retention(RetentionPolicy.RUNTIME)	// define o escopo dos metadados, no caso em tempo de execução
@Constraint(validatedBy = {TotalPorTipoValidator.class})	// define a classe que vai implementar a validação
@Documented
public @interface TotalPorTipo {
	
	String message() default "{br.com.devmedia.model.Venda.TIPO}";	// define mensagem de erro padrão
	
	Class<?>[] groups() default {}; // 
	
	Class<? extends Payload>[] payload() default{}; // adiciona metadados de erros na aplicação
	
}
