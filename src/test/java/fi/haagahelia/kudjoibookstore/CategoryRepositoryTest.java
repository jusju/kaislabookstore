package fi.haagahelia.kudjoibookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import fi.haagahelia.kudjoibookstore.domain.Category;
import fi.haagahelia.kudjoibookstore.domain.CategoryRepository;


@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryRepositoryTest {
/* 
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void findByNameShouldReturnCategory() {
        List<Category> categories = categoryRepository.findByName("Fiction");
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Fiction");
    }
    
    @Test
    public void createNewCategory() {
        Category category = new Category(null, "New Category", null);
        categoryRepository.save(category);
        assertThat(category.getId()).isNotNull();
    }    
    
    @Test
    public void deleteCategory() {
        List<Category> categories = categoryRepository.findByName("Non-Fiction");
        Category category = categories.get(0);
        categoryRepository.delete(category);
        List<Category> newCategories = categoryRepository.findByName("Non-Fiction");
        assertThat(newCategories).hasSize(0);
    }
    */
}
