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
@RequestMapping("/ldt")
public class RegistraceController {
  private final Random random = new Random();

  @GetMapping("")
  public ModelAndView index() {
    ModelAndView maw = new ModelAndView("/ldt/formular");
    maw.addObject("form", new RegistraceForm());
    return maw;
  }

  @PostMapping("")
  public Object form(@ModelAttribute("form") RegistraceForm form, BindingResult bindingResult){
    if (bindingResult.hasErrors()){
      return "/ldt/formular";
    }

    return new ModelAndView("/ldt/rezervovano")
            .addObject("kod", Math.abs(random.nextInt()))
            .addObject("name", form.getName())
            .addObject("email", form.getEmail());
    }
  }

