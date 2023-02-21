package hard;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import java.awt.Component;
import java.awt.Dimension;
import java.util.List;

/**
 * Your mission is to create a stopwatch program. this program should have start, stop, and lap options, and it
 * should write out to a file to be viewed later.
 */
public class Challenge2 implements Runnable {

    private static final String CLICK_START = "Click Start";
    private static final String START = "Start";
    private static final String STOP = "Stop";
    private static final String LAP = "Lap";
    private static final String TICKING = "Ticking...";
    private static final String EMPTY_TIMER = "---";
    private static final String CLEAR_ON_START = "Clear Laps on Start?";

    private Timer timer;
    private long totalTime = 0;
    private long startTime = 0;
    private long currentLap = 0;

    public static void main(String[] args) {
        Challenge2 challenge2 = new Challenge2();
        SwingUtilities.invokeLater(challenge2);
    }

    private void setAlignmentToCenter(List<JComponent> components) {
        components.forEach(c -> c.setAlignmentX(Component.CENTER_ALIGNMENT));
    }

    private void addToPanel(JPanel panel, Component component) {
        panel.add(component);
        panel.add(addSpace());
    }

    private Component addSpace() {
        return Box.createRigidArea(new Dimension(0, 5));
    }

    @Override
    public void run() {
        JFrame frame = new JFrame();
        JLabel label = new JLabel(CLICK_START);
        JLabel timerLabel = new JLabel(EMPTY_TIMER);
        JButton startButton = new JButton(START);
        JButton stopButton = new JButton(STOP);
        JButton lapButton = new JButton(LAP);
        JTextArea laps = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(laps);
        JCheckBox clearOnStart = new JCheckBox(CLEAR_ON_START, true);

        startButton.addActionListener(e -> {
            currentLap = startTime = System.currentTimeMillis();
            label.setText(TICKING);
            if (clearOnStart.isSelected()) {
                laps.setText("");
            }
            startButton.setEnabled(false);
            stopButton.setEnabled(true);
            lapButton.setEnabled(true);

            timer = new Timer(100, e1 -> {
                String timeElapsed = String.valueOf(System.currentTimeMillis() - startTime);
                timerLabel.setText(timeElapsed + "ms");
            });
            timer.start();
        });

        stopButton.addActionListener(e -> {
            totalTime += System.currentTimeMillis() - startTime;
            label.setText(totalTime + "ms");

            startButton.setEnabled(true);
            stopButton.setEnabled(false);
            lapButton.setEnabled(false);

            totalTime = 0;
            timer.stop();
            timerLabel.setText("---");
        });

        lapButton.addActionListener(e -> {
            long lap = System.currentTimeMillis() - currentLap;
            laps.append(lap + "ms\n");
            currentLap = System.currentTimeMillis();
        });

        setAlignmentToCenter(List.of(label,
            timerLabel,
            startButton,
            stopButton,
            lapButton,
            laps,
            clearOnStart));
        stopButton.setEnabled(false);
        lapButton.setEnabled(false);
        laps.setRows(10);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        addToPanel(panel, label);
        addToPanel(panel, timerLabel);
        addToPanel(panel, startButton);
        addToPanel(panel, stopButton);
        addToPanel(panel, lapButton);
        addToPanel(panel, scrollPane);
        addToPanel(panel, clearOnStart);

        frame.add(panel);
        frame.setPreferredSize(new Dimension(240, 480));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}
