
package aula05;


public class Aula05 {

  
    public static void main(String[] args) {
      ContaBanco  c1 = new ContaBanco();
      c1.abrirConta("CP");
      c1.setDono("Dumon");
      
      
      c1.sacar((float)600.0);
      c1.fecharConta();
      
      
     
    }
    
}
