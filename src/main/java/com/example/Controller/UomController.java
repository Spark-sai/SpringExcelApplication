package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Uom;
import com.example.service.IUomService;
import com.example.view.UomExcelView;

@Controller
@RequestMapping("/Uom")
public class UomController {
	
	@Autowired
	private IUomService service;
	
	@GetMapping("/register")
	public String UomRegister(Model model)
	{
		/*
		 * form backing object --> "uom" object name and new Uom(); class name
		 */
		model.addAttribute("uom", new Uom ());
		System.out.println("one");	
		return "UomRegister";
	}
	
    // Save  data
	@PostMapping("/save")
	public String SaveUom(@ModelAttribute Uom uom, Model model) {
		Integer id = service.SaveUom(uom);
		String message = "Uom is Saved  '" + id + "'";
		model.addAttribute("F1", message);
		/*
		 * form backing object --> "uom" object name and new Uom(); class name
		 */
		model.addAttribute("uom", new Uom ());
		return "UomRegister";
	}
	@GetMapping("/Excel")
	public ModelAndView ExcelData()
	{
		ModelAndView m=new ModelAndView();
		List<Uom> list=service.GetAllUom();
		m.setView(new UomExcelView());
		m.addObject("list", list);
		return m;
	}
}
