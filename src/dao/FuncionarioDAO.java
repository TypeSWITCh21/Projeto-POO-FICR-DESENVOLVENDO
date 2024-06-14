package dao;

import conexao.ConexaoBD;
import model.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    public void cadastrarFuncionario(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO funcionarios (nome, cargo) VALUES (?, ?)";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.executeUpdate();
        }
    }

    public List<Funcionario> listarFuncionarios() throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionarios";
        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cargo = rs.getString("cargo");
                Funcionario funcionario = new Funcionario(id, nome, cargo);
                funcionarios.add(funcionario);
            }
        }
        return funcionarios;
    }
}
