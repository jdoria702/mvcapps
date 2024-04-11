package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppPanel extends JPanel implements Subscriber, ActionListener {
    public static int FRAME_WIDTH = 830;
    public static int FRAME_HEIGHT = 500;
    private final View view;
    public JPanel controls;
    private Model model;
    private AppFactory factory;
    private JFrame frame;

    public AppPanel(AppFactory newFactory) {
        this.factory = newFactory;
        controls = new JPanel();
        controls.setBackground(Color.PINK);
        model = factory.makeModel();
        view = factory.makeView(model);
        view.setBackground(Color.GRAY);
        setLayout(new GridLayout(1, 3));
        add(controls);
        add(view);
        model.subscribe(this);

        frame = new SafeFrame();
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(createMenuBar());
        frame.setTitle(factory.getTitle());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New", "Save", "SaveAs", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", this.factory.getEditCommands(), this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", new String[]{"About", "Help"}, this);
        result.add(helpMenu);
        return result;
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        try {
            switch (cmd) {
                case "Save":
                    Utilities.save(model, false);
                    break;
                case "SaveAs":
                    Utilities.save(model, true);
                    break;
                case "Open":
                    Model newModel = Utilities.open(model);
                    if (newModel != null) {
                        setModel(newModel);
                    }
                    break;
                case "About":
                    Utilities.inform(this.factory.about());
                    break;
                case "Help":
                    Utilities.inform(this.factory.getHelp());
                    break;
                case "New":
                    Utilities.saveChanges(model);
                    setModel(factory.makeModel());
                    model.setUnsavedChanges(false);
                    break;
                case "Quit":
                    Utilities.saveChanges(model);
                    System.exit(0);
                    break;
                default:
                    Command c = factory.makeEditCommand(this.model, cmd, this);
                    c.execute();
            }
        } catch (Exception error) {
            Utilities.error(error);
        }

    }

    public void display() {
        frame.setVisible(true);
    }

    public void update() {
    }

    public void setModel(Model newModel) {
        this.model.unsubscribe(this);
        this.model = newModel;
        this.model.subscribe(this);
        view.setModel(this.model);
        model.changed();
    }
}