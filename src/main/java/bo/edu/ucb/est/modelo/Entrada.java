package bo.edu.ucb.est.modelo;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Entrada {
	Scanner sn = new Scanner(System.in);
	Banco banco;
	public Entrada(Banco banco){
		this.banco = banco;
	}

    /**
     *
     * @return 
     * @return
     */
    public  void validarIngreso(){
    	Cliente cliente = null;
    	String codigoCliente, pin;
        while(cliente == null) {
        	System.out.println("Bienvenido al "+banco.getNombre());
        	System.out.print("Ingrese su codigo de cliente: ");
        	codigoCliente = sn.next();
        	System.out.print("Ingrese su pin: ");
        	pin = sn.next();
        	cliente = banco.buscarClientePorCodigo(codigoCliente, pin);
        	if (cliente == null) {
            	//System.out.println("Bienvenido al "+banco.getNombre());
            	System.out.println("Error en codigo o pin, por favor intente de nuevo.");
        	}
        	else {
        		Menu menu = new Menu (cliente, banco);
        		menu.mostrar();
        	}
        }
    }
}
