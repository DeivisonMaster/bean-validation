package br.com.devmedia.model;

import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.devmedia.validacao.TotalPorTipo;

@TotalPorTipo(message = "O Tipo não permite o valor informado")
public class Venda {
	
	/* não nulo, ao menos um item na lista, item da lista válido*/
	@NotNull(message = "A Lista de itens não pode ser nula")
	@Size(min = 1)
	@Valid
	private List<ItemVenda> itens;
	
	@NotNull(message = "A data da venda não pode ser nula")
	private Calendar data;
	
	@DecimalMin(value = "0", message = "O valor da venda deve ser igual ou maior que 0")
	private float total;
	
	@NotNull()
	private TipoVenda tipo;
	
	
	public List<ItemVenda> getItens() {
		return itens;
	}
	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public TipoVenda getTipo() {
		return tipo;
	}
	public void setTipo(TipoVenda tipo) {
		this.tipo = tipo;
	}
	
	
	
}
