package com.example.crm;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.crm.entity.Customer;
import com.example.crm.entity.FullName;
import com.example.crm.entity.Identity;
import com.example.crm.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = CustomerServiceApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class CustomerServiceApplicationTests {
	@Autowired
	private MockMvc mvc;
	@MockBean
	private CustomerRepository customerRepository;
	@Autowired
	private ObjectMapper mapper;

	@Test
	public void addCustomer_isOk() throws Exception {
		Identity identity = new Identity("76953199290");
		Customer jack = new Customer(identity, new FullName("jack", "bauer"), "jack.bauer@example.com", 1956);
		Mockito.when(customerRepository.existsById(identity)).thenReturn(false);
		Mockito.when(customerRepository.save(jack)).thenReturn(jack);
		mvc.perform(post("/customers").content(mapper.writeValueAsString(jack)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void getTwoCustomers_thenReturnsJson() throws Exception {
		Customer jack = new Customer(new Identity("76953199290"), new FullName("jack", "bauer"),
				"jack.bauer@example.com", 1956);
		Customer kate = new Customer(new Identity("48437053206"), new FullName("kate", "austen"),
				"kate.austen@example.com", 1985);
		Pageable pageable = PageRequest.of(0, 2);
		Page<Customer> page = Mockito.mock(Page.class);
		Mockito.when(page.getContent()).thenReturn(Arrays.asList(jack, kate));
		Mockito.when(customerRepository.findAll(pageable)).thenReturn(page);
		mvc.perform(get("/customers?pageNo=0&pageSize=2").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(2)))
				.andExpect(jsonPath("$[0].tckimlik.no", is("76953199290")))
				.andExpect(jsonPath("$[1].tckimlik.no", is("48437053206")));
	}

}
