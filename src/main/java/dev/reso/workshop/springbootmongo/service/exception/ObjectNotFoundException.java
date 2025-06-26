package dev.reso.workshop.springbootmongo.service.exception;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(String message){
        super(message);
    }
}
