package atividade2_lp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Teste.Aluno;
import Teste.Pessoa;
import Teste.Professor;
import java.sql.ResultSet;


public class DAO {

    List<Pessoa> listaDePessoas = new ArrayList<>();

    public void salvar(Pessoa pessoa) {
        listaDePessoas.add(pessoa);
    }

    public void exibirTodos(String opcao) throws SQLException{
        
        String msg = "";
        if (opcao.equals("2")) {
            for (int i = 0; i < listaDePessoas.size(); i++) {
                if (listaDePessoas.get(i) instanceof Aluno) {
                    Aluno aluno = (Aluno) listaDePessoas.get(i);
                    msg += aluno.getNome() + " - RA: " + aluno.getRa() + "\n";
                }
            }
        } else {
            for (int i = 0; i < listaDePessoas.size(); i++) {
                if (listaDePessoas.get(i) instanceof Professor) {
                    Professor professor = (Professor) listaDePessoas.get(i);
                    msg = professor.getNome() + " - SIAPE: " + professor.getSiape();
                }
            }
        }
        JOptionPane.showMessageDialog(null, msg);
        
        Connection conexao = null;
    	 
    	 if(opcao == "2") {
	        try {
                 	conexao = DriverManager.getConnection("jdbc:derby://localhost/Banco_LP2", "Davi", "yeshua1206");
	         	    	String sql = "select * from Aluno";
	       
	 		} catch (Exception e) {
	 			JOptionPane.showMessageDialog(null, e.getMessage());
	 		} finally {
	 			conexao.close();
	 		}
    	 }
    	 else {
    		 try {
 	         	conexao = DriverManager.getConnection("jdbc:derby://localhost/Banco_LP2", "Davi", "yeshua1206");
 	         	    	String sql = "select * from Professor";
 	       
 	 		} 
    		 catch (Exception e) {
 	 			JOptionPane.showMessageDialog(null, e.getMessage());
 	 		} 
    		 finally {
 	 			conexao.close();
 	 		}
     	 }
    }

    
    public void excluirAluno(long cpf, String opcao) throws SQLException {
        //boolean removido = false;

        for (Pessoa pessoa : listaDePessoas) {
            if (pessoa.getCpf() == cpf) {
                if ((opcao.equals("3") && pessoa instanceof Aluno)
                        || (opcao.equals("6") && pessoa instanceof Professor)) {
                    listaDePessoas.remove(pessoa);
                    JOptionPane.showMessageDialog(null, pessoa.getClass().getSimpleName()
                            + " Removido com sucesso!");
                    //removido = true;
                }
            }
        }

         Connection conexao = null;
        
        
        try {
        	boolean removido = true;
        	conexao = DriverManager.getConnection("jdbc:derby://localhost/Banco_LP2", "Davi", "yeshua1206");
        	if (!removido) {
                JOptionPane.showMessageDialog(null, "CPF não encontrado!");
            } else {
        	    	String sql = "delete from Aluno where cpf = ?";
        	    	
        	JOptionPane.showConfirmDialog(null, "Aluno excluido!");
            }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			conexao.close();
			}
        }
    
    public void excluirProfessor(long cpf, String opcao) throws SQLException {
        
         Connection conexao = null;
        
        
        try {
        	boolean removido = true;
        	conexao = DriverManager.getConnection("jdbc:derby://localhost/Banco_LP2", "Davi", "yeshua1206");
        	if (!removido) {
                JOptionPane.showMessageDialog(null, "CPF não encontrado!");
            } else {
        	    	String sql = "delete from Professor where cpf = ?";
        	    	
        	JOptionPane.showConfirmDialog(null, "Professor excluido!");
            }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			conexao.close();
		}
    }
    
    
    
    
    public void salvarNoBD(Aluno aluno) throws SQLException{
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost/Banco_LP2", "Davi", "yeshua1206");
            String sql = "insert into aluno (nome, sexo, idade, cpf, ra) " + "values(?,?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getSexo());
            ps.setInt(3, aluno.getIdade());
            ps.setLong(4, aluno.getCpf());
            ps.setInt(5, aluno.getRa());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                JOptionPane.showMessageDialog(null, "Salvo com Sucesso !");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally{
            conexao.close();
        }
    }


    
    public void salvaNoBD(Professor professor) throws SQLException
    {
        
        Connection conexao = null;
        try{
            conexao = DriverManager.getConnection("jdbc:derby://localhost/Banco_LP2", "Davi", "yeshua1206");
            String sql = "insert into professor (nome, sexo, idade, cpf, siape) " + "values(?,?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, professor.getNome());
            ps.setString(2, professor.getSexo());
            ps.setInt(3, professor.getIdade());
            ps.setLong(4, professor.getCpf());
            ps.setLong(5, professor.getSiape());
            int retorno = ps.executeUpdate();
            
            if (retorno > 0) {
                JOptionPane.showMessageDialog(null, "Salvo com Sucesso !");
            }
        }
         catch (SQLException ex) 
         {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        finally{
            conexao.close();
        }
    }
    
public void atualizarAluno(Aluno aluno) throws SQLException{
    
    Connection conexao = null;
    
    try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost/Banco_LP2", "Davi", "yeshua1206");
            String sql = "update aluno set nome = ?,sexo = ?, idade = ?, ra = ?, where cpf = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getSexo());
            ps.setInt(3, aluno.getIdade());
            ps.setLong(4, aluno.getCpf());
            ps.setInt(5, aluno.getRa());
           
            
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                JOptionPane.showMessageDialog(null, "Atualizado !");
            }            
    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally{
            conexao.close();
            }
}

 public void atualizarProfessor(Professor professor) throws SQLException{
     
     Connection conexao = null;
     
     try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost/Banco_LP2", "Davi", "yeshua1206");
            String sql = "update professor set nome = ?, sexo = ?, idade = ?, siape = ?, where cpf = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, professor.getNome());
            ps.setString(2, professor.getSexo());
            ps.setInt(3, professor.getIdade());
            ps.setLong(4, professor.getCpf());
            ps.setLong(5, professor.getSiape());
            
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                JOptionPane.showMessageDialog(null, "Atualizado");
            }            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally{
            conexao.close();
            }   
     
     
 
        }

    void atualizarAluno(long parseLong, String opcao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void atualizarProfessor(long parseLong, String opcao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}