package cz.czechitas.java2webapps.ukol5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

/**
 * Kontroler obsluhující registraci účastníků dětského tábora.
 */
@Controller
@RequestMapping("/")
public class RegistraceController {
  private final Random random = new Random();

  @GetMapping("/")
  public ModelAndView index() {
    ModelAndView maw = new ModelAndView("formular");
    maw.addObject("form", new RegistraceForm());
    return maw;
  }

  @PostMapping("/")
  public Object form(@ModelAttribute("form") RegistraceForm form, BindingResult bindingResult){
    if (bindingResult.hasErrors()){
      return "formular";
    }

    return new ModelAndView("rezervovano")
            .addObject("kod", Math.abs(random.nextInt()))
            .addObject("name", form.getName())
            .addObject("email", form.getEmail());
    }
  }

