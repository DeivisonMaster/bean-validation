package br.com.devmedia.validacao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

import br.com.devmedia.model.TipoVenda;
import br.com.devmedia.model.Venda;

public class TotalPorTipoValidator implements ConstraintValidator<TotalPorTipo, Venda>{

	public void initialize(TotalPorTipo constraintAnnotation) {
		
	}

	public boolean isValid(Venda venda, ConstraintValidatorContext context) {
		if(venda == null) {
			return false;
		}
		
		boolean valido = false;
		if(venda.getTipo() == TipoVenda.VendaPadrao && venda.getTotal() > 0) {
			valido = true;
		}
		
		if(venda.getTipo() == TipoVenda.VendaBrinde && venda.getTotal() == 0) {
			valido = true;
		}
		
		if(!valido) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
			.addPropertyNode(name: "tipo").addConstraintViolation();
		}
		
		return valido;
	}

}
