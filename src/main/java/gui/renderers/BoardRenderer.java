package gui.renderers;

import gui.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardRenderer
{
    public static final Color CELL_WHITE = new Color(240, 217, 181);
    public static final Color CELL_BLACK = new Color(181, 136, 99);
    private GameFrame frame;

    public void renderOn(GameFrame frame)
    {
        this.frame = frame;

        frame.getContentPane().setLayout(new GridLayout(8, 8));

        createLine(8);
        createLine(7);
        createLine(6);
        createLine(5);
        createLine(4);
        createLine(3);
        createLine(2);
        createLine(1);
    }

    private void createLine(int line)
    {
        Color color = line % 2 == 0 ? CELL_WHITE : CELL_BLACK;
        for (char column = 0; column < 8; column++)
        {
            create(letterOf(column) + line, color);
            color = color == CELL_BLACK ? CELL_WHITE : CELL_BLACK;
        }
    }

    private String letterOf(char column)
    {
        return new Character((char) (97 + column)).toString();
    }

    private void create(String name, Color color)
    {
        JButton button = new JButton();
        button.setName(name);
        button.setOpaque(true);
        button.setBackground(color);
        button.setBorderPainted(false);
        frame.getContentPane().add(button);

        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                frame.clicked((JButton) actionEvent.getSource());
            }
        });
    }
}
