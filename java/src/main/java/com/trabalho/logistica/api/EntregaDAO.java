package com.trabalho.logistica.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class EntregaDAO {

	public void insert(Connection conn, EntregaModel entrega) throws SQLException {
		String sql = "insert into entregas (numero_pedido, id_cliente, nome_recebedor, cpf_recebedor, data_hora_entrega) values (?, ?, ?, ?, ?);";
		PreparedStatement pstm;
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, entrega.getNumeroPedido());
		pstm.setInt(2, entrega.getIdCliente());
		pstm.setString(3, entrega.getNomeRecebedor());
		pstm.setString(4, entrega.getCpfRecebedor());
		pstm.setTimestamp(5, entrega.getDataHoraEntrega());
		pstm.execute();
	}

	public EntregaModel listById(Connection conn, int contatoId) throws SQLException {
		String sql = "select * from entregas where numero_pedido = ?";
		PreparedStatement pstm;
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, contatoId);
		ResultSet rs = pstm.executeQuery();
		EntregaModel entrega = new EntregaModel();
		while (rs.next()) {
			int id = rs.getInt("id");
			int numeroPedido = rs.getInt("numero_pedido");
			int idCliente = rs.getInt("id_cliente");
			String nomeRecebedor = rs.getString("nome_recebedor");
			String cpfRecebedor = rs.getString("cpf_recebedor");
			Timestamp dataHoraEntrega = rs.getTimestamp("data_hora_entrega");
			entrega = new EntregaModel(id, numeroPedido, idCliente, nomeRecebedor, cpfRecebedor, dataHoraEntrega);
		}
		return entrega;
	}
}
