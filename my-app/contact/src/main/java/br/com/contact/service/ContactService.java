package br.com.contact.service;

import br.com.contact.controller.request.ContactRequest;
import br.com.contact.controller.response.ContactResponse;
import br.com.contact.model.Contact;

import java.util.List;

public interface ContactService {

    public void createContact(ContactRequest request);
    public void removeContact(Long id);
    public ContactResponse getContactByName(String nome);
    public ContactResponse getContactById(Long id);
    public ContactResponse getUpdateContact(Long id, Contact contact);
    public ContactResponse getByName(String nome);
    public List<ContactResponse> getAllContact();
}
