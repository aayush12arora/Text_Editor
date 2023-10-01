//Aayush Arora
//2110110017





import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.MouseInputListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Highlighter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.Highlighter.Highlight;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.lang.ref.Cleaner.Cleanable;
import java.net.URI;
import java.util.Map;

class Gradedlaboops implements ActionListener, CaretListener {
    final int X = 5; // Radius of circles
    private boolean rect = false, oval = false, line = false, triangle = false, pentagon = false; // Used in
                                                                                                  // paintComponent
    int pxo, pyo, pwid, phigh; // Coordinates for rectangle and oval
    int j_x1, j_x2, j_y1, j_y2; // Coordinates for line
    int ax1, ay1, ax2, ay2, ax3, ay3; // Coordinates for triangle
    int lqx1, lqx2, p_x3, p_x4, p_x5, p_y1, p_y2, p_y3, p_y4, p_y5;
    JFrame f;
    JPanel jpane;
    JMenuBar menuBar;
    JMenu file,
            edit,
            review,
            help;
    JTextPane textArea;
    JScrollPane scroll;
    String words[];
    String text;
    JMenuItem darkTheme,

            moonLightTheme,
            defaultTheme,
            save,
            open,
            close,
            cut,
            copy,
            paste,
            New,
            selectAll,
            videoHelp,
            documentHelp,
            fontSize;
    String selectedtext;
    JButton bold, italic, underline, s, a1, a2, a3, a4, findall, findnext, Replacebtn, Replaceall, rectangle, Oval,
            Line, Triangle, Pentagon, clr;
    JPanel saveFileOptionWindow;
    JPanel sketch, subsketch, notepad;
    JLabel fileLabel, dirLabel, sklabel, find, replace, wordcount, charactercount;
    JTextField fileName, dirName, mfind, mreplace;
    JComboBox<String> fontName;
    JComboBox<String> fontSizez;
    int start = -1, count = 0;

