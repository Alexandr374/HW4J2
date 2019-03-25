package ru.geekbrains.lesson1_J2;

import javax.swing.*;

import static ru.geekbrains.lesson1_J2.MyChat.jTextArea;
import static ru.geekbrains.lesson1_J2.MyChat.jTextField;

public class ActionForSouthPanel implements ActionService {


    @Override
    public void execute() {
        String text = jTextArea.getText().concat("");
        text = text.concat(jTextField.getText());
        jTextArea.setText(text+"\n");
        jTextField.setText("");
    }
}
