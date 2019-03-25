package ru.geekbrains.lesson1_J2;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MyChat extends JFrame {
    private JPanel jPanelField;
    private JPanel jPanelArea;
    private JSlider jSlider;
    static JTextArea jTextArea;
    static JTextField jTextField;
    ActionService actionService;

    MyChat() {
        setTitle("ChatDEMO");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500,200,300,300);

        createContent();
        setElementPosition();
        CreateMenu();

        setVisible(true);
    }

    private void CreateMenu() {
        JMenuBar mainMenu = new JMenuBar();
        JMenu mFile = new JMenu("Файл");
        JMenu mSettings = new JMenu("Настройки");
        JMenuItem mFileNew = new JMenuItem("Новый чат");
        JMenuItem mFileExit = new JMenuItem("Выход");
        JMenuItem mSettingsColor = new JMenuItem("Цвет");
        setJMenuBar(mainMenu);
        mainMenu.add(mFile);
        mainMenu.add(mSettings);
        mFile.add(mFileNew);
        mFile.addSeparator();
        mFile.add(mFileExit);
        mSettings.add(mSettingsColor);

        mFileNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea.setText("");
            }
        });

        mFileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        mSettingsColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createSlider();
            }
        });
    }

    private void createSlider() {
        jSlider = new JSlider();
        jSlider.setMaximum(-1);
        jSlider.setMinimum(-255);
        jSlider.setValue(-1);
        jSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                jTextArea.setBackground(new Color(jSlider.getValue()));
            }
        });

        getContentPane().add(jSlider, BorderLayout.NORTH);
        setVisible(true);
    }

    private void createContent() {
        setLayout(new BorderLayout());
        jPanelField = new JPanel();
        jPanelArea = new JPanel();

        JLabel jLabel = new JLabel("Текст сообщения: ");
        jTextField = new JTextField(15);
        JButton sendButton = new JButton("Отправить");
        jTextArea = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane(jTextArea);

        jPanelArea.setLayout(new BorderLayout());
        jPanelArea.add(jScrollPane, BorderLayout.CENTER);
        jTextArea.setEditable(false);

        jPanelField.setLayout(new BorderLayout());
        jPanelField.add(jLabel, BorderLayout.WEST);
        jPanelField.add(jTextField, BorderLayout.CENTER);
        jPanelField.add(sendButton, BorderLayout.EAST);

        jTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = jTextArea.getText().concat("");
                text = text.concat(jTextField.getText());
                jTextArea.setText(text+"\n");
                jTextField.setText("");
            }
        });

        try {
            jTextField.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    jSlider.setVisible(false);
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try{
        jTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jSlider.setVisible(false);
            }
        });
    }
        catch (Exception e)
    {
        e.printStackTrace();
    }

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = jTextArea.getText().concat("");
                text = text.concat(jTextField.getText());
                jTextArea.setText(text+"\n");
                jTextField.setText("");
            }
        });
    }

    private void setElementPosition() {
        getContentPane().add(jPanelField, BorderLayout.SOUTH);
        getContentPane().add(jPanelArea, BorderLayout.CENTER);
    }
}