    Gradedlaboops() {
        f = new JFrame("Untitled_Document-1"); // setting the frame
        // Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\AAYUSH
        // ARORA\\Desktop\\logo.JPG"); //adding image
        String[] fN = new String[] { "Serif", "SansSerif", "Arial", "DialogInput","Cambria"
        };
        String[] fss = new String[] { "5", "8", "12", "16"
        };
        fontName = new JComboBox<>(fN);
        fontSizez = new JComboBox<>(fss);
        wordcount = new JLabel("Word Count :");

        // Textarea
        textArea = new JTextPane();
        StyledEditorKit editorKit = new StyledEditorKit();

        textArea.setEditorKit(editorKit);
        Action boldac = new StyledEditorKit.BoldAction();
        Action italicac = new StyledEditorKit.ItalicAction();
        Action underlineac = new StyledEditorKit.UnderlineAction();
        // Action strokeac = new StyledEditorKit.
        // Action changefont = new
        // StyledEditorKit.FontFamilyAction(fontName.getSelectedItem().toString());

        charactercount = new JLabel("Character Count :");
        find = new JLabel("Find");
        replace = new JLabel("Replace");
        mfind = new JTextField();
        mreplace = new JTextField();
        findall = new JButton("Find All");
        findnext = new JButton("Find Next");
        Replacebtn = new JButton("Replace");
        Replaceall = new JButton("Replace All");
        rectangle = new JButton("Rectangle");
        Oval = new JButton("Oval");
        Pentagon = new JButton("Pentagon");
        Line = new JButton("Line");
        Triangle = new JButton("Triangle");
        clr = new JButton("CLEAR");
        sketch = new JPanel();
        subsketch = new JPanel(true) {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                // do painting
                super.paintComponent(g);
                if (rect == true) {
                    g.fillRect(pxo, pyo, pwid, phigh);
                    g.setColor(Color.red);
                    g.fillOval(pxo - X, pyo - X, 2 * X, 2 * X);
                    g.fillOval(pxo + pwid - X, pyo - X, 2 * X, 2 * X);
                    g.fillOval(pxo - X, pyo + phigh - X, 2 * X, 2 * X);
                    g.fillOval(pxo + pwid - X, pyo + phigh - X, 2 * X, 2 * X);
                    g.setColor(Color.GREEN);
                    g.fillOval(pxo + pwid / 2 - X, pyo + phigh / 2 - X, 2 * X, 2 * X);
                } else if (oval == true) {
                    g.setColor(Color.PINK);
                    g.fillOval(pxo, pyo, pwid, phigh);
                    g.setColor(Color.white);
                    g.fillOval(pxo - X, pyo - X, 2 * X, 2 * X);
                    g.fillOval(pxo + pwid - X, pyo - X, 2 * X, 2 * X);
                    g.fillOval(pxo - X, pyo + phigh - X, 2 * X, 2 * X);
                    g.fillOval(pxo + pwid - X, pyo + phigh - X, 2 * X, 2 * X);
                    g.setColor(Color.white);
                    g.fillOval(pxo + pwid / 2 - X, pyo + phigh / 2 - X, 2 * X, 2 * X);
                }

                else if (line == true) {
                    Graphics2D g2 = (Graphics2D) g;
                    ((Graphics2D) g).setStroke(new BasicStroke(X));
                    g.setColor(Color.YELLOW);
                    g.drawLine(j_x1, j_y1, j_x2, j_y2);
                    g.setColor(Color.white);
                    g.fillOval(j_x1 - X, j_y1 - X, 2 * X, 2 * X);
                    g.fillOval(j_x2 - X, j_y2 - X, 2 * X, 2 * X);
                    g.setColor(Color.white);
                    g.fillOval((j_x1 + j_x2) / 2 - X, (j_y1 + j_y2) / 2 - X, 2 * X, 2 * X);
                }

                else if (triangle == true) {
                    g.setColor(Color.cyan);
                    int[] xpts = { ax1, ax2, ax3 };
                    int[] ypts = { ay1, ay2, ay3 };
                    g.fillPolygon(xpts, ypts, 3);
                    g.setColor(Color.white);
                    g.fillOval((ax1 + ax2 + ax3) / 3 - X, (ay1 + ay2 + ay3) / 3 - X, 2 * X, 2 * X);
                    g.setColor(Color.MAGENTA);
                    g.fillOval(ax1 - X, ay1 - X, 2 * X, 2 * X);
                    g.fillOval(ax2 - X, ay2 - X, 2 * X, 2 * X);
                    g.fillOval(ax3 - X, ay3 - X, 2 * X, 2 * X);
                }

                else if (pentagon == true) {
                    g.setColor(Color.YELLOW);
                    int[] xpts = { lqx1, lqx2, p_x3, p_x4, p_x5 };
                    int[] ypts = { p_y1, p_y2, p_y3, p_y4, p_y5 };
                    g.fillPolygon(xpts, ypts, 5);
                    g.setColor(Color.BLUE);
                    g.fillOval(lqx1 - X, p_y1 - X, 2 * X, 2 * X);
                    g.fillOval(lqx2 - X, p_y2 - X, 2 * X, 2 * X);
                    g.fillOval(p_x3 - X, p_y3 - X, 2 * X, 2 * X);
                    g.fillOval(p_x4 - X, p_y4 - X, 2 * X, 2 * X);
                    g.fillOval(p_x5 - X, p_y5 - X, 2 * X, 2 * X);
                    g.setColor(Color.black);
                    g.fillOval((lqx1 + lqx2 + p_x3 + p_x4 + p_x5) / 5 - X, (p_y1 + p_y2 + p_y3 + p_y4 + p_y5) / 5 - X,
                            2 * X, 2 * X);
                }
            }
        };

        notepad = new JPanel();
        sklabel = new JLabel("Sketch Pad");
        bold = new JButton("B");
        bold.setFont(new Font("Serif", Font.BOLD, 18));
        italic = new JButton("I");
        italic.setFont(new Font("Serif", Font.ITALIC, 18));
        underline = new JButton("U");

        s = new JButton("S");
        a1 = new JButton("L");

        a2 = new JButton("C");
        a3 = new JButton("R");
        a4 = new JButton("J");
        menuBar = new JMenuBar();

