import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ClienteRegistro extends JFrame {
    private HashMap<String, Cliente> clientes; // HashMap para armazenar os clientes

    // Componentes da interface gráfica
    private JTextField nomeField, cpfCadastroField, cpfConsultaField, celularField, emailField;
    private JButton cadastrarButton, consultarButton;
    private JTextArea listaClientesArea;

    public ClienteRegistro() {
        clientes = new HashMap<>(); // Inicializa o HashMap

        // Configuração da janela
        setTitle("Registro de Clientes");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        // Criação dos componentes
        nomeField = new JTextField(20);
        cpfCadastroField = new JTextField(20);
        cpfConsultaField = new JTextField(20);
        celularField = new JTextField(20);
        emailField = new JTextField(20);
        cadastrarButton = new JButton("Cadastrar");
        consultarButton = new JButton("Consultar");
        listaClientesArea = new JTextArea(10, 30);
        listaClientesArea.setEditable(false);

        // Layout da janela
        JPanel cadastrarPanel = new JPanel();
        cadastrarPanel.setBorder(BorderFactory.createTitledBorder("Cadastrar Cliente"));
        cadastrarPanel.add(new JLabel("Nome:"));
        cadastrarPanel.add(nomeField);
        cadastrarPanel.add(new JLabel("CPF:"));
        cadastrarPanel.add(cpfCadastroField);
        cadastrarPanel.add(new JLabel("Celular:"));
        cadastrarPanel.add(celularField);
        cadastrarPanel.add(new JLabel("Email:"));
        cadastrarPanel.add(emailField);
        cadastrarPanel.add(cadastrarButton);

        JPanel consultarPanel = new JPanel();
        consultarPanel.setBorder(BorderFactory.createTitledBorder("Consultar Cliente"));
        consultarPanel.add(new JLabel("CPF:"));
        consultarPanel.add(cpfConsultaField);
        consultarPanel.add(consultarButton);

        JPanel listaPanel = new JPanel();
        listaPanel.setBorder(BorderFactory.createTitledBorder("Lista de Clientes"));
        listaPanel.add(new JScrollPane(listaClientesArea));

        setLayout(new GridLayout(3, 1));
        add(cadastrarPanel);
        add(consultarPanel);
        add(listaPanel);

        // Ação do botão cadastrar
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCliente();
            }
        });

        // Ação do botão consultar
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarCliente();
            }
        });
    }

    // Método para cadastrar um cliente
    private void cadastrarCliente() {
        String nome = nomeField.getText();
        String cpf = cpfCadastroField.getText();
        String celular = celularField.getText();
        String email = emailField.getText();

        Cliente cliente = new Cliente(nome, cpf, celular, email);
        clientes.put(cpf, cliente); // Adiciona o cliente ao HashMap
        listaClientesArea.append(cliente.toString() + "\n"); // Atualiza a lista de clientes
        limparCampos();

    }

    // Método para consultar um cliente pelo CPF
    private void consultarCliente() {
        String cpf = cpfConsultaField.getText();
        Cliente cliente = clientes.get(cpf);
        if (cliente != null) {
            JOptionPane.showMessageDialog(this, cliente.toString(), "Informações do Cliente", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Cliente não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para limpar os campos de entrada
    private void limparCampos() {
        nomeField.setText("");
        cpfCadastroField.setText("");
        celularField.setText("");
        emailField.setText("");
    }

}

