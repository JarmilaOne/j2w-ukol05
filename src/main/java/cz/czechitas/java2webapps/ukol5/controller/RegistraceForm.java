package cz.czechitas.java2webapps.ukol5.controller;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;
import java.util.EnumSet;
import java.util.Objects;

public class RegistraceForm {
    @NotBlank (message = "")
    private String name;
    @NotBlank (message = "")
    private String surname;
    @NotNull (message = "")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthdate;

    @NotEmpty (message = "")
    private EnumSet<Pohlavi> pohlavi = EnumSet.noneOf(Pohlavi.class);
    @NotEmpty (message = "")
    private EnumSet<Sport> sporty = EnumSet.noneOf(Sport.class);

    @NotBlank (message = "")
    private String turnus;

    @Email (message = "")
    private String email;

    private Integer phone;

    public EnumSet<Sport> getSporty() {
        return sporty;
    }

    public void setSporty(EnumSet<Sport> sporty) {
        this.sporty = Objects.requireNonNull(sporty);
    }

    public EnumSet<Pohlavi> getPohlavi() {
        return pohlavi;
    }

    public void setPohlavi(EnumSet<Pohlavi> pohlavi) {
        this.pohlavi = Objects.requireNonNull(pohlavi);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getTurnus() {
        return turnus;
    }

    public void setTurnus(String turnus) {
        this.turnus = turnus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    //Age
    public int getAge() {
        if (birthdate != null) {
            Period period = birthdate.until(LocalDate.now());
            return period.getYears();
        }
        return 0;
    }

}
