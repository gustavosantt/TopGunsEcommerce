import javax.swing.ImageIcon;

public class Produto {
    private String nome;
    private double preco;
    private ImageIcon imagem;

    public Produto(String nome, double preco, String imagePath) {
        this.nome = nome;
        this.preco = preco;
        this.imagem = new ImageIcon(imagePath);
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public ImageIcon getImagem() {
        return imagem;
    }
}