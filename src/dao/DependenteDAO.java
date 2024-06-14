package dao;

import conexao.ConexaoBD;
import model.Dependente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DependenteDAO {
    public void cadastrarDependente(Dependente dependente, int idSocio) throws SQLException {
        String sql = "INSERT INTO dependentes (nome, parentesco, id_socio) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dependente.getNome());
            stmt.setString(2, dependente.getParentesco());
            stmt.setInt(3, idSocio);
            stmt.executeUpdate();
        }
    }

    public List<Dependente> listarDependentes(int idSocio) throws SQLException {
        List<Dependente> dependentes = new ArrayList<>();
        String sql = "SELECT * FROM dependentes WHERE id_socio = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idSocio);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String nome = rs.getString("nome");
                    String parentesco = rs.getString("parentesco");
                    Dependente dependente = new Dependente(nome, parentesco);
                    dependentes.add(dependente);
                }
            }
        }
        return dependentes;
    }
}
