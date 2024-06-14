package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoBD;
import model.Evento;

public class EventoDAO {
    public void agendarEvento(Evento evento) throws SQLException {
        String sql = "INSERT INTO eventos (nome, data_hora, id_socio) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, evento.getNome());
            stmt.setTimestamp(2, Timestamp.valueOf(evento.getDataHora()));
            stmt.setInt(3, evento.getIdSocio());
            stmt.executeUpdate();
        }
    }

    public List<Evento> listarEventos(int idSocio) throws SQLException {
        List<Evento> eventos = new ArrayList<>();
        String sql = "SELECT * FROM eventos WHERE id_socio = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idSocio);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    LocalDateTime dataHora = rs.getTimestamp("data_hora").toLocalDateTime();
                    Evento evento = new Evento(id, nome, dataHora, idSocio);
                    eventos.add(evento);
                }
            }
        }
        return eventos;
    }

    public List<Evento> listarTodosEventos() throws SQLException {
        List<Evento> eventos = new ArrayList<>();
        String sql = "SELECT * FROM eventos";
        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                LocalDateTime dataHora = rs.getTimestamp("data_hora").toLocalDateTime();
                int idSocio = rs.getInt("id_socio");
                Evento evento = new Evento(id, nome, dataHora, idSocio);
                eventos.add(evento);
            }
        }
        return eventos;
    }
}
