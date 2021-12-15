package com.cheryomushkin.petclinic;

import com.cheryomushkin.petclinic.transport.owners.AddOwnerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MVCTests {
    final MockMvc mockMvc;
    final ObjectMapper objectMapper;

    @Autowired
    public MVCTests(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }

    @Test
    public void testValidation() throws Exception {
        AddOwnerDto ownerDto = new AddOwnerDto(
                        "Гарри", "Поттер",
                        "ул. Тисовая 4", "Little Winging", "");
        mockMvc.perform(post("/petclinic/api/owners/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ownerDto))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testOrElseThrow() throws Exception {
        mockMvc.perform(delete("/petclinic/api/owners/100").accept(MediaType.ALL))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
}
