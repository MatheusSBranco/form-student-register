package com.cadastro.aluno.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cadastro.aluno.dto.FormDto;
import com.cadastro.aluno.model.Form;
import com.cadastro.aluno.repository.FormRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class FormController {

    private final FormRepository formRepository;

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public FormController(FormRepository formRepository, EntityManager entityManager){
        this.formRepository = formRepository;
        this.entityManager = entityManager;
    }
    
    @GetMapping("/cadastro")
    public ModelAndView home(ModelAndView mv, HttpSession session){
        FormDto formDto = (FormDto) session.getAttribute("form");
        if (formDto == null){
            formDto = new FormDto();
        }

        mv.addObject("form", formDto);
        mv.addObject("gradeOptions", gradeOptions());
        mv.addObject("shiftOptions", shiftOptions());
        mv.addObject("extraOptions", extraOptions());
        return mv;
    }

    @PostMapping("/cadastro")
    public String cadastro(@Valid FormDto formDto, BindingResult bindingResult, RedirectAttributes redirectAttributes , HttpSession session){

        if (bindingResult.hasErrors()) {
            session.setAttribute("form", formDto);
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/error";
        }        

            Form form = Form.dtoToForm(formDto);
            form.setName(formDto.getName());
            form.setBirthdate(formDto.getBirthdate());
            form.setMother(formDto.getMother());
            form.setFather(formDto.getFather());
            form.setDdd(formDto.getDdd());
            form.setPhone(formDto.getPhone());
            form.setEmail(formDto.getEmail());
            form.setGrade(formDto.getGrade());
            form.setShift(formDto.getShift());
            form.setExtracurricular(formDto.getExtracurricular());
            formRepository.save(form);
            
            session.removeAttribute("form");

        return "redirect:/lista";
    }

    @GetMapping("/lista")
    public ModelAndView lista(){
        ModelAndView mv = new ModelAndView("lista");
        mv.addObject("forms", formRepository.findAll());
        return mv;
    }

    @GetMapping("/error")
    public String error(ModelAndView mv, BindingResult bindingResult) {
        mv.addObject("errors", bindingResult.getAllErrors());
        return "error";
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
