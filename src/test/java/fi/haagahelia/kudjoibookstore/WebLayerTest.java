package fi.haagahelia.kudjoibookstore;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest 
@AutoConfigureMockMvc
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void TestBooklistAsUser() throws Exception {
        this.mockMvc.perform(get("/booklist")).andDo(print())
        .andExpect(status().isOk())
        .andExpect(model().attributeExists("books"))
        .andExpect(view().name("booklist"));
    }

    @Test
    @WithMockUser(username = "admid", roles = {"ADMIN"})
    public void TestBooklistAsAdmin() throws Exception {
        this.mockMvc.perform(get("/booklist")).andDo(print())
        .andExpect(status().isOk())
        .andExpect(model().attributeExists("books"))
        .andExpect(view().name("booklist"));
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void TestAddAsUser() throws Exception {
        this.mockMvc.perform(get("/addbook")).andDo(print())
        .andExpect(status().isOk())
        .andExpect(model().attributeExists("book"))
        .andExpect(model().attributeExists("categories"))
        .andExpect(view().name("addbook"));
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void TestSaveAsUser() throws Exception {
        this.mockMvc.perform(post("/books/save")).andDo(print())
        .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void TestEditBookAsUser() throws Exception {
        this.mockMvc.perform(get("/edit/1")).andDo(print())
        .andExpect(status().isOk())
        .andExpect(model().attributeExists("book"))
        .andExpect(model().attributeExists("categories"))
        .andExpect(view().name("editbook"));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void TestDeleteBookAsAdmin() throws Exception {
        this.mockMvc.perform(get("/delete/1")).andDo(print())
        .andExpect(status().is3xxRedirection());

    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void TestFindBooKById() throws Exception {
        this.mockMvc.perform(get("/book/1")).andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("title")));

    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void TestLogin() throws Exception {
        this.mockMvc.perform(get("/login")).andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("login")));

    }
}

