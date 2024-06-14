package dao;

import conexao.ConexaoBD;
import java.sql.*;
import java.time.LocalDateTime;

public class CheckinCheckoutDAO {
    public void registrarCheckin(int idSocio, LocalDateTime dataHora) throws SQLException {
        String sql = "INSERT INTO checkingcheckout (id_socio, data_hora_checkin) VALUES (?, ?)";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idSocio);
            stmt.setTimestamp(2, Timestamp.valueOf(dataHora));
            stmt.executeUpdate();
        }
    }

    public void registrarCheckout(int idSocio, LocalDateTime dataHora) throws SQLException {
        String sql = "UPDATE checkingcheckout SET data_hora_checkout = ? WHERE id_socio = ? AND data_hora_checkout IS NULL";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setTimestamp(1, Timestamp.valueOf(dataHora));
            stmt.setInt(2, idSocio);
            stmt.executeUpdate();
        }
    }
}
