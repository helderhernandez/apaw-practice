package es.upm.miw.apaw_practice.adapters.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(HelderResource.HELDER)
public class HelderResource {

	static final String HELDER = "/helder";
	static final String SEARCH = "/search";

	@GetMapping(SEARCH)
	public String search() {
		return "Hello world";
	}

}
