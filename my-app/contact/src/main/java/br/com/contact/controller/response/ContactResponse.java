package br.com.contact.controller.response;

import lombok.Builder;
import lombok.Data;
//import lombok.Getter;
@Builder
@Data
public class ContactResponse {

    private Long id;
    private String nome;
    private String email;
    private String phone;

}
