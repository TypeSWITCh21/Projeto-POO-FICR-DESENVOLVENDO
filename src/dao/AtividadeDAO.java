package dao;

import conexao.ConexaoBD;
import model.Atividade;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AtividadeDAO {
    public void cadastrarAtividade(Atividade atividade) throws SQLException {
        String sql = "INSERT INTO atividades (nome, horario, professor, mensalidade) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, atividade.getNome());
            stmt.setString(2, atividade.getHorario());
            stmt.setString(3, atividade.getProfessor());
            stmt.setDouble(4, atividade.getMensalidade());
            stmt.executeUpdate();
        }
    }

    public List<Atividade> listarAtividades() throws SQLException {
        List<Atividade> atividades = new ArrayList<>();
        String sql = "SELECT * FROM atividades";
        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String horario = rs.getString("horario");
                String professor = rs.getString("professor");
                double mensalidade = rs.getDouble("mensalidade");
                Atividade atividade = new Atividade(id, nome, horario, professor, mensalidade);
                atividades.add(atividade);
            }
        }
        return atividades;
    }
}
