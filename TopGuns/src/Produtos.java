class Produtos {
    private String descricao;
    private String tipo;
    private float preco;
    private int quantEstoq;
    private String nome;
    private String idProduto;

    // Construtor
    public Produtos(String descricao, String tipo, float preco, int quantEstoq, String nome, String idProduto) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.preco = preco;
        this.quantEstoq = quantEstoq;
        this.nome = nome;
        this.idProduto = idProduto;
    }

    // Getters e Setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantEstoq() {
        return quantEstoq;
    }

    public void setQuantEstoq(int quantEstoq) {
        this.quantEstoq = quantEstoq;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nId Produto: " + idProduto + "\nTipo: " + tipo + "\nDescrição: " + descricao + "\nPreço: " + preco + "\nQuantidade em Estoque: " + quantEstoq;
    }
}