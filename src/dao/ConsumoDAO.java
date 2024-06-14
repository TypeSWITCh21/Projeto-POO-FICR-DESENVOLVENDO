package dao;

import conexao.ConexaoBD;
import model.Consumo;
import model.Socio;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConsumoDAO {
    public void registrarConsumo(Consumo consumo) throws SQLException {
        String sql = "INSERT INTO consumo (id_socio, valor, data_hora) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, consumo.getSocio().getMatricula());
            stmt.setDouble(2, consumo.getValor());
            stmt.setTimestamp(3, Timestamp.valueOf(consumo.getDataHora()));
            stmt.executeUpdate();
        }
    }

    public List<Consumo> listarConsumos() throws SQLException {
        List<Consumo> consumos = new ArrayList<>();
        String sql = "SELECT * FROM consumo";
        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int idSocio = rs.getInt("id_socio");
                double valor = rs.getDouble("valor");
                LocalDateTime dataHora = rs.getTimestamp("data_hora").toLocalDateTime();
                Socio socio = new Socio(idSocio, ""); // Aqui você pode criar um método para buscar o sócio pelo ID
                Consumo consumo = new Consumo(socio, valor, dataHora);
                consumos.add(consumo);
            }
        }
        return consumos;
    }
}
