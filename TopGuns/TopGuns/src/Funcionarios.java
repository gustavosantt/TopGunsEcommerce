    public class Funcionarios extends Pessoas {
        private String cargo;
        private Float salario;
        private String cpf;

        // Construtores
        public Funcionarios(String nome, String telefone, String endereco, String email, String cargo, Float salario, String cpf) {
            super(nome, telefone, endereco, email);
            this.cargo = cargo;
            this.salario = salario;
            this.cpf = cpf;
        }

        // Get e set
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
            return super.toString() + "\nCargo: " + cargo + "\nSalário: " + salario + "\nCPF: " + cpf;
        }
    }
