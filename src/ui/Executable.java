package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

	private Scanner reader;
	private Controller rXSystem;

	public Executable() {

		reader = new Scanner(System.in);
		rXSystem = new Controller();
	}

	public static void main(String[] args) {

		Executable ejecutable = new Executable();
		ejecutable.menu();

	}

	private void menu() {

		System.out.println("Bienvenido a ReaderX!");

		boolean flag = false;

		while (!flag) {

			System.out.println("MENU PRINCIPAL");
			System.out.println("1. Registrar usuario premium");
			System.out.println("2. Registrar usuario regular");
			System.out.println("3. Modificar usuario");
			System.out.println("4. Borrar usuario");
			System.out.println("5. Consultar informacion de un usuario");
			System.out.println("6. Informacion de todos los usuarios registrados");
			System.out.println("7. Reporte de usuarios registrados");
			System.out.println("8. Salir");
			int option = reader.nextInt();

			switch (option) {

			case 1:
				registerPremiumUser();
				break;

			case 2:
				registerRegularUser();
				break;
			case 3:
				modifyUser();
				break;
			case 4:
				deleteUser();
				break;
			case 5:
				showUserInfo();
				break;
			case 6:
				showAllUserInfo();
				break;
			case 7:
				showAllUserQuantity();
				break;
			case 8:
				flag = true;
				break;
			default:
				System.out.println("Opcion invalida");
				break;

			}

		}

	}

	private void registerPremiumUser() {

		System.out.println("Digite a continuacion la informacion de un nuevo usuario");

		// Limpieza de buffer
		reader.nextLine();

		System.out.println("Digite la cedula");
		String id = reader.nextLine();

		System.out.println("Digite el nombre");
		String name = reader.nextLine();

		System.out.println("Elija la categoria");
		System.out.println(rXSystem.listCategoryPremium());
		int category = reader.nextInt();

		reader.nextLine();

		System.out.println("Digite el nickname");
		String nickname = reader.nextLine();

		if (rXSystem.registerPremiumUser(id, name, nickname, category)) {

			System.out.println("Usuario registrado exitosamente");

		} else {

			System.out.println("Memoria llena, no se pudo registrar el Usuario");
		}
	}

	private void registerRegularUser() {

		System.out.println("Digite a continuacion la informacion de un nuevo usuario");

		// Limpieza de buffer
		reader.nextLine();

		System.out.println("Digite la cedula");
		String id = reader.nextLine();

		System.out.println("Digite el nombre");
		String name = reader.nextLine();

		System.out.println("Digite el nickname");
		String nickname = reader.nextLine();

		if (rXSystem.registerRegularUser(id, name, nickname)) {

			System.out.println("Usuario registrado exitosamente");

		} else {

			System.out.println("Memoria llena, no se pudo registrar el Usuario");
		}
	}

	private void modifyUser() {

		String query = rXSystem.getUserList();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {

			System.out.println("\nEste es el listado de usuarios registrados en el sistema");

			System.out.println(query);

			System.out.println("\nSeleccione el usuario a editar");
			int option = reader.nextInt();

			reader.nextLine();

			System.out.println("Seleccione el nuevo nombre");
			String name = reader.nextLine();
			
			if(rXSystem.validateUser(option-1)){
					
				System.out.println("Choose the new category");
				System.out.println(rXSystem.listCategoryPremium());
				int category = reader.nextInt();

				if(rXSystem.editPremiumUser(name, option-1, category)){

					System.out.println("Succesfull user modification");

				}else{

					System.out.println("unsuccesfull user modification");
				}

			}else{

				if(rXSystem.editRegularUser(name, option-1)){

					System.out.println("Succesfull user modification");

				}else{

					System.out.println("unsuccesfull user modification");
				}

			}
		}

	}

	private void deleteUser() {

		String query = rXSystem.getUserList();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {

			System.out.println("\nEste es el listado de usuarios registrados en el sistema");

			System.out.println(query);

			System.out.println("\nSeleccione el usuario a borrar");

			int option = reader.nextInt();

			if (rXSystem.deleteUser(option - 1)) {

				System.out.println("\nUsuario borrado exitosamente");

			} else {

				System.out.println("\nError, el usuario no pudo ser borrado");
			}

		}

	}

	private void showUserInfo() {

		String query = rXSystem.getUserList();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {

			System.out.println("\nEste es el listado de usuarios registrados en el sistema");

			System.out.println(query);

			System.out.println("\nSeleccione el usuario a consultar");

			int option = reader.nextInt();

			String query2 = rXSystem.getUserInfo(option-1);

			if (query2.equals("")) {
				System.out.println("La operación no pudo realizarse");
			} else {
				System.out.println(query2);
			}

		}

	}

	private void showAllUserInfo() {

		System.out.println("Esta es la informacion registrada en el sistema");

		String query = rXSystem.getAllUserInfo();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {
			System.out.println(query);
		}

	}

	public void showAllUserQuantity(){

		System.out.println(rXSystem.countAllUserQuantity());

	}

}