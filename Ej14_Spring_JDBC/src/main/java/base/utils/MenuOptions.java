package base.utils;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;

import base.persistence.controller.ClienteController;
import base.persistence.controller.PedidoController;
import base.persistence.entity.Cliente;
import base.persistence.entity.Pedido;

public class MenuOptions {

	public static void altaCliente(ApplicationContext context, Scanner sc) {
		ClienteController clienteController = context.getBean("clienteController", ClienteController.class);
		
		System.out.println("Introduce nombre:");
		String nombre = sc.nextLine();
		
		System.out.println("Introduce edad:");
		int edad = sc.nextInt();
		
		Cliente c = context.getBean("cliente", Cliente.class);
		c.setNombre(nombre);
		c.setEdad(edad);
		
		int rows = clienteController.crear(c);
		if(rows > 0) {
			System.out.println("Se ha registrado correctamente el cliente");
		} else {
			System.out.println("No se ha podido registrar el cliente");
		}
	}
	
	public static void bajaCliente(ApplicationContext context, Scanner sc) {
		ClienteController clienteController = context.getBean("clienteController", ClienteController.class);
		
		System.out.println("Introduce ID:");
		int id = sc.nextInt();
		
		int rows = clienteController.eliminar(id);
		if(rows > 0) {
			System.out.println("Se ha eliminado correctamente el cliente con ID " + id);
		} else {
			System.out.println("No se ha podido eliminar el cliente");
		}
	}
	
	public static void modificarCliente(ApplicationContext context, Scanner sc) {
		ClienteController clienteController = context.getBean("clienteController", ClienteController.class);
		
		System.out.println("Introduce nombre:");
		String nombre = sc.nextLine();
		
		System.out.println("Introduce edad:");
		int edad = sc.nextInt();
		
		System.out.println("Introduce ID:");
		int id = sc.nextInt();
		
		Cliente c = context.getBean("cliente", Cliente.class);
		c.setId(id);
		c.setNombre(nombre);
		c.setEdad(edad);
		
		int rows = clienteController.modificar(c);
		if(rows > 0) {
			System.out.println("Se ha modificado corectamente el cliente con ID " + id);
		} else {
			System.out.println("No se ha podido modificar el cliente");
		}
	}
	
	public static void clienteById(ApplicationContext context, Scanner sc) {
		ClienteController clienteController = context.getBean("clienteController", ClienteController.class);
		
		System.out.println("Introduce ID:");
		int id = sc.nextInt();
		
		Cliente c = clienteController.getById(id);
		if(c != null) {
			System.out.println(c);
		} else {
			System.out.println("No existe ese cliente");
		}
	}
	
	public static void clienteByName(ApplicationContext context, Scanner sc) {
		ClienteController clienteController = context.getBean("clienteController", ClienteController.class);
		
		System.out.println("Introduce nombre:");
		String nombre = sc.nextLine();
		
		List<Cliente> listClientes = clienteController.getByName(nombre);
		if(listClientes != null) {
			for (Cliente cliente : listClientes) {
				System.out.println(cliente);
			}
		} else {
			System.out.println("No existe ese cliente");
		}
	}
	
	public static void addPedidoByClientId(ApplicationContext context, Scanner sc) {
		PedidoController pedidoController = context.getBean("pedidoController", PedidoController.class);
		
		System.out.println("Introduce importe:");
		int importe = sc.nextInt();
		
		System.out.println("Introduce ID de cliente:");
		int id = sc.nextInt();
		
		Pedido p = context.getBean("pedido", Pedido.class);
		p.setImporte(importe);
		p.setId_cliente(id);
		
		int rows = pedidoController.addPedidoByClientId(p);
		if(rows > 0) {
			System.out.println("Se ha registrado corectamente el pedido para cliente con ID " + id);
		} else {
			System.out.println("No se ha podido registrar el pedido");
		}
	}
	
	public static void getPedidosByClientId(ApplicationContext context, Scanner sc) {
		PedidoController pedidoController = context.getBean("pedidoController", PedidoController.class);
		
		System.out.println("Introduce ID de cliente:");
		int id = sc.nextInt();
		
		List<Pedido> listPedidos = pedidoController.getPedidosByClientId(id);
		if(listPedidos != null) {
			for (Pedido pedido : listPedidos) {
				System.out.println(pedido);
			}
		} else {
			System.out.println("No existe ese ID");
		}
	}
	
}
