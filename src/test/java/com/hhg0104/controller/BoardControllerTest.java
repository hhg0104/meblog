package com.hhg0104.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hhg0104.entity.UserInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BoardControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private MockHttpSession mockSession;

	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

	@Before
	public void init() {
		UserInfo userInfo = new UserInfo();
		userInfo.setIdx(1);

		mockSession.setAttribute("user", userInfo);
	}

	/**
	 * 특정 사용자의 모든 게시판 정보 목록을 반환하는 API 테스트
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetBoardsByUserIdx() throws Exception {

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/boards");
		builder.session(mockSession);

		MvcResult result = mockMvc.perform(builder).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("\"userIdx\":1"))).andReturn();

		String responseResult = result.getResponse().getContentAsString();
		System.out.println(GSON.toJson(responseResult));
	}

	/**
	 * 특정 모든 게시판 정보을 반환하는 API 테스트
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetBoardInfo() throws Exception {

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/boards/2");
		builder.session(mockSession);

		MvcResult result = mockMvc.perform(builder).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("\"idx\":2")))
				.andExpect(content().string(containsString("\"userIdx\":1"))).andReturn();

		String responseResult = result.getResponse().getContentAsString();
		System.out.println(GSON.toJson(responseResult));
	}
}
