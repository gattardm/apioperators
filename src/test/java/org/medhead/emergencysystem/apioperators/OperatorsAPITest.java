package org.medhead.emergencysystem.apioperators;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OperatorsAPITest {
    @Autowired
    public MockMvc mockMvc;

    @Test
    public void testConnexion() throws Exception {
        mockMvc.perform(get("/operators")).andExpect(status().isOk());
    }

    @Test
    public void testGetOperator1Creation() throws Exception {
        mockMvc.perform(get("/operators")).andExpect(jsonPath("$[0].name", is("Operator 1")));
        mockMvc.perform(get("/operators")).andExpect(jsonPath("$[0].available", is("true")));
    }

    @Test
    public void testGetOperator2Creation() throws Exception {
        mockMvc.perform(get("/operators")).andExpect(jsonPath("$[1].name", is("Operator 2")));
        mockMvc.perform(get("/operators")).andExpect(jsonPath("$[1].available", is("true")));
    }

    @Test
    public void testGetOperator3Creation() throws Exception {
        mockMvc.perform(get("/operators")).andExpect(jsonPath("$[2].name", is("Operator 3")));
        mockMvc.perform(get("/operators")).andExpect(jsonPath("$[2].available", is("true")));
    }

    @Test
    public void testGetOperator4Creation() throws Exception {
        mockMvc.perform(get("/operators")).andExpect(jsonPath("$[3].name", is("Operator 4")));
        mockMvc.perform(get("/operators")).andExpect(jsonPath("$[3].available", is("true")));
    }
}
