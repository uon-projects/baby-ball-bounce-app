package app.menu;
import app.MainActivity;

import javax.swing.*;
import java.awt.event.*;

public class MenuActivity
{

    private MainActivity mainActivity;

    public MenuActivity(MainActivity mainActivityN)
    {
        this.mainActivity = mainActivityN;
    }

    public void prepareMenu()
    {

        var menuBar = new MenuUI();

        //prepare file option from menu
        menuBar.add(fileOptionMenu());

        //prepare scenario option from menu
        menuBar.add(scenarioOptionMenu());

        //prepare edit option from menu
        menuBar.add(editOptionMenu());

        //prepare controls option from menu
        menuBar.add(controlsOptionMenu());

        //prepare help option from menu
        menuBar.add(helpOptionMenu());

        mainActivity.setJMenuBar(menuBar);

    }

    private JMenu fileOptionMenu() {

        var fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        var eMenuItem = new JMenuItem("Exit");
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.addActionListener((event) -> System.exit(0));
        fileMenu.add(eMenuItem);

        return fileMenu;

    }

    private JMenu scenarioOptionMenu() {

        var scenarioMenu = new JMenu("Scenario");
        scenarioMenu.setMnemonic(KeyEvent.VK_S);
        return scenarioMenu;

    }

    private JMenu editOptionMenu() {

        var editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);
        return editMenu;

    }

    private JMenu controlsOptionMenu() {

        var controlsMenu = new JMenu("Controls");
        controlsMenu.setMnemonic(KeyEvent.VK_C);
        return controlsMenu;

    }

    private JMenu helpOptionMenu() {

        var helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        return helpMenu;

    }

}
