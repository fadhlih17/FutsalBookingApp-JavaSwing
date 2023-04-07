package org.example.exceptions;

import javax.swing.*;

public class UnauthorizedException extends RuntimeException{
    public UnauthorizedException(){};
    public UnauthorizedException(String message){
        super(message);
        JOptionPane.showMessageDialog(null, message,"Invalid Access", JOptionPane.ERROR_MESSAGE);
        throw new RuntimeException(message);
    }
}