        // menues
        file = new JMenu("File");
        edit = new JMenu("Edit");
        review = new JMenu("Review");
        help = new JMenu("Help");

        // adding menues to menubar
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(review);
        menuBar.add(help);
        f.setJMenuBar(menuBar);

        // adding submenus to file
        save = new JMenuItem("Save");
        open = new JMenuItem("Open"); // file menu
        New = new JMenuItem("New");
        close = new JMenuItem("Exit");
        file.add(open);
        file.add(New);
        file.add(save);
        file.add(close);

        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy"); // edit menu
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("Select all");
        fontSize = new JMenuItem("Font size");
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(fontSize);

        // adding themes
        darkTheme = new JMenuItem("Option 1");
        moonLightTheme = new JMenuItem("Option 2");
        defaultTheme = new JMenuItem("Option 3");
        review.add(darkTheme);
        review.add(moonLightTheme);
        review.add(defaultTheme);

        // help menu
        videoHelp = new JMenuItem("Go to Youtube");
        documentHelp = new JMenuItem("Go to Google");
        help.add(videoHelp);
        help.add(documentHelp);

        notepad.setLayout(null);

        // scrollpane
        scroll = new JScrollPane(textArea);

        notepad.setBounds(10, 0, 551, 510);

        bold.setBounds(3, 4, 50, 30);
        italic.setBounds(50, 4, 50, 30);
        underline.setBounds(100, 4, 50, 30);
        s.setBounds(150, 4, 50, 30);
        a1.setBounds(210, 4, 50, 30);
        a2.setBounds(260, 4, 50, 30);
        a3.setBounds(310, 4, 50, 30);
        a4.setBounds(360, 4, 50, 30);

        fontName.setBounds(425, 4, 70, 30);
        fontSizez.setBounds(495, 4, 50, 30);

        find.setBounds(40, 38, 45, 25);
        mfind.setBounds(3, 67, 547, 25);
        replace.setBounds(40, 96, 50, 25);
        mreplace.setBounds(3, 125, 547, 25);
        findall.setBounds(100, 155, 90, 30);
        findnext.setBounds(200, 155, 90, 30);
        Replacebtn.setBounds(300, 155, 90, 30);
        Replaceall.setBounds(400, 155, 100, 30);

        wordcount.setBounds(2, 511, 110, 30);
        charactercount.setBounds(117, 511, 140, 30);
        sklabel.setBounds(240, 0, 70, 30);

        rectangle.setBounds(2, 35, 95, 30);
        Oval.setBounds(97, 35, 75, 30);
        Line.setBounds(172, 35, 75, 30);
        Triangle.setBounds(247, 35, 95, 30);
        Pentagon.setBounds(342, 35, 95, 30);
        clr.setBounds(447, 35, 95, 30);

        notepad.add(bold);
        notepad.add(a1);
        notepad.add(a2);
        notepad.add(a3);
        notepad.add(a4);
        notepad.add(underline);
        notepad.add(italic);
        notepad.add(s);
        notepad.add(fontName);
        notepad.add(fontSizez);
        notepad.add(find);
        notepad.add(mfind);
        notepad.add(replace);
        notepad.add(mreplace);
        notepad.add(Replaceall);
        notepad.add(Replacebtn);
        notepad.add(findnext);
        notepad.add(findall);
        f.add(charactercount);
        f.add(wordcount);
        sketch.add(rectangle);
        sketch.add(Oval);
        sketch.add(Triangle);
        sketch.add(Line);
        sketch.add(Pentagon);
        sketch.add(clr);

        scroll.setBounds(2, 190, 547, 318);
        sketch.setBorder(BorderFactory.createLineBorder(Color.black));
        notepad.setBorder(BorderFactory.createLineBorder(Color.black));
        sketch.setLayout(null);
        sketch.setBounds(590, 0, 544, 510);
        subsketch.setBounds(2, 80, 548, 428);
        subsketch.setBackground(Color.GRAY);

