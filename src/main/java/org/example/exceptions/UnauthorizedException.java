package org.example.exceptions;

import javax.swing.*;

public class UnauthorizedException extends Exception{
    public UnauthorizedException(){};
    public UnauthorizedException(String message){
        super(message);
        JOptionPane.showMessageDialog(null, message,"Unauthorized", JOptionPane.ERROR_MESSAGE);
        throw new RuntimeException(message);
    }
}
