public class Fornecedores extends Pessoas {
    private String id;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private String cnpj;

    // Construtor da classe
    public Fornecedores(String id, String nome, String telefone, String endereco, String email, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.cnpj = cnpj;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Nome: " + nome + "\n" +
                "Telefone: " + telefone + "\n" +
                "Endereço: " + endereco + "\n" +
                "Email: " + email + "\n" +
                "CNPJ: " + cnpj;
    }
}
