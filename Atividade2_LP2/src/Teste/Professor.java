package Teste;


public class Professor extends Pessoa{
    
    private long siape;

    public Professor(String nome, String sexo, long cpf, int idade){
        
        super.setNome(nome);
        super.setSexo(sexo);
        super.setCpf(cpf);
        super.setIdade(idade);
    }
    
    public long getSiape() {
        return siape;
    }

    public void setSiape(int siape) {
        this.siape = siape;
    }
    
}
