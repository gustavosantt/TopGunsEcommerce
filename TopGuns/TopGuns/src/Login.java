import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JPanel panel1;
    private JLabel jlLogin;
    private JLabel jlSenha;
    private JTextField jtfLogin;
    private JPasswordField jtfSenha;
    private JButton jbLogin;
    private JButton jbCancel;
    private JLabel jlImage;

    public Login() {
        setTitle("Login");
        setSize(900, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        setupListeners();
    }

    private void initComponents() {
        panel1 = new JPanel(new GridBagLayout());
        setContentPane(panel1);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;

        // imagem
        ImageIcon icon = new ImageIcon("C:\\Users\\Gustavo Henrique\\Downloads\\TopGuns\\TopGuns\\src\\Imagens\\Logo login.jpg"); // Replace with your image path


        jlImage = new JLabel(icon);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel1.add(jlImage, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        jlLogin = new JLabel("Login:");
        panel1.add(jlLogin, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        jtfLogin = new JTextField(20);
        panel1.add(jtfLogin, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        jlSenha = new JLabel("Senha:");
        panel1.add(jlSenha, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        jtfSenha = new JPasswordField(20);
        panel1.add(jtfSenha, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        jbLogin = new JButton("Login");
        panel1.add(jbLogin, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        jbCancel = new JButton("Cancel");
        panel1.add(jbCancel, gbc);
    }

    private void setupListeners() {
        jbLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = jtfLogin.getText();
                String password = new String(jtfSenha.getPassword());

                if (validateLogin(username, password)) {
                    JOptionPane.showMessageDialog(Login.this, "Logando...");
                    openMainMenu();
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Senha Invalida", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        jbCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);  // Fecha a aplicação
            }
        });
    }

    private boolean validateLogin(String username, String password) {
        return "admin".equals(username) && "123".equals(password);
    }

    private void openMainMenu() {
        MainManu mainMenu = new MainManu();
        mainMenu.setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
