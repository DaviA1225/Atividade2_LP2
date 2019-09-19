package Teste;


public class Aluno extends Pessoa{
    
    private int ra;

    public Aluno(String nome, String sexo, long cpf, int idade){
        super.setNome(nome);
        super.setSexo(sexo);
        super.setCpf(cpf);
        super.setIdade(idade);
    }
    
    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }
    
    
}
