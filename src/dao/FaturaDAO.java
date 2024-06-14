package dao;

import conexao.ConexaoBD;
import model.Fatura;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FaturaDAO {
    public void gerarFatura(Fatura fatura) throws SQLException {
        String sql = "INSERT INTO faturas (id_evento, valor, data_vencimento) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, fatura.getIdEvento());
            stmt.setDouble(2, fatura.getValor());
            stmt.setDate(3, Date.valueOf(fatura.getDataVencimento()));
            stmt.executeUpdate();
        }
    }

    public List<Fatura> listarFaturas(int idSocio) throws SQLException {
        List<Fatura> faturas = new ArrayList<>();
        String sql = "SELECT * FROM faturas JOIN eventos ON faturas.id_evento = eventos.id WHERE eventos.id_socio = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idSocio);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int idEvento = rs.getInt("id_evento");
                    double valor = rs.getDouble("valor");
                    LocalDate dataVencimento = rs.getDate("data_vencimento").toLocalDate();
                    Fatura fatura = new Fatura(idEvento, valor, dataVencimento);
                    faturas.add(fatura);
                }
            }
        }
        return faturas;
    }
}
