import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ZeldaRunner {
    static Player link = new Player();
    JPanel panel;
    static Environment envo = new Environment(link);


    public static void main(String[] args) {
        new ZeldaRunner().start();
    }

    private void start() {
        JFrame frame = new JFrame("Runner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawAll(g);
            }
        };
        //int width = Toolkit.getDefaultToolkit().getScreenSize().width/2;
        //int height = Toolkit.getDefaultToolkit().getScreenSize().height/2;
        panel.setPreferredSize(new Dimension(800,600));
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(0, 0);
        frame.setSize(800,600);
        mapKeyStrokesToActions(panel);



    }

    private void mapKeyStrokesToActions(JPanel panel) {
        ActionMap map = panel.getActionMap();
        InputMap inMap = panel.getInputMap();

        inMap.put(KeyStroke.getKeyStroke("pressed UP"), "up");
        map.put("up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hit("up");
            }


        });
        panel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"left");
        panel.getActionMap().put("left",new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                hit("left");
            }
        });

        panel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),"right");
        panel.getActionMap().put("right",new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                hit("right");
            }
        });

        panel.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"down");
        panel.getActionMap().put("down",new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                hit("down");
            }
        });

    }
    public  void hit(String s) {
        link.keyHit(s);
        panel.repaint();
    }

    protected static void drawAll(Graphics g) {
        envo.draw(g);
        link.draw(g);




    }

}

