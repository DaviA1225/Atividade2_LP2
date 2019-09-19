package atividade2_lp2;

import javax.swing.JOptionPane;
import Teste.Aluno;
import Teste.Professor;
import java.sql.SQLException;

public class EntradaDados {
    
    DAO dao = new DAO();

    public void entradaPessoa(String opcao) throws SQLException {
        String nome = JOptionPane.showInputDialog("Nome: ");
        String sexo = JOptionPane.showInputDialog("Sexo: ");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade: "));
        long cpf = Long.parseLong(JOptionPane.showInputDialog("CPF: "));
        
        if (opcao.equals("1")) {
            Aluno aluno = new Aluno(nome, sexo, cpf, idade);
            aluno.setRa(Integer.parseInt(JOptionPane.showInputDialog("RA: ")));
            dao.salvarNoBD(aluno);
        } else {
            Professor professor = new Professor(nome, sexo, cpf, idade);
            professor.setSiape((int) Long.parseLong(JOptionPane.showInputDialog("SIAPE: ")));
            dao.salvaNoBD(professor);
        }
    }
    
    public void exibirTodos(String opcao) throws SQLException{
        dao.exibirTodos(opcao);
    }
    
    public void excluirAluno(String opcao) throws NumberFormatException, SQLException{
        String cpf = JOptionPane.showInputDialog("Entre com o cpf de quem deseja remover: ");
        dao.excluirAluno(Long.parseLong(cpf), opcao);
    }
    
    public void excluirProfessor(String opcao) throws NumberFormatException, SQLException{
        String cpf = JOptionPane.showInputDialog("Entre com o cpf de quem deseja remover: ");
        dao.excluirProfessor(Long.parseLong(cpf), opcao);
    }
    
    public void atualizarAluno(String opcao) throws NumberFormatException, SQLException{
        String cpf = JOptionPane.showInputDialog("Digite o cpf que deseja atualizar: ");
        dao.atualizarAluno(Long.parseLong(cpf), opcao);
    }
    
    public void atualizarProfessor(String opcao) throws NumberFormatException, SQLException{
        String cpf = JOptionPane.showInputDialog("Digite o cpf que deseja atualizar: ");
        dao.atualizarProfessor(Long.parseLong(cpf), opcao);
    }

}

