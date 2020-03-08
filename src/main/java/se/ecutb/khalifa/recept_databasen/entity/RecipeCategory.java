package se.ecutb.khalifa.recept_databasen.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
public class RecipeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String category;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
    )
    @JoinTable(
            name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")

    )
    private List<Recipe> recipes;

    public RecipeCategory(String category, List<Recipe> recipes) {
        this.categoryId = 0;
        this.category = category;
        this.recipes = recipes;
    }

    public RecipeCategory() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return categoryId == that.categoryId &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, category);
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "categoryId=" + categoryId +
                ", category='" + category + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}
