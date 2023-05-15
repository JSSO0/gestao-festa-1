package com.algaworks.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.access.prepost.PreAuthorize;


import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.algaworks.festa.model.OrdemModel;
import com.algaworks.festa.repository.OrdemRepository;

@Controller
public class OrdemController {

    @Autowired
    private OrdemRepository ordemRepository;

    @GetMapping("/ordem")
    public ModelAndView listar(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("ordem");
        modelAndView.addObject("ordemrepository", ordemRepository.findAll());
        modelAndView.addObject("ordem", new OrdemModel());
        return modelAndView;
        /*
         * if (request.getSession().getAttribute("cadastroAcessado") != null) {
         * 
         * } else {
         * return new ModelAndView("redirect:/cadastro");
         * }
         */
        // return modelAndView;
    }

    @PostMapping("/ordem")
    public String salvar(@ModelAttribute("ordem") OrdemModel ordem) {
        // salva os dados do formulário no banco de dados usando o repositório
        ordemRepository.save(ordem);
        // redireciona para a página "ordem"
        return "redirect:/ordem";
    }

    @GetMapping("/cadastro")
    public ModelAndView Cadastro() {

        ModelAndView modelAndView = new ModelAndView("cadastro");
        modelAndView.addObject("ordemrepository", ordemRepository.findAll());
        modelAndView.addObject("ordem", new OrdemModel());

        return modelAndView;
    }
    
      @PostMapping("/cadastro")
      public String cadastrar(@ModelAttribute("cadastro") OrdemModel
      ordem, @RequestParam("matricula") String matricula,
      RedirectAttributes redirectAttributes) {
      
      Optional<OrdemModel> optional = Optional.ofNullable(ordem);
      
      if (optional.isPresent()) {
      redirectAttributes.addFlashAttribute("ordemrepository", optional.get());
      // redirectAttributes.addFlashAttribute("cadastroAcessado", true);
      return "redirect:/ordem";
      } else {
      // matrícula não existe no banco de dados
      // salvar no banco de dados
      ordem.setMatricula(matricula);
      ordemRepository.save(ordem);
      redirectAttributes.addFlashAttribute("ordemrepository", ordem);
      // redirectAttributes.addFlashAttribute("cadastroAcessado", true);
      return "redirect:/ordem";
      }
     }
     
/** 
    @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute("cadastro") OrdemModel ordem,
            RedirectAttributes redirectAttributes) {
        // salva os dados do formulário no banco de dados usando o repositório
        ordemRepository.save(ordem);
        redirectAttributes.addFlashAttribute("ordemrepository", ordem);
        redirectAttributes.addFlashAttribute("cadastroAcessado", true);
        // redireciona para a página "ordem"
        return "redirect:/ordem";
    }*/

    @GetMapping("/logout")
    @PreAuthorize("isAuthenticated()")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login";
    }
}