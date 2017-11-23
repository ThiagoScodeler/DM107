package com.trabalho.logistica.api;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EntregaModel {

	private int id;
	
	@JsonProperty("numero_pedido")
	private int numeroPedido;
	
	@JsonProperty("id_cliente")
	private int idCliente;
	
	@JsonProperty("nome_recebedor")
	private String nomeRecebedor;
	
	@JsonProperty("cpf_recebedor")
	private String cpfRecebedor;
	
	@JsonProperty("data_hora_entrega")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp dataHoraEntrega;

	public EntregaModel() {
	}

	public EntregaModel(int id, int numeroPedido, int idCliente, String nomeRecebedor, String cpfRecebedor,
			Timestamp dataHoraEntrega) {
		this.id = id;
		this.numeroPedido = numeroPedido;
		this.idCliente = idCliente;
		this.nomeRecebedor = nomeRecebedor;
		this.cpfRecebedor = cpfRecebedor;
		this.dataHoraEntrega = dataHoraEntrega;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeRecebedor() {
		return nomeRecebedor;
	}

	public void setNomeRecebedor(String nomeRecebedor) {
		this.nomeRecebedor = nomeRecebedor;
	}

	public String getCpfRecebedor() {
		return cpfRecebedor;
	}

	public void setCpfRecebedor(String cpfRecebedor) {
		this.cpfRecebedor = cpfRecebedor;
	}

	public Timestamp getDataHoraEntrega() {
		return dataHoraEntrega;
	}

	public void setDataHoraEntrega(Timestamp dataHoraEntrega) {
		this.dataHoraEntrega = dataHoraEntrega;
	}

}
