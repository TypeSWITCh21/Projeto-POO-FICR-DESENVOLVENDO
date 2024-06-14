package model;

public class Atividade {
    private int id;
    private String nome;
    private String horario;
    private String professor;
    private double mensalidade;

    public Atividade(int id, String nome, String horario, String professor, double mensalidade) {
        this.id = id;
        this.nome = nome;
        this.horario = horario;
        this.professor = professor;
        this.mensalidade = mensalidade;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(double mensalidade) {
        this.mensalidade = mensalidade;
    }
}
