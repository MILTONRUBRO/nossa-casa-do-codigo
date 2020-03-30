package br.com.devmos.apicdc.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Cookies {
	
	/**
	 * 
	 * @param key chave gerada para o cookie
	 * @param carrinho carrinho de compra que sera serializado
	 * @param response
	 */
	public void writeAsJson(String key, Carrinho carrinho, HttpServletResponse response) {
		Cookie cookie;
		try {
			cookie = new Cookie(key, new ObjectMapper().writeValueAsString(carrinho));
			cookie.setHttpOnly(true);
			response.addCookie(cookie);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}

	}

}
