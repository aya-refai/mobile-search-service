package com.axiom.search.api;

import com.axiom.search.api.boundary.helper.dto.MobileDto;
import com.axiom.search.api.boundary.helper.dto.MobileSearchCriteria;
import com.axiom.search.api.control.SearchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SearchRestApiTest {

    @MockBean
    SearchService searchService;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void testSearch() throws Exception {
        lenient().when(searchService.searchMobiles(any())).thenReturn(buildMobileDtoList());
        mockMvc.perform(get("/mobile/search")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    void testSearchWithInvalidSearchCriteria_InvalidId() throws Exception {
        mockMvc.perform(get("/mobile/search")
                        .param("id", "invalid")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testSearchWithInvalidSearchCriteria_InvalidPrice() throws Exception {
        mockMvc.perform(get("/mobile/search")
                .param("priceEur", "invalid")
                .contentType(APPLICATION_JSON)).andExpect(status().isBadRequest());
    }

    private List<MobileDto> buildMobileDtoList() {
        return Arrays.asList(new MobileDto());
    }

    private MobileSearchCriteria buildInvalidSearchCriteria() {
        MobileSearchCriteria searchCriteria = new MobileSearchCriteria();
        searchCriteria.setId(null);
        return searchCriteria;
    }
}