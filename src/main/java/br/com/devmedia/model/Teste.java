package br.com.devmedia.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Teste {
	public static void main(String[] args) {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		ItemVenda itemVenda = new ItemVenda();
		itemVenda.setDescricao("Camisa GG");
		itemVenda.setPreco(30F);
		itemVenda.setQuantidade(3);
		
		Venda venda = new Venda();
		venda.setData(Calendar.getInstance());
		venda.setTipo(TipoVenda.VendaPadrao);
		venda.setTotal(0);
		venda.setItens(new ArrayList<ItemVenda>() {{
			//add(itemVenda);
		}});
		
		Set<ConstraintViolation<Venda>> violation = validator.validate(venda);
		for (ConstraintViolation<Venda> c : violation) {
			System.out.println(
					"Erro: " + c.getMessage() + " " 
					+ c.getPropertyPath() + " " 
					+ c.getRootBeanClass().getSimpleName());
		}
	}
	
}
