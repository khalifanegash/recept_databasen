package se.ecutb.khalifa.recept_databasen.entity;

import javax.persistence.*;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ingredient_name", unique = true)
    private String ingredientName;

    public Ingredient(int id, String ingredientName) {
        this.id = id;
        this.ingredientName = ingredientName;
    }
    public Ingredient( String ingredientName) {
        this(0,ingredientName);

    }

    public Ingredient() {
    }

    public int getId() {
        return id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", ingredientName='" + ingredientName + '\'' +
                '}';
    }
}
