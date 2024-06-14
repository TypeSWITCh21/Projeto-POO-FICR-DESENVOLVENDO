import conexao.ConexaoBD;
import dao.SocioDAO;
import model.Socio;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        SocioDAO socioDAO = new SocioDAO();

        
        Socio novoSocio = new Socio(1, "Fulano de Tal");
        try {
            socioDAO.cadastrarSocio(novoSocio);
            System.out.println("Sócio cadastrado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar sócio: " + e.getMessage());
        }

        
        try {
            final List<Socio> socios = socioDAO.listarSocios();
            System.out.println("Lista de sócios:");
            for (Socio socio : socios) {
                System.out.println("Matrícula: " + socio.getMatricula() + ", Nome: " + socio.getNome());
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar sócios: " + e.getMessage());
        }
    }
}


