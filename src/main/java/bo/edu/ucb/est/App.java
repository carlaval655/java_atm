package bo.edu.ucb.est;
import bo.edu.ucb.est.modelo.Banco;
import bo.edu.ucb.est.modelo.Cliente;
import bo.edu.ucb.est.modelo.Cuenta;
import bo.edu.ucb.est.modelo.Entrada;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Inicializando Datos del Banco" );
        Banco bisa = new Banco("BANCO BISA");
        
        Cliente jperez = new Cliente(" Juan Perez", "jperez", "3333");
        Cuenta cta1Jperez = new Cuenta("111122","BOB", "Caja Ahorros", 12000.0);
        jperez.agregarCuenta(cta1Jperez);
        Cuenta cta2Jperez = new Cuenta("112211","USD", "Cuenta Corriente", 100.0);
        jperez.agregarCuenta(cta2Jperez);
        bisa.agregarCliente(jperez);
        
        Cliente mgomez = new Cliente("Maria Gomez", "mgomez", "4444");
        Cuenta cta1Mgomez = new Cuenta("221122","BOB", "Caja Ahorros", 0.0);
        mgomez.agregarCuenta(cta1Mgomez);
        bisa.agregarCliente(mgomez);
        
        Cliente cgomez = new Cliente("Carlos Gomez", "cgomez", "3333");
        Cuenta cta1Cgomez = new Cuenta("331122","BOB", "Caja Ahorros", 100.0);
        cgomez.agregarCuenta(cta1Cgomez);
        Cuenta cta2Cgomez = new Cuenta("332211","USD", "Cuenta Corriente", 1000.0);
        cgomez.agregarCuenta(cta2Cgomez);
        Cuenta cta3Cgomez = new Cuenta("332233","BOB", "Caja Ahorros", 100000.0);
        cgomez.agregarCuenta(cta3Cgomez);
        bisa.agregarCliente(cgomez);
        System.out.println( "Los datos del banco se inicializaron correctamente. " );
        Entrada e = new Entrada(bisa);
        e.validarIngreso();
    }
}
