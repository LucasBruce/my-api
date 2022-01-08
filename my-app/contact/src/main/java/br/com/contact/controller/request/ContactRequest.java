package br.com.contact.controller.request;

import lombok.Data;
//import lombok.Getter;

@Data
public class ContactRequest {

    private String nome;
    private String email;
    private String phone;

}
