package com.cadastro.aluno.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cadastro.aluno.model.Form;

import jakarta.validation.Valid;

@Controller
public class FormController {

    List<Form> forms = new ArrayList<>();
    
    @GetMapping("/cadastro")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("cadastro");
        mv.addObject("form", new Form());
        mv.addObject("gradeOptions", gradeOptions());
        mv.addObject("shiftOptions", shiftOptions());
        mv.addObject("extraOptions", extraOptions());
        return mv;
    }

    @PostMapping("/cadastro")
    public String cadastro(@Valid Form form, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "cadastro";
        }

        if(form.getId() != null) {
            Form formFind = forms.stream().filter(formItem -> form.getId().equals(formItem.getId())).findFirst().get();

            forms.set(forms.indexOf(formFind), form);
        } else {
            Long id = forms.size() + 1L;
            forms.add(new Form(id, form.getName(), form.getBirthdate(), form.getMother(), form.getFather(), form.getDdd(), form.getPhone(), form.getEmail(), form.getGrade(), form.getShift(), form.getExtracurricular()));
        }        

        return "redirect:/lista";
    }

    @GetMapping("/lista")
    public ModelAndView lista(){
        ModelAndView mv = new ModelAndView("lista");
        mv.addObject("forms", forms);
        return mv;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("cadastro");
        Form formFind = forms.stream().filter(form -> id.equals(form.getId())).findFirst().get();
        mv.addObject("form", formFind);
        return mv;
    }

    @ModelAttribute("gradeOptions")
    public List<String> gradeOptions() {
        return Arrays.asList("Pré-escolar","Fundamental", "Médio");
    }

    @ModelAttribute("extraOptions")
    public List<String> extraOptions() {
        return Arrays.asList("Informatica","Musica", "Ballet", "Pintura", "Judo", "Futebol");
    }

    @ModelAttribute("shiftOptions")
    public List<String> shiftOptions() {
        return Arrays.asList("Manhã", "Tarde");
    }

}