        sketch.add(subsketch);
        sketch.add(sklabel);
        f.add(sketch);
        notepad.add(scroll);
        f.add(notepad);
        textArea.setEditable(true);
        // adding event listeners for cut , copy & paste
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        fontSize.addActionListener(this); // change the font size
        open.addActionListener(this); // open the file
        save.addActionListener(this); // Save the file
        New.addActionListener(this); // Create the new document
        darkTheme.addActionListener(this); 
        moonLightTheme.addActionListener(this);
        defaultTheme.addActionListener(this);
        videoHelp.addActionListener(this); // video help option
        documentHelp.addActionListener(this); // document help option
        close.addActionListener(this); // close the window
        findall.addActionListener(this);
        Replacebtn.addActionListener(this);
        findnext.addActionListener(this);
        Replaceall.addActionListener(this);
        textArea.addCaretListener(this);
        bold.addActionListener(boldac);
        italic.addActionListener(italicac);
        underline.addActionListener(underlineac);
        rectangle.addActionListener(this);
        Oval.addActionListener(this);
        Line.addActionListener(this);
        Triangle.addActionListener(this);
        Pentagon.addActionListener(this);
        clr.addActionListener(this);
        a1.addActionListener(this);
        s.addActionListener(this);
        a2.addActionListener(this);
        a3.addActionListener(this);
        a4.addActionListener(this);
        fontName.addActionListener(this);
        fontSizez.addActionListener(this);

        // Keyboard Listeners
        KeyListener k = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                if (keyCode == KeyEvent.VK_S && e.isControlDown())
                    saveTheFile(); // Saving the file
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        textArea.addKeyListener(k);

        f.setSize(1170, 596);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Copy paste operations
        if (e.getSource() == cut)
            textArea.cut();
        if (e.getSource() == copy)
            textArea.copy();
        if (e.getSource() == paste)
            textArea.paste();
        if (e.getSource() == selectAll)
            textArea.selectAll();

        // change the fontsize by value
        if (e.getSource() == fontSize) {

            String sizeOfFont = JOptionPane.showInputDialog(f, "Enter Font Size", JOptionPane.OK_CANCEL_OPTION);
            if (sizeOfFont != null) {
                int convertSizeOfFont = Integer.parseInt(sizeOfFont);
                Font font = new Font(Font.SANS_SERIF, Font.PLAIN, convertSizeOfFont);
                textArea.setFont(font);
            }
        }

        // Open the file
        if (e.getSource() == open) {

            JFileChooser chooseFile = new JFileChooser();
            int i = chooseFile.showOpenDialog(f);
            if (i == JFileChooser.APPROVE_OPTION) {
                File file = chooseFile.getSelectedFile(); // select the file
                String filePath = file.getPath(); // get the file path
                String fileNameToShow = file.getName(); // get the file name
                f.setTitle(fileNameToShow);

                try {
                    BufferedReader readFile = new BufferedReader(new FileReader(filePath));
                    String tempString1 = "";
                    String tempString2 = "";

                    while ((tempString1 = readFile.readLine()) != null)
                        tempString2 += tempString1 + "\n";

                    textArea.setText(tempString2);
                    readFile.close();
                } catch (Exception ae) {
                    ae.printStackTrace();
                }
            }
        }

        // Save the file
        if (e.getSource() == save)
            saveTheFile();

        // New menu operations
        if (e.getSource() == New)
            textArea.setText("");

        // Exit from the window
        if (e.getSource() == close)
            System.exit(1);

        // help section (It opens the youtube channel page)
        if (e.getSource() == videoHelp) {
            try {
                String url = "https://www.youtube.com";
                Desktop.getDesktop().browse(URI.create(url));
            } catch (Exception a) {
                a.printStackTrace();
            }
        }

        if (e.getSource() == documentHelp) {
            try {
                String url = "http://www.google.com";
                Desktop.getDesktop().browse(URI.create(url));
            } catch (Exception a) {
                a.printStackTrace();
            }
        }
        // replace all
        if (e.getSource() == Replaceall) {
            String text = textArea.getText().toString();
            String findff = mfind.getText().toString();
            String replaceff = mreplace.getText().toString();
            text = text.replace(findff, replaceff);
            textArea.setText(text);

        }

