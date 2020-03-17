package app.game.control;

import app.utils.AppUtils;
import app.utils.material.MaterialButton;
import app.utils.material.MaterialElements;
import app.utils.material.MaterialLabel;
import app.utils.material.MaterialSlider;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameControls
{

    private JPanel gameControls;
    private MaterialElements materialElements;
    private MaterialButton btnState;

    public GameControls()
    {

        materialElements = new MaterialElements();
        gameControls = new JPanel();
        gameControls.setLayout(new FlowLayout());
        gameControls.setBackground(new Color(241, 241, 241));
        gameControls.setPreferredSize(new Dimension(570, 60));

        prepareButtons();
        prepareSlider();

    }

    private void prepareButtons() {

        loadActBtn();
        loadStateBtn();
        loadResetBtn();

    }

    private void loadActBtn() {

        Icon iconAct = new ImageIcon("assets/images/step.png");
        MaterialButton btnAct = materialElements.createButton(iconAct, "Act");
        gameControls.add(btnAct);

    }

    private void loadStateBtn() {

        Icon iconAct = new ImageIcon("assets/images/run.png");
        btnState = materialElements.createButton(iconAct, "Run");
        btnState.addActionListener(actionEvent -> {

            if(!AppUtils.isGameStarted())
            {
                btnState.setIcon(new ImageIcon("assets/images/pause.png"));
                btnState.setText("Pause");
            }
            else
            {
                btnState.setIcon(new ImageIcon("assets/images/run.png"));
                btnState.setText("Run");
            }
            AppUtils.changeGameState();
        });
        gameControls.add(btnState);

    }

    private void loadResetBtn() {

        Icon iconAct = new ImageIcon("assets/images/reset.png");
        MaterialButton btnReset = materialElements.createButton(iconAct, "Reset");
        btnReset.addActionListener(actionEvent -> {
            AppUtils.resetSeconds();
            btnState.setIcon(new ImageIcon("assets/images/run.png"));
            btnState.setText("Run");
        });
        gameControls.add(btnReset);

    }

    private void prepareSlider()
    {

        MaterialLabel sliderTitle = materialElements.createLabel("Speed:");
        sliderTitle.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 0));
        gameControls.add(sliderTitle);

        MaterialSlider slider = materialElements.createHorizontalSlider(1, 5, 1);
        slider.addChangeListener(this::sliderChanged);
        gameControls.add(slider);

    }

    private void sliderChanged(ChangeEvent changeEvent)
    {


    }

    public JPanel getGameControlsContainer()
    {
        return gameControls;
    }
    
}
