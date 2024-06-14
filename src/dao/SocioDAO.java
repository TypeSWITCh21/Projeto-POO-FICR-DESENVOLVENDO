package dao;

import conexao.ConexaoBD;
import model.Socio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SocioDAO {
    public void cadastrarSocio(Socio socio) throws SQLException {
        String sql = "INSERT INTO socios (nome, matricula) VALUES (?, ?)";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, socio.getNome());
            stmt.setInt(2, socio.getMatricula());
            stmt.executeUpdate();
        }
    }

    public Socio buscarSocioPorMatricula(int matricula) throws SQLException {
        Socio socio = null;
        String sql = "SELECT * FROM socios WHERE matricula = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, matricula);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nome = rs.getString("nome");
                    socio = new Socio(matricula, nome);
                }
            }
        }
        return socio;
    }

    public List<Socio> listarTodosSocios() throws SQLException {
        List<Socio> socios = new ArrayList<>();
        String sql = "SELECT * FROM socios";
        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int matricula = rs.getInt("matricula");
                String nome = rs.getString("nome");
                Socio socio = new Socio(matricula, nome);
                socios.add(socio);
            }
        }
        return socios;
    }

    public void excluirSocio(int matricula) throws SQLException {
        String sql = "DELETE FROM socios WHERE matricula = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, matricula);
            stmt.executeUpdate();
        }
    }
}