        // replace button
        if (e.getSource() == Replacebtn) {
            if (textArea.getSelectedText()!=null) {
                
            
            String text = textArea.getText().toString();
            int indexstart = textArea.getSelectionStart();
            int indexend = textArea.getSelectionEnd();
            StringBuilder string = new StringBuilder(text);

            // string.setCharAt(index, ch);
            String replaceff = mreplace.getText().toString();
            string.replace(indexstart, indexend, replaceff);

            textArea.setText(string.toString());
            }
        }

        if (e.getSource() == findnext) {
            Highlighter highlight = textArea.getHighlighter();
            HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
            highlight.removeAllHighlights();
            String text = textArea.getText().toString();
            String findff = mfind.getText().toString();

            if (textArea.getText().contains(findff)) {
                String text_ = textArea.getText();

                start = text_.indexOf(findff, start + 1);
                highlight.removeAllHighlights();
                int length = start + findff.length();

                try {

                    highlight.addHighlight(start, length, painter);
                } catch (Exception e1) {
                  // maje lo
                }

            }
        }

        if (e.getSource() == findall) {
            Highlighter highlight = textArea.getHighlighter();
            HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
            highlight.removeAllHighlights();
            String text = textArea.getText().toString();
            String findff = mfind.getText().toString();

            if (textArea.getText().contains(findff)) {
                String text_ = textArea.getText();
                int start = text_.indexOf(findff);
                while (start >= 0) {
                    int length = start + findff.length();

                    try {

                        highlight.addHighlight(start, length, painter);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }

                    start = text_.indexOf(findff, start + 1);

                }
            }
        }
        // center align
        if (e.getSource() == a2) {
            StyledDocument doc = textArea.getStyledDocument();
            SimpleAttributeSet center = new SimpleAttributeSet();
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);

            doc.setParagraphAttributes(0, doc.getLength(), center, false);

