package br.com.contact.service;

import br.com.contact.controller.request.ContactRequest;
import br.com.contact.controller.response.ContactResponse;
import br.com.contact.exception.EntidadeNaoEncontradaException;
import br.com.contact.model.Contact;
import br.com.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void createContact(ContactRequest request) {
        this.contactRepository.save(new Contact().convertRequestToEntity(request));
    }

    @Override
    public void removeContact(Long id) {
        this.contactRepository.deleteById(id);
    }

    @Override
    public ContactResponse getContactByName(String nome) {
      List<Contact> contacts = this.contactRepository.findAll();
      Contact contact = contacts.stream()
              .filter(cont -> cont.getNome().equals(nome))
              .findAny().get();

      return new Contact().convertToContactResponse(contact);
    }

    @Override
    public ContactResponse getByName(String nome) {
       Contact contact = this.contactRepository.findByNome(nome);
       if(!(contact.getNome().equals(nome))){
            throw new EntidadeNaoEncontradaException("Contato não encontrado!");
       }
       return new Contact().convertToContactResponse(contact);
    }

    @Override
    public ContactResponse getContactById(Long id) {
        Optional<Contact> contact = this.contactRepository.findById(id);
        if(!(contact.get().getId().equals(id))){
            throw new EntidadeNaoEncontradaException("Contato não encontrado!");
        }
        return new Contact().convertToContactResponse(contact.get());
    }

    @Override
    public List<ContactResponse> getAllContact() {

        return this.contactRepository.findAll()
                .stream().map(contact -> contact.convertToContactResponse(contact))
                .collect(Collectors.toList());
    }

    @Override
    public ContactResponse getUpdateContact(Long id, Contact contact){
        getContactById(id);
        contact.setId(id);
        return new Contact().convertToContactResponse(this.contactRepository.save(contact));
    }

}
