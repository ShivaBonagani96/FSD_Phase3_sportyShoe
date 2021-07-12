package com.sportyshoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportyshoes.ProductsService;
import com.sportyshoes.UserService;
import com.sportyshoes.entries.Products;
import com.sportyshoes.entries.User;


@Controller
public class LoginController {
	
    @Autowired
    private UserService userService;
    
    @Autowired
    private ProductsService productsService;
	
      
  @RequestMapping(value="/", method = RequestMethod.GET)
  public String printHello()
  {
          return("login");
  }
  
  
  @RequestMapping("/signup")
  public String save()
  {
          return "signup";
  }
  
  @RequestMapping(value="/register", method = RequestMethod.POST)
  public String saveUser(User user, Model model, @RequestParam(name="email") String email, BindingResult br)
  {
	  if(br.hasErrors())  {
 		 return "signup";
 	 }
	  userService.save(user);
	  model.addAttribute("save", email+"Registerd SuccessFully");
          return "users";
  }
  
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String handleLogin(
    		@RequestParam(value = "username", required = true) String username,
    		@RequestParam(value = "password", required = true) String password,

    		ModelMap model) { 
    	
    	User user;
    	try {
    		System.out.println("User: " + username);
    		System.out.println("Pass: " + password);
    		
    		user = userService.GetUserByName(username);
    		model.addAttribute("msg", "SuccessFully Logged In");
    	}
    	catch(Exception ex) {
    		model.addAttribute("message", "ERROR: Unknown user!");
    		return("login");
    	}
    	
    	if (userService.ConfirmUserPassword(user, password)) {
    		//TODO: Check user and password
    		//model.addAttribute("user", user);
    		model.addAttribute("message", "Success!");
    		return("users");
    	}
    	else {
    		model.addAttribute("message", "Invalid Password, Try again!");
    		return("login");
    	}
    }
   	
   
    
    @RequestMapping(value="/products", method = RequestMethod.GET)
    public String showProducts(ModelMap model)
    {
    	Iterable<Products> products = productsService.GetAllProducts();
     
    	model.addAttribute("products", products);
    	
    	return("products");
    }
    
    @RequestMapping("/addproducts")
    public String addProducts()
    {
    	
    	
    	return("addProducts");
    }
    @RequestMapping(value="saveproducts", method = RequestMethod.POST)
    public String saveProducts(ModelMap model, Products product)
    {
    	 
    	
    	productsService.SaveProduct(product);
    	Iterable<Products> products = productsService.GetAllProducts();

    	model.addAttribute("products", products);
    	
    	return("products");
    	 
    }
    
 
    
    @RequestMapping(value="/products", method = RequestMethod.POST)
	public String handleQuery(
			@RequestParam(value = "id", required = true) Integer id,
			ModelMap model) {
	
		
		try {
		//TODO: Handle empty or invalid UserId
			Products product = productsService.GetProductsById(id);
		
			model.addAttribute("products", product);
	
			return("products");
		}
		catch(Exception ex) {
			model.addAttribute("message", "ERROR: Unknown userid");
			return("products");
		}
	}

    
    @RequestMapping(value="/productdetailsedit", method = RequestMethod.GET)
	public String showProductsDetailsEdit(ModelMap model)
	{
		model.addAttribute("message", "Welcome!");
		return("productdetailsedit");
	}   


@RequestMapping(value="/productdetailsedit", method = RequestMethod.POST)
public String handleEdit(
		@RequestParam(value = "id", required = true) Integer id,
		@RequestParam(value = "product", required = true) String product,
		@RequestParam(value = "price", required = true) String price,
		@RequestParam(value = "quantity", required = true) String quantity,
		ModelMap model) {
	//TODO: Handle empty or invalid UserId
	try {
		Products products = productsService.GetProductsById(id);
	    
		products.setProduct(product);
		products.setPrice(price);
		products.setQuantity(quantity);
	
		productsService.EditProduct(products);
		model.addAttribute("message", "Product Edited Successfully");
	}
	catch (Exception ex) {
    	model.addAttribute("message", "Product Edit NOT Successful");

	}
	return("productdetailsedit");
}
    
    
    
    
    
    
}