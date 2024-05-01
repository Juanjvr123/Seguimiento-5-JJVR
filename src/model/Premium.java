package model;

public class Premium extends User{

    private Category category;

    public Premium(String id, String name, String nickname, Category category) {
        super(id, name, nickname);
		this.category = category;
	}

    public String toStringPremium(){
        return super.toString() + "\n" + category;
    }

    public void setCategory(Category newCategory){

        this.category = newCategory;

    }

    public Category getCategory(){
        return category;
    }

}
