package com.spring.mvc.inter.format.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc.inter.format.dtoclass.CommunicationDto;
import com.spring.mvc.inter.format.dtoclass.DtoClass;
import com.spring.mvc.inter.format.dtoclass.Phone;

@Controller
public class RegPageController {

	@RequestMapping("/")
	public String home(@ModelAttribute("RegPage")DtoClass dto) {
		System.out.println("Inside home page controller");
		Phone phone=new Phone();
		phone.setCountrycode("91");
		phone.setNumber("11111111");
		CommunicationDto comdto=new CommunicationDto();
		comdto.setPhone(phone);
		dto.setComdto(comdto);
		return "home-page";
	}
	
	@RequestMapping("/processing")
	public String result(@Valid @ModelAttribute("RegPage")DtoClass dto,BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("my page has errors");
			List<ObjectError> allErrors = result.getAllErrors();
			for(ObjectError err:allErrors) {
				System.out.println(err);
			}
			return "home-page";
		}
		return "res-page";
	}
}
