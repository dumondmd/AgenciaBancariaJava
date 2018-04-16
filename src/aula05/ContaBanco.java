package aula05;

public class ContaBanco {

    //Atributos
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    public void abrirConta(String t) {
        this.setTipo(t);
        this.setStatus(true);
        if ("CC".equals(t)) {
            this.setSaldo(50);
        } else if ("CP".equals(t)) {
            this.setSaldo(150);
        }
        System.out.println("-=<Conta aberta com sucesso>=-");
        System.out.println("Saldo de abertura: [ "+getSaldo()+" ]");
        System.out.println("---------------");
    }

    public void fecharConta() {
        if (this.getSaldo() > 0) {
            System.out.println(">Conta não pode ser fechada, pois ainda tem cŕedito de "+this.getSaldo());            
        } else if (this.getSaldo() < 0) {
            System.out.println(">Conta não pode ser fechada, pois tem débito de "+this.getSaldo());
        } else {
            this.setStatus(false);
            System.out.println(">Conta fechada com sucesso!");
        }
    }

    public void depositar(float v) {
        if (getStatus()) {
            this.setSaldo(this.getSaldo() + v);
            System.out.println(">Depósito de " + v + " realizado com sucesso na conta de " + this.getDono());
            System.out.println("Saldo anterior: " + (this.getSaldo() - v));
            System.out.println("*O saldo atual: " + this.getSaldo());

        } else if (this.getStatus() == false) {
            System.out.println("Impossível depositar em uma conta fechada");
        }

    }

    public void sacar(float v) {
        System.out.println("Saque de -"+v);
        if (this.getStatus()) {
            if (v > this.getSaldo()) {
                System.out.println("Saldo insuficiente para sacar! Na conta de " + this.getDono());
                System.out.println("*O saldo atual é de: " + this.getSaldo());
            } else if (v <= getSaldo()) {
                this.setSaldo(getSaldo() - v);
                System.out.println("Saque efetuado com sucesso! Na conta de " + this.getDono());
                System.out.println("*O saldo atual é de: " + this.getSaldo());

            }
        }
    }

    public void pagarMensal() {
        int v = 0;
        if("CC".equals(getTipo())){
            v = 12;            
        } else if("CP".equals(getTipo())){
            v = 20;
        }
        
        if(getStatus()){
            if(getSaldo() > v){
                setSaldo(getSaldo()-v);
                System.out.println(">Mensalidade paga");
                System.out.println("Mensalidade: "+v);
                System.out.println("Saldo atual: "+getSaldo());                
            } else {
                System.out.println("Saldo insuficiente para pagar mensalidade!");
                System.out.println("Mensalidade: "+v);
                System.out.println("Saldo atual: "+getSaldo());                
            }
        } else {
            System.out.println("Impossível pagar! Conta fechada!");
        }

    }

    public ContaBanco() {
        this.saldo = 0;
        this.status = false;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }  
}