            doc.setParagraphAttributes(doc.getLength(), 1, center, false);

        }
        // left alignment
        if (e.getSource() == a1) {
            StyledDocument doc = textArea.getStyledDocument();
            SimpleAttributeSet left = new SimpleAttributeSet();
            StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);

            doc.setParagraphAttributes(0, doc.getLength(), left, false);

            doc.setParagraphAttributes(doc.getLength(), 1, left, false);

        }
        // right alighnment
        if (e.getSource() == a3) {
            StyledDocument doc = textArea.getStyledDocument();
            SimpleAttributeSet right = new SimpleAttributeSet();
            StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);

            doc.setParagraphAttributes(0, doc.getLength(), right, false);

            doc.setParagraphAttributes(doc.getLength(), 1, right, false);

        }

        // justified alignment
        if (e.getSource() == a4) {
            StyledDocument doc = textArea.getStyledDocument();
            SimpleAttributeSet justified = new SimpleAttributeSet();
            StyleConstants.setAlignment(justified, StyleConstants.ALIGN_JUSTIFIED);

            doc.setParagraphAttributes(0, doc.getLength(), justified, false);

            doc.setParagraphAttributes(doc.getLength(), 1, justified, false);

        }

        // fontName
        if (e.getSource() == fontName) {

            if (textArea.getSelectedText() != null) {
                int sizerr = Integer.parseInt(fontSizez.getSelectedItem().toString());
                Action fontAction = new StyledEditorKit.FontFamilyAction(String
                        .valueOf(sizerr), fontName.getSelectedItem().toString());
                fontAction.actionPerformed(e);

            } else {
                Font font = new Font(fontName.getSelectedItem().toString(), textArea.getFont().getStyle(),
                        textArea.getFont().getSize());
                textArea.setFont(font);
            }
        }

        // fontSize
        if (e.getSource() == fontSizez) {

            if (textArea.getSelectedText() != null) {
                int sizerr = Integer.parseInt(fontSizez.getSelectedItem().toString());
                Action fontAction = new StyledEditorKit.FontSizeAction(String
                        .valueOf(sizerr), sizerr);
                fontAction.actionPerformed(e);

            } else {

                Font font = new Font(textArea.getFont().getFamily().toString(), textArea.getFont().getStyle(),
                        Integer.parseInt(fontSizez.getSelectedItem().toString()));
                textArea.setFont(font);
            }
        }

        // Rectangle
        if (e.getSource() == rectangle) {

            rectangle();

        }

        // clear
        if (e.getSource() == clr) {

            clear();

        }
        // Oval
        if (e.getSource() == Oval) {

            oval();
        }

        // Triangle
        if (e.getSource() == Triangle) {

            triangle();

        }

        // Line
        if (e.getSource() == Line) {

            line();

        }
        // Pentagon
        if (e.getSource() == Pentagon) {

            pentagon();
        }

        if (e.getSource() == s) {

            DefaultStyledDocument styleDocument = new DefaultStyledDocument();
            StyleContext sc = new StyleContext();
            Style style = sc.addStyle("strikethru", null);
            if (count % 2 == 0) {
                StyleConstants.setStrikeThrough(style, true);
            } else {
                StyleConstants.setStrikeThrough(style, false);
            }
            // doc.insertString (0, "Hello ", null);

            try {

                styleDocument.insertString(0, textArea.getText().toString(), style);
                textArea.setStyledDocument(styleDocument);
            } catch (BadLocationException ex) {
                // Logger.getLogger(JTextPaneTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            count++;
        }

    }

    // Save the file
    public void saveTheFile() {

        JFileChooser SaveFile = new JFileChooser();
        SaveFile.setApproveButtonText("Save");
        int i = SaveFile.showOpenDialog(f);
        if (i == JFileChooser.APPROVE_OPTION) {
            File fileName = new File(SaveFile.getSelectedFile() + ".txt");

            try {
                BufferedWriter outFile = new BufferedWriter(new FileWriter(fileName));
                outFile.write(textArea.getText()); // put in textfile

                outFile.close();
            } catch (IOException ex) {
            }

        }

    }

    // overriding mouse listeners

    @Override
    public void caretUpdate(CaretEvent e) {
        if (e.getSource() == textArea) {
            selectedtext = textArea.getSelectedText();

            if (selectedtext != null) {

                // splitting the string in words
                String words[] = selectedtext.split("\\s");
                // printing the number of words and characters of the string

                wordcount.setText("Word Count: " + words.length);
                charactercount.setText("Character Count: " + selectedtext.length());

            } else {
                wordcount.setText("Word Count: 0");
                charactercount.setText("Character Count: 0");
            }
        }

    }

    public void dragmouse(MouseEvent e) {
        if (rect == true || oval == true) {
            if (e.getX() <= pxo + pwid / 2 + X && e.getX() >= pxo + pwid / 2 - X && e.getY() <= pyo + phigh / 2 + X
                    && e.getY() >= pyo + phigh / 2 - X) {
                pxo = e.getX() - pwid / 2;
                pyo = e.getY() - phigh / 2;
                subsketch.repaint();
            }

            // Bottom Right
            if (e.getX() <= pxo + pwid + X && e.getX() >= pxo + pwid - X && e.getY() <= pyo + phigh + X
                    && e.getY() >= pyo + phigh - X) {
                pwid = e.getX() - pxo;
                phigh = e.getY() - pyo;
                if (pwid < 4 * X)
                    pwid = 4 * X;
                if (phigh < 4 * X)
                    phigh = 4 * X;
                subsketch.repaint();
            }

            // Top Left
            if (e.getX() <= pxo + X && e.getX() >= pxo - X && e.getY() <= pyo + X && e.getY() >= pyo - X) {
                final int r_x2 = pxo + pwid;
                final int r_y2 = pyo + phigh;
                pxo = e.getX();
                pyo = e.getY();
                pwid = r_x2 - pxo;
                phigh = r_y2 - pyo;
                if (pwid < 4 * X)
                    pwid = 4 * X;
                if (phigh < 4 * X)
                    phigh = 4 * X;
                subsketch.repaint();
            }

            // Top Right
            if (e.getX() <= pxo + pwid + X && e.getX() >= pxo + pwid - X && e.getY() <= pyo + X
                    && e.getY() >= pyo - X) {
                final int r_y2 = pyo + phigh;
                pwid = e.getX() - pxo;
                pyo = e.getY();
                phigh = r_y2 - pyo;
                if (pwid < 4 * X)
                    pwid = 4 * X;
                if (phigh < 4 * X)
                    phigh = 4 * X;
                subsketch.repaint();

            }

            // Bottom Left
            if (e.getX() <= pxo + X && e.getX() >= pxo - X && e.getY() <= pyo + phigh + X
                    && e.getY() >= pyo + phigh - X) {
                final int r_x2 = pxo + pwid;
                phigh = e.getY() - pyo;
                pxo = e.getX();
                pwid = r_x2 - pxo;
                if (pwid < 4 * X)
                    pwid = 4 * X;
                if (phigh < 4 * X)
                    phigh = 4 * X;
                subsketch.repaint();
            }
        }

        else if (line == true) {

            if (e.getX() <= (j_x1 + j_x2) / 2 + X && e.getX() >= (j_x1 + j_x2) / 2 - X
                    && e.getY() <= (j_y1 + j_y2) / 2 + X && e.getY() >= (j_y1 + j_y2) / 2 - X) {
                final int x = (j_x1 + j_x2) / 2;
                final int y = (j_y1 + j_y2) / 2;
                j_x1 += e.getX() - x;
                j_y1 += e.getY() - y;
                j_x2 += e.getX() - x;
                j_y2 += e.getY() - y;
                subsketch.repaint();
            }

            else if (e.getX() <= j_x1 + X && e.getX() >= j_x1 - X && e.getY() <= j_y1 + X && e.getY() >= j_y1 - X) {
                j_x1 = e.getX();
                j_y1 = e.getY();
                subsketch.repaint();
            }

            else if (e.getX() <= j_x2 + X && e.getX() >= j_x2 - X && e.getY() <= j_y2 + X && e.getY() >= j_y2 - X) {
                j_x2 = e.getX();
                j_y2 = e.getY();
                subsketch.repaint();
            }
        }

        else if (triangle == true) {

            if (e.getX() <= (ax1 + ax2 + ax3) / 3 + X && e.getX() >= (ax1 + ax2 + ax3) / 3 - X
                    && e.getY() <= (ay1 + ay2 + ay3) / 3 + X && e.getY() >= (ay1 + ay2 + ay3) / 3 - X) {
                final int x = (ax1 + ax2 + ax3) / 3;
                final int y = (ay1 + ay2 + ay3) / 3;
                ax1 += e.getX() - x;
                ay1 += e.getY() - y;
                ax2 += e.getX() - x;
                ay2 += e.getY() - y;
                ax3 += e.getX() - x;
                ay3 += e.getY() - y;
                subsketch.repaint();
            }

            else if (e.getX() >= ax1 - X && e.getX() <= ax1 + X && e.getY() >= ay1 - X & e.getY() <= ay1 + X) {
                ax1 = e.getX();
                ay1 = e.getY();
                subsketch.repaint();
            }

            else if (e.getX() >= ax2 - X && e.getX() <= ax2 + X && e.getY() >= ay2 - X && e.getY() <= ay2 + X) {
                ax2 = e.getX();
                ay2 = e.getY();
                subsketch.repaint();
            }

            else if (e.getX() >= ax3 - X && e.getX() <= ax3 + X && e.getY() >= ay3 - X && e.getY() <= ay3 + X) {
                ax3 = e.getX();
                ay3 = e.getY();
                subsketch.repaint();
            }
        }

        else if (pentagon == true) {
            // Centre
            if (e.getX() <= (lqx1 + lqx2 + p_x3 + p_x4 + p_x5) / 5 + X
                    && e.getX() >= (lqx1 + lqx2 + p_x3 + p_x4 + p_x5) / 5 - X
                    && e.getY() >= (p_y1 + p_y2 + p_y3 + p_y4 + p_y5) / 5 - X
                    && e.getY() <= (p_y1 + p_y2 + p_y3 + p_y4 + p_y5) / 5 + X) {
                final int x = (lqx1 + lqx2 + p_x3 + p_x4 + p_x5) / 5;
                final int y = (p_y1 + p_y2 + p_y3 + p_y4 + p_y5) / 5;
                lqx1 += e.getX() - x;
                p_y1 += e.getY() - y;
                lqx2 += e.getX() - x;
                p_y2 += e.getY() - y;
                p_x3 += e.getX() - x;
                p_y3 += e.getY() - y;
                p_x4 += e.getX() - x;
                p_y4 += e.getY() - y;
                p_x5 += e.getX() - x;
                p_y5 += e.getY() - y;
                subsketch.repaint();
            }

            else if (e.getX() <= lqx1 + X & e.getX() >= lqx1 - X && e.getY() >= p_y1 - X && e.getY() <= p_y1 + X) {
                lqx1 = e.getX();
                p_y1 = e.getY();
                subsketch.repaint();
            }

            else if (e.getX() <= lqx2 + X & e.getX() >= lqx2 - X && e.getY() >= p_y2 - X && e.getY() <= p_y2 + X) {
                lqx2 = e.getX();
                p_y2 = e.getY();
                subsketch.repaint();
            }

            else if (e.getX() <= p_x3 + X & e.getX() >= p_x3 - X && e.getY() >= p_y3 - X && e.getY() <= p_y3 + X) {
                p_x3 = e.getX();
                p_y3 = e.getY();
                subsketch.repaint();
            }

            else if (e.getX() <= p_x4 + X & e.getX() >= p_x4 - X && e.getY() >= p_y4 - X && e.getY() <= p_y4 + X) {
                p_x4 = e.getX();
                p_y4 = e.getY();
                subsketch.repaint();
            }

            else if (e.getX() <= p_x5 + X & e.getX() >= p_x5 - X && e.getY() >= p_y5 - X && e.getY() <= p_y5 + X) {
                p_x5 = e.getX();
                p_y5 = e.getY();
                subsketch.repaint();
            }
        }
    }

    // function for rectangle
    public void rectangle() {
        pxo = 100;
        pyo = 150;
        pwid = 150;
        phigh = 100;
        rect = true;
        oval = false;
        line = false;
        triangle = false;
        pentagon = false;
        subsketch.repaint();
        subsketch.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                dragmouse(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                // Do nothing
            }
        });
    }

    // function for oval dembes
    public void oval() {
        pxo = 200;
        pyo = 150;
        pwid = 100;
        phigh = 200;
        rect = false;
        line = false;
        oval = true;
        pentagon = false;
        triangle = false;
        subsketch.repaint();
        subsketch.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                dragmouse(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                // Do nothing
            }
        });
    }

    // function for line
    public void line() {
        j_x1 = 100;
        j_y1 = 200;
        j_x2 = 200;
        j_y2 = 150;
        rect = false;
        line = true;
        oval = false;
        pentagon = false;
        triangle = false;
        subsketch.repaint();
        subsketch.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                dragmouse(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                // Do nothing
            }
        });
    }

    // trinagle
    public void triangle() {
        ax1 = 110;
        ay1 = 110;
        ax2 = 100;
        ay2 = 200;
        ax3 = 200;
        ay3 = 190;
        rect = false;
        line = false;
        oval = false;
        pentagon = false;
        triangle = true;
        subsketch.repaint();
        subsketch.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                dragmouse(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                // Do nothing
            }
        });
    }

    // pentagon

    public void pentagon() {
        lqx1 = 150;
        p_y1 = 100;
        lqx2 = 100;
        p_x3 = 120;
        p_x4 = 180;
        p_x5 = 200;
        p_y2 = 140;
        p_y5 = 140;
        p_y3 = 180;
        p_y4 = 180;
        rect = false;
        line = false;
        oval = false;
        pentagon = true;
        triangle = false;
        subsketch.repaint();
        subsketch.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                dragmouse(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                // Do nothing
            }
        });
    }

    // clear method
    public void clear() {
        rect = false;
        line = false;
        oval = false;
        pentagon = false;
        triangle = false;
        subsketch.repaint();
    }

    // main method
    public static void main(String[] args) {

        // making instance of graded loops
        new Gradedlaboops();
    }

}
