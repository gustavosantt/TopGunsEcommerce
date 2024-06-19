public class Clientes extends Pessoas {
    private String nome;
    private String telefone;
    private String cpf;
    private String rg;
    private String endereco;
    private String email;
    private boolean autorizacao;

    // Construtor
    public Clientes(String nome, String telefone, String cpf, String rg, String endereco, String email, boolean autorizacao) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.email = email;
        this.autorizacao = autorizacao;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAutorizacao() {
        return autorizacao;
    }

    public void setAutorizacao(boolean autorizacao) {
        this.autorizacao = autorizacao;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nTelefone: " + telefone + "\nCPF: " + cpf + "\nRG: " + rg +
                "\nEndereço: " + endereco + "\nE-mail: " + email + "\nAutorização: " + (autorizacao ? "Sim" : "Não");
    }
}
