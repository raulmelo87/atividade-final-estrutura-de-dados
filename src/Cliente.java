public class Cliente {

    // Atributos
    private String nome;
    private String cpf;
    private String celular;
    private String email;

    // Método Construtor
    public Cliente(String nome, String cpf, String celular, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
        this.email = email;
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // ToString
    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Celular: " + celular + ", Email: " + email;
    }

}
