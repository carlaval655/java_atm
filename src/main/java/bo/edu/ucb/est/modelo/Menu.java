package bo.edu.ucb.est.modelo;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
	Cliente cliente;
	Banco banco;
	Scanner sn = new Scanner(System.in);
    public Menu (Cliente cliente, Banco banco) {
    	this.cliente = cliente;
    	this.banco = banco;
    }
    public void mostrar(){
        Scanner sn = new Scanner(System.in);
        int opcion;
            try {
            	System.out.println("Bienvenido al "+banco.getNombre());
                System.out.println("Elige una de las opciones: ");
                System.out.println("1. Ver saldo");
                System.out.println("2. Retirar dinero");
                System.out.println("3. Depositar dinero");
                System.out.println("4. Salir");
                opcion = sn.nextInt();
                
                switch (opcion) {
                    case 1:
                    	mostrarInfoCuenta(obtenerCuenta());
                    	volverMenu();
                    	break;
                    case 2:
                    	boolean flag = false;
                    	Cuenta cuenta1 = obtenerCuenta();
                    	while(flag==false){
                    	flag = cuenta1.retirar(montoARetirar(cuenta1));
                    	if (flag==false) {
                    		System.out.println("Introduzca un monto valido.\nDebe ser mayor a 0 y menor a "+cuenta1.getSaldo());
                    	}
                    	}
                    	volverMenu();
                    	break;
                    case 3:
                    	boolean flag2 = false;
                    	Cuenta cuenta2 = obtenerCuenta();
                    	while(flag2==false) {
                    	mostrarInfoCuenta(cuenta2);
                        flag2 = cuenta2.depositar(montoADepositar(cuenta2));
                        if (flag2==false) {
                    		System.out.println("Introduzca un monto valido mayor a 0");
                    	}
                    	}
                    	volverMenu();
                        break;
                    case 4:
                        Entrada e = new Entrada(banco);
                        e.validarIngreso();
                        break;
                    default:
                        System.out.println("Introduzca un numero del 1 al 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Introduzca un número del 1 al 4");
                sn.next();
            }
    }
    public Cuenta obtenerCuenta(){
    	List <Cuenta> cuentas = cliente.getCuentas();
    	boolean flag = false;
    	do {
    	System.out.println("Escoja una cuenta\n   Nro Cuenta");
    	for ( int i = 0; i < cuentas.size() ; i++) {
            Cuenta cuenta = cuentas.get(i); // Sacando elemento por elemento
            //System.out.println((i+1)+". "+cuenta.getNroCuenta()+" "+cuenta.getTipo()+" "+cuenta.getSaldo()+" ("+cuenta.getMoneda()+") ");
            System.out.println((i+1)+". "+cuenta.getNroCuenta());
    	}
    	System.out.println((cuentas.size()+1)+". Volver al menu principal. ");
    	int opcion;
    	try {
    		opcion = sn.nextInt();
    		if (opcion>=1 && opcion<=cuentas.size()) {
    			return cuentas.get(opcion-1);
    		}
    		else {
    			if (opcion==cuentas.size()+1) {
    				volverMenu();
    			}
    			else {
    	        	System.out.println("Introduzca un numero entre el 1 y el "+(cuentas.size()));
    	    	}
    		}
    		
    	}catch(Exception e) {
    		System.out.println("Introduzca un numero entre el 1 y el "+(cuentas.size()));
    	}
    	}
    	while (!flag);
    	return null;
    }
    public void mostrarInfoCuenta( Cuenta cuenta) {
        System.out.println("Nro de cuenta: "+cuenta.getNroCuenta()+"\n"+cuenta.getTipo()+"\n"+cuenta.getSaldo()+" "+cuenta.getMoneda());
    }
    public double montoADepositar(Cuenta cuenta) {
    	System.out.println("El saldo en esta cuenta es de "+cuenta.getSaldo()+" "+cuenta.getMoneda());
    	System.out.print("Introduzca el monto que desea depositar: ");
    	double monto = sn.nextDouble();
    	return monto;
    }
    public double montoARetirar(Cuenta cuenta) {
    	System.out.println("El saldo en esta cuenta es de "+cuenta.getSaldo()+" "+cuenta.getMoneda());
    	System.out.print("Introduzca el monto que desea retirar: ");
    	double monto = sn.nextDouble();
    	return monto;
    }
    public void volverMenu() {
    	Menu menu = new Menu(cliente, banco);
    	menu.mostrar();
    }
}

