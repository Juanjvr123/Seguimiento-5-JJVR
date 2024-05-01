package model;

public class Controller {

	private User[] users;

	public Controller() {

		users = new User[10];
		testCases();

	}

	public void testCases() {

		users[0] = new User("1234", "John Smith", "Smithy");
		users[1] = new User("5678", "Pocahontas", "Pocah");
	}

	public String getUserList() {

		String msg = "";

		for (int i = 0; i < users.length; i++) {

			if (users[i] != null) {
				msg += "\n" + (i + 1) + ". " + users[i].getId() + " - " + users[i].getName();
			}

		}

		return msg;

	}

	public String listCategoryPremium(){
		
		Category[] arrangementCategory = Category.values();
		
		String list = "";
		
			for (int i = 0; i < arrangementCategory.length; i++){
				
				list += "\n" + (i + 1) + "- " + arrangementCategory[i];
				
			}
		
		return list;
		
	}

	public boolean registerPremiumUser(String id, String name, String nickname, int category) {
		Premium newPremium = new Premium(id, name, nickname, Category.values()[category - 1]);
		for (int i = 0; i < users.length; i++) {

			if (users[i] == null) {

				users[i] = newPremium;

				return true;

			} else if (users[i].getId().equals(id)) {

				return false;

			}

		}
		return false;
	}

	public boolean registerRegularUser(String id, String name, String nickname) {

		Regular newRegular = new Regular(id, name, nickname);

		for (int i = 0; i < users.length; i++) {

			if (users[i] == null) {

				users[i] = newRegular;

				return true;

			} else if (users[i].getId().equals(id)) {

				return false;

			}

		}

		return false;

	}

	public boolean validateUser(int i){
		User u = users[i];
		if(u != null && u instanceof Premium){
			return true;	
		}
		return false;
	}


	public boolean editPremiumUser(String name, int userPosition, int category) {
		Premium userP = (Premium) users[userPosition];
		userP.setName(name);
		if(category > 0 && category < 4){
			userP.setCategory(Category.values()[category - 1]);
			return true;
		}
		return false;		
	}

	public boolean editRegularUser(String name, int userPosition) {
		
		if(users[userPosition] != null){
			users[userPosition].setName(name);
			return true;
		}
		return false;
	}

	public boolean deleteUser(int userPosition) {

		users[userPosition] = null;

		if(users[userPosition] != null){

			return false;

		}
		
		return true;

	}

	public String getUserInfo(int option) {
		
		if(users[option] instanceof Premium){

			Premium userP = (Premium) users[option];

			return userP.toStringPremium();

		}else{
			return users[option].toString();
		}

	}

	public String getAllUserInfo() {
		String msg = "";

		for(int i = 0; i<users.length; i++){
			if(users[i]!=null){
				msg += getUserInfo(i) + "\n -------------------- \n";
			}
		}		

		return msg;
	}

	public String countAllUserQuantity(){
		
		String msg = "";
		int counterPremium = 0;
		int counterRegular = 0;
		int counterGold = 0;
		int counterPlatinum = 0;
		int counterDiamond = 0;
		

		for(int i = 0 ;i <  users.length;i++){

			if(users!= null){
				
				if(users[i] instanceof Premium){
					
					counterPremium++;
					Premium userP = (Premium) users[i];
					switch (userP.getCategory()) {
						case ORO:
							counterGold++;
							break;
						case PLATA:
							counterPlatinum++;
							break;
						case DIAMANTE:
							counterDiamond++;
							break;					
					}
				}else if(users[i] instanceof Regular){
					counterRegular++; 
				}

			}

			
		}

		msg += "The inventory is composed like this:" +
				   "\nNumber of Premium users: "+counterPremium+
				   "\nNumber of gold premium users: "+counterGold+
				   "\nNumber of platinum premium users: "+counterPlatinum+
				   "\nNumber of diamond premium users: "+counterDiamond+
				   "\nNumber of Regular users: "+counterRegular;

		return msg;

	}
	
}
