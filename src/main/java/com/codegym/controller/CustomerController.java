package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.serviece.servieceCustomer.CustomerServiece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerServiece customerServiece;
    @GetMapping("/create-customer")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }
    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer){
        ModelAndView modelAndView = new ModelAndView("create");
        customerServiece.save(customer);
        modelAndView.addObject("customer",new Customer());
        modelAndView.addObject("message","them thanh cong");
        return modelAndView;
    }
    @GetMapping("/")
    public ModelAndView listCustomers(){
        List <Customer> customers = customerServiece.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Customer customer = customerServiece.findById(id);
        if(customer!=null){
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("customer",customer);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }
    @PostMapping("/edit-customer")
    public  ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer){
        customerServiece.save(customer);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("customer",customer);
        modelAndView.addObject("message","sua thanh cong");
        return modelAndView;

    }
    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Customer customer = customerServiece.findById(id);
        if(customer!=null){
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("customer",customer);
            return modelAndView;
        }else {
            ModelAndView modelAndView=new ModelAndView("error");
            return modelAndView;
        }

    }
    @PostMapping("/delete-customer")
    public  String delete(@ModelAttribute("customer") Customer customer){
        customerServiece.remove(customer.getId());
        return "redirect:/";
    }

}
