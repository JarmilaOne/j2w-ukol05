package cz.czechitas.java2webapps.ukol5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
    public Object form(@ModelAttribute("form") @Valid RegistraceForm form, BindingResult bindingResult) {

        //Check age
       if (form.getAge() <= 9 || form.getAge() >= 15) {
            bindingResult.rejectValue("birthdate", "", "Věk dítěte musí být mezi 9 - 15 lety včetně.");
        }
        //Check minimum 2 sports
        if (form.getSporty().size() < 2) {
            bindingResult.rejectValue("sporty", "", "Vyberte, prosím, alespoň dva sporty!");
        }
        //Check sex
        if (form.getPohlavi().size() < 1) {
            bindingResult.rejectValue("pohlavi", "", "Vyberte, prosím, pohlaví!");
        }

        //Errors -> returns formular
        if (bindingResult.hasErrors()) {
            //Name check
            if (form.getName().equals("")) {
                bindingResult.rejectValue("name", "", "Zadejte, prosím, křestní jméno!");
            }
            //Surname check
            if (form.getSurname().equals("")) {
                bindingResult.rejectValue("surname", "", "Zadejte, prosím, příjmení!");
            }
            //Turnus check
            if (form.getTurnus().equals("")){
                bindingResult.rejectValue("turnus", "", "Vyberte, prosím, turnus!");

            }
            return "formular";
        }

        ModelAndView maw = new ModelAndView("rezervovano");
                maw.addObject("kod", Math.abs(random.nextInt()))
                .addObject("name", form.getName())
                .addObject("surname", form.getSurname());
                if (form.getPohlavi().equals("ZENA")){
                    maw.addObject("sex", "žena");
                }
                else{
                   maw.addObject("sex", "muž");
                }

                maw.addObject("sporty", form.getSporty())
                .addObject("turnus", form.getTurnus())
                .addObject("email", form.getEmail())
                .addObject("telefon", form.getPhone());
        return maw;
    }
}

