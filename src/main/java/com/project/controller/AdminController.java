package com.project.controller;

import org.springframework.ui.Model;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.entity.Category;
import com.project.service.CategoryService;

@Controller
public class AdminController {
	private CategoryService cservice;
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/admin/categories")
	public String categorypage(Model model) {
		List<Category> list = cservice.getAll();
		model.addAttribute("categories", list);
		return "categories";
	}
	
	@GetMapping("/admin/categories/add")
	public String AddCategory(Model model) {
		Category c = new Category();
		model.addAttribute("category", c);
		return "categoriesAdd";
	}
	
	@PostMapping("/admin/categories/add")
	public String postAddCategory(@ModelAttribute("category")Category c) {
		cservice.saveCategory(c);
		return "redirect:/admin/categories";
	}
	
	
}
