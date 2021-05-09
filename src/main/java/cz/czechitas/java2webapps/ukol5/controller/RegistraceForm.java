package cz.czechitas.java2webapps.ukol5.controller;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.EnumSet;

public class RegistraceForm {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotNull
    private LocalDate birthdate;

    @NotNull
    private EnumSet<Pohlavi> pohlavi;
    @NotNull
    private EnumSet<Sport> sporty;

    @NotBlank
    private String turnus;
    @Email
    private String email;

    private Integer phone;

    public EnumSet<Sport> getSporty() {
        return sporty;
    }

    public void setSporty(EnumSet<Sport> sporty) {
        this.sporty = sporty;
    }

    public EnumSet<Pohlavi> getPohlavi() {
        return pohlavi;
    }

    public void setPohlavi(EnumSet<Pohlavi> pohlavi) {
        this.pohlavi = pohlavi;
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

    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
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
}
