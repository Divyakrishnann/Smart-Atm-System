package atm;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import edu.cmu.sphinx.api.*;

public class VoiceRec extends JFrame {
    private JTextArea textArea;
    private String pinno;
    private MiniStatement miniStatementWindow;
    private Deposit depositWin;
    private Fastcash fastCashWin;
    private Withdrawl withdrawWin;
    private BalanceEnquiry enquiryWin;
    private PinChange pinChangeWin;

    public VoiceRec(String pinno) {
        this.pinno = pinno;
        initialize();
    }
    
    public void initialize() {
        setTitle("Voice Recognition Commands");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);

        startRecognition();
    }
    public void startRecognition() {
    Thread recognitionThread = new Thread(() -> {
        Configuration config = new Configuration();
        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        config.setDictionaryPath("src/main/java/atm/5057.dic");
        config.setLanguageModelPath("src/main/java/atm/5057.lm");

        LiveSpeechRecognizer speechRecognizer = null;
        try {
            speechRecognizer = new LiveSpeechRecognizer(config);
            speechRecognizer.startRecognition(true);

            while (true) {
                SpeechResult speechResult = speechRecognizer.getResult();
                if (speechResult != null) {
                    String voiceCommand = speechResult.getHypothesis().toUpperCase();
                    System.out.println("Voice Command: " + voiceCommand);
                    SwingUtilities.invokeLater(() -> textArea.append(voiceCommand + "\n"));

                    switch (voiceCommand) {
                        case "OPEN MINI STATEMENT":
                            openMiniStatement();
                            break;
                        case "CLOSE MINI STATEMENT":
                            closeMiniStatement();
                            break;
                        case "OPEN DEPOSIT":
                            openDeposit();
                            break;
                        case "CLOSE DEPOSIT":
                            closeDeposit();
                            break;
                        case "OPEN WITHDRAW":
                            openWithdraw();
                            break;
                        case "CLOSE WITHDRAW":
                            closeWithdraw();
                            break;
                        case "OPEN FAST CASH":
                            openFastCash();
                            break;
                        case "CLOSE FAST CASH":
                            closeFastCash();
                            break;
                        case "OPEN ENQUIRY":
                            openEnquiry();
                            break;
                        case "CLOSE ENQUIRY":
                            closeEnquiry();
                            break;
                        case "OPEN PIN CHANGE":
                            openPinChange();
                            break;
                        case "CLOSE PIN CHANGE":
                            closePinChange();
                            break;
                        case "CLOSE ATM":
                            System.exit(0);
                            break;
                        case "CLOSE VOICE RECOGNITION":
                            closevoice();
                            break;
                        default:
                            // Handle unrecognized commands
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (speechRecognizer != null) {
                speechRecognizer.stopRecognition();
                speechRecognizer.close();
            }
        }
    });

    recognitionThread.start();
}

    public void openMiniStatement() {
        if (miniStatementWindow == null) {
            miniStatementWindow = new MiniStatement(pinno);
            miniStatementWindow.setVisible(true);
        }
    }

    public void closeMiniStatement() {
        if (miniStatementWindow != null) {
            miniStatementWindow.dispose();
            miniStatementWindow = null;
        }
    }

    public void openDeposit() {
        if (depositWin == null) {
            depositWin = new Deposit(pinno);
            depositWin.setVisible(true);
        }
    }

    public void closeDeposit() {
        if (depositWin != null) {
            depositWin.dispose();
            depositWin = null;
        }
    }

    public void openWithdraw() {
        if (withdrawWin == null) {
            withdrawWin = new Withdrawl(pinno);
            withdrawWin.setVisible(true);
        }
    }

    public void closeWithdraw() {
        if (withdrawWin != null) {
            withdrawWin.dispose();
            withdrawWin = null;
        }
    }

    public void openFastCash() {
        if (fastCashWin == null) {
            fastCashWin = new Fastcash(pinno);
            fastCashWin.setVisible(true);
        }
    }

    public void closeFastCash() {
        if (fastCashWin != null) {
            fastCashWin.dispose();
            fastCashWin = null;
        }
    }

    public void openEnquiry() {
        if (enquiryWin == null) {
            enquiryWin = new BalanceEnquiry(pinno);
            enquiryWin.setVisible(true);
        }
    }

    public void closeEnquiry() {
        if (enquiryWin != null) {
            enquiryWin.dispose();
            enquiryWin = null;
        }
    }

    public void openPinChange() {
        if (pinChangeWin == null) {
            pinChangeWin = new PinChange(pinno);
            pinChangeWin.setVisible(true);
        }
    }

    public void closePinChange() {
        if (pinChangeWin != null) {
            pinChangeWin.dispose();
            pinChangeWin = null;
        }
    }

    public void closevoice() {
        setVisible(false);
        new Transaction(pinno).setVisible(true);        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VoiceRec(""); // Replace "" with the actual PIN
        });
    }
}

