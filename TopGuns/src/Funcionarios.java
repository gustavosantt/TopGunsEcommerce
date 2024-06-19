public class Funcionarios extends Pessoas {
    private int id;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private String cargo;
    private Float salario;
    private String cpf;

    // Construtor
    public Funcionarios(String nome, String telefone, String endereco, String email, String cargo, Float salario, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.cargo = cargo;
        this.salario = salario;
        this.cpf = cpf;
    }

    // Get e Set
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nTelefone: " + telefone + "\nCPF: " + cpf + "\nEndereço: " + endereco +
                "\nE-mail: " + email + "\nCargo: " + cargo + "\nSalário: " + salario;
    }
}
