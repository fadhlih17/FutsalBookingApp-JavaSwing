package org.example.exceptions;

import javax.swing.*;

public class WarningException extends Exception{
    public WarningException(){}
    public WarningException(String message){
        super(message);
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.WARNING_MESSAGE);
        throw new RuntimeException(message);
    }
}
