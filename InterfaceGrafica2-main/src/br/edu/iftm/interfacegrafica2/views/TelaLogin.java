package br.edu.iftm.interfacegrafica2.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import br.edu.iftm.interfacegrafica2.views.Usuario;


public class TelaLogin extends JPanel {

    private final Color COR_FUNDO = Color.decode("#f9f9f9");
    private JLabel labelContaRiot;
    private JLabel imagemFundo;
    private JTextField campoUsuario;
    private JTextField campoSenha;
    private JButton botaoLogar;
    private JLabel imagemLogo;

    public TelaLogin() {
        this.setBackground(COR_FUNDO);
        this.setLayout(null);
        this.iniciarInterface();
    }

    public void iniciarInterface() {

        this.imagemLogo = this.criarImagem("logo.png", new Rectangle(150, 30, 59, 59));
        //Cadastro de usuários
        ArrayList<Usuario> usuariolista = new ArrayList<Usuario>();
        Usuario us1= new Usuario("marcosjose123","mj19081993");
        Usuario us2= new Usuario("divinokratos2","felix1479");
        Usuario us3= new Usuario("skymore12","gab08082002");
        usuariolista.add(us1);
        usuariolista.add(us2);
        usuariolista.add(us3);

        labelContaRiot = new JLabel("Fazer login");
        labelContaRiot.setBounds(118, 125, 150, 30);
        labelContaRiot.setFont(new Font("Tahoma", Font.BOLD, 22));
        labelContaRiot.setForeground(Color.decode("#111111"));

        this.imagemFundo = this.criarImagem("fundo.jpg", new Rectangle(340, 0, 940, 700));

        this.campoUsuario = new JTextField();
        this.campoUsuario = this.alterarEstiloCampo("NOME DE USUÃ�RIO", 190);

        this.campoSenha = new JPasswordField();
        this.campoSenha = this.alterarEstiloCampo("SENHA", 250);

        this.botaoLogar = new JButton("Entrar");
        botaoLogar.setBounds(101, 435, 113, 45);
        botaoLogar.setBackground(COR_FUNDO);
        botaoLogar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                String senha = campoSenha.getText();
                String mensagem = String.format("Você fez o login com sucesso!", usuario, senha);
                if (usuario.equals(us1.getUsuario()) && senha.equals(us1.getSenha())) {
                    JOptionPane.showMessageDialog(null, mensagem, "Login", JOptionPane.PLAIN_MESSAGE);
                    System.exit(1);                    
                } 
                if (usuario.equals(us2.getUsuario()) && senha.equals(us2.getSenha())) {
                    JOptionPane.showMessageDialog(null, mensagem, "Login", JOptionPane.PLAIN_MESSAGE);
                    System.exit(1);
                }
                if (usuario.equals(us3.getUsuario()) && senha.equals(us3.getSenha())) {
                    JOptionPane.showMessageDialog(null, mensagem, "Login", JOptionPane.PLAIN_MESSAGE);
                    System.exit(1);
                }else {
                    JOptionPane.showMessageDialog(null, "Login ou senha inválidos", "Login", JOptionPane.ERROR_MESSAGE);
                }
            }

        });

        this.add(imagemLogo);
        this.add(labelContaRiot);
        this.add(campoUsuario);
        this.add(campoSenha);
        this.add(imagemFundo);
        this.add(botaoLogar);

    }

    public JLabel criarImagem(String nomeImagem, Rectangle bounds) {
        JLabel labelImagem = new JLabel("");
        ImageIcon imagem = new ImageIcon(this.getClass().getResource("imagens/" + nomeImagem));
        labelImagem.setIcon(imagem);
        labelImagem.setBounds(bounds);
        return labelImagem;
    }

    private JTextField alterarEstiloCampo(String placeHolder, int posicaoY) {

        JTextField campo = new JTextField(placeHolder);

        // atualiza a mensagem o campo
        campo.setText(placeHolder);
        // posicao na tela
        campo.setBounds(45, posicaoY, 260, 50);
        // cor do fundo
        campo.setBackground(Color.decode("#ededed"));
        // define a borda e espaÃ§amento intero
        campo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        // estilo da fonte (negrito e tamanho)
        campo.setFont(new Font("Tahoma", Font.BOLD, 12));
        // cor da fonte
        campo.setForeground(Color.decode("#999999"));

        campo.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if(campo.getText().equals(placeHolder)){
                    campo.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(campo.getText().isEmpty()){
                    campo.setText(placeHolder);
                }
            }
        });
        return campo;
    }
}
