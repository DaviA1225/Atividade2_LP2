package atividade2_lp2;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

public class Atividade2_LP2 
{

    public static void main(String[] args) throws SQLException 
    {  
        EntradaDados entrada = new EntradaDados();

        String menu = "0- Sair\n1 - Salvar Aluno\n2 - Exibir Alunos"
                + "\n3 - Remover Aluno\n4- Salvar Professor\n"
                + "5 - Exibir Professores\n6 - Remover Professores";

        String opt = "";
        do {
            opt = JOptionPane.showInputDialog(menu);
            switch (opt) {
                case "0":
                    break;
                case "1":
                    entrada.entradaPessoa(opt);
                    break;
                case "2":
                    entrada.exibirTodos(opt);
                    break;
                case "3":
                    entrada.excluirAluno(opt);
                    break;
                case "4":
                    entrada.entradaPessoa(opt);
                    break;
                case "5":
                    entrada.exibirTodos(opt);
                    break;
                case "6":
                    entrada.excluirProfessor(opt);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        } while (!opt.equals("0"));
    } 
        
        
        
    }
   
