/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.epp.mhxmath.gui;

import gr.epp.mhxmath.maincode.Node;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author NZXT
 */
public class MainMenu extends JFrame {

    Node root;
    MainMenu left;
    MainMenu right;

    String textUser;
    String temp2;

    int sum1 = 0;
    int sum2 = 0;
    int sum3 = 0;
    int sum4 = 0;
    int sum5 = 0;
    int pos2;
    int pos1;
    int pos3;
    int pos4;
    int pos5;
    int k;
    int y;
    int j;
    int i = 0;
    int r = 0;
    int temp = 0;

    ArrayList<String> word;
    ArrayList<String> word2;
    ArrayList<String> word3;
    ArrayList<String> word4;
    ArrayList<String> word5;
    ArrayList<String> wordTextUser;
    ArrayList<String> pagesort;

    ArrayList<Integer> suxnothta;
    ArrayList<Integer> suxnothta2;
    ArrayList<Integer> suxnothta3;
    ArrayList<Integer> suxnothta4;
    ArrayList<Integer> suxnothta5;
    ArrayList<Integer> suxnothtaWordUser1;
    ArrayList<Integer> suxnothtaWordUser2;
    ArrayList<Integer> suxnothtaWordUser3;
    ArrayList<Integer> suxnothtaWordUser4;
    ArrayList<Integer> suxnothtaWordUser5;
    ArrayList<Integer> max;

    JButton label;
    JLabel lbLabel0;
    JLabel lbLabel2;
    JTextField tfText0;
    JButton btBut0;
    JLabel lbLabel3;
    JPanel panel01;

    public MainMenu() throws FileNotFoundException {
        /* START OF GUI */
        this.setTitle("Mini Search Engine");
        this.setSize(210, 248);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout gbPanel0 = new GridBagLayout();
        GridBagConstraints gbcPanel0 = new GridBagConstraints();
        this.setLayout(gbPanel0);

        lbLabel0 = new JLabel("MINI SEARCH ENGINE");
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 20;
        gbcPanel0.gridheight = 3;
        gbcPanel0.fill = GridBagConstraints.VERTICAL;
        gbcPanel0.weightx = 0;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(lbLabel0, gbcPanel0);
        this.add(lbLabel0);

        lbLabel2 = new JLabel("Type the string you want to search");
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 3;
        gbcPanel0.gridwidth = 18;
        gbcPanel0.gridheight = 2;
        gbcPanel0.fill = GridBagConstraints.VERTICAL;
        gbcPanel0.weightx = 0;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(lbLabel2, gbcPanel0);
        this.add(lbLabel2);

        tfText0 = new JTextField();
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 5;
        gbcPanel0.gridwidth = 18;
        gbcPanel0.gridheight = 2;
        gbcPanel0.fill = GridBagConstraints.HORIZONTAL;
        gbcPanel0.weightx = 0;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(tfText0, gbcPanel0);
        this.add(tfText0);

        btBut0 = new JButton("Search");
        gbcPanel0.gridx = 6;
        gbcPanel0.gridy = 8;
        gbcPanel0.gridwidth = 8;
        gbcPanel0.gridheight = 2;
        gbcPanel0.fill = GridBagConstraints.NONE;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.CENTER;
        gbPanel0.setConstraints(btBut0, gbcPanel0);
        this.add(btBut0);

        panel01 = new JPanel();
        panel01.setLayout(new GridLayout(5, 1));
        panel01.setVisible(false);
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 7;
        gbcPanel0.gridwidth = 18;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.HORIZONTAL;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(panel01, gbcPanel0);
        this.add(panel01);

        /* END OF GUI */
        FileReader myFile = null;
        BufferedReader buff = null;

        word = new ArrayList<String>();
        word2 = new ArrayList<String>();
        word3 = new ArrayList<String>();
        word4 = new ArrayList<String>();
        word5 = new ArrayList<String>();
        pagesort = new ArrayList<String>();
        wordTextUser = new ArrayList<String>();

        suxnothta = new ArrayList<Integer>();
        suxnothta2 = new ArrayList<Integer>();
        suxnothta3 = new ArrayList<Integer>();
        suxnothta4 = new ArrayList<Integer>();
        suxnothta5 = new ArrayList<Integer>();
        suxnothtaWordUser1 = new ArrayList<Integer>();
        suxnothtaWordUser2 = new ArrayList<Integer>();
        suxnothtaWordUser3 = new ArrayList<Integer>();
        suxnothtaWordUser4 = new ArrayList<Integer>();
        suxnothtaWordUser5 = new ArrayList<Integer>();
        max = new ArrayList<Integer>();

        /* First Page */
        Scanner sc = new Scanner(new File("src/gr/epp/mhxmath/files/www.page1"));
        k = 0;
        while (sc.hasNext()) {
            String s = sc.next();
            s = s.replaceAll(",", "");
            s = s.replace(".", "");
            s = s.replace("!", "");
            s = s.replace(";", "");
            s = s.replace("?", "");
            s = s.replace(":", "");
            s = s.replace("}", "");
            s = s.replace("{", "");
            s = s.replace("}", "");
            s = s.replace("(", "");
            s = s.replace(")", "");
            s = s.replace("]", "");
            s = s.replace("[", "");

            if (y == 0) {
                word.add(s);
                y = 1;
                suxnothta.add(1);
            } else {
                for (i = 0; i < word.size(); i++) {
                    if (word.get(i).equals(s)) {
                        suxnothta.add(i, suxnothta.get(i) + 1);
                        k = 1;
                        break;
                    }
                }
                if (k == 0) {
                    word.add(s);
                    suxnothta.add(1);
                } else {
                    k = 0;
                }
            }
            Node node = new Node(s);
            if (root == null) {
                root = node;
            } else {
                node.insert(root, s);
            }
        }
        /* End of First Page */

 /* Second Page */
        Scanner sc2 = new Scanner(new File("src/gr/epp/mhxmath/files/www.page2"));
        k = 0;
        y = 0;
        while (sc2.hasNext()) {
            String s = sc2.next();
            s = s.replaceAll(",", "");
            s = s.replace(".", "");
            s = s.replace("!", "");
            s = s.replace(";", "");
            s = s.replace("?", "");
            s = s.replace(":", "");
            s = s.replace("}", "");
            s = s.replace("{", "");
            s = s.replace("}", "");
            s = s.replace("(", "");
            s = s.replace(")", "");
            s = s.replace("]", "");
            s = s.replace("[", "");

            if (y == 0) {
                word2.add(s);
                y = 1;
                suxnothta2.add(1);
            } else {
                for (i = 0; i < word2.size(); i++) {
                    if (word2.get(i).equals(s)) {
                        suxnothta2.add(i, suxnothta2.get(i) + 1);
                        k = 1;
                        break;
                    }
                }
                if (k == 0) {
                    word2.add(s);
                    suxnothta2.add(1);
                } else {
                    k = 0;
                }
            }
            Node node = new Node(s);
            if (root == null) {
                root = node;
            } else {
                node.insert(root, s);
            }
        }
        /* End of Second Page */

 /* Third Page */
        Scanner sc3 = new Scanner(new File("src/gr/epp/mhxmath/files/www.page3"));
        k = 0;
        y = 0;
        while (sc3.hasNext()) {
            String s = sc3.next();
            s = s.replaceAll(",", "");
            s = s.replace(".", "");
            s = s.replace("!", "");
            s = s.replace(";", "");
            s = s.replace("?", "");
            s = s.replace(":", "");
            s = s.replace("}", "");
            s = s.replace("{", "");
            s = s.replace("}", "");
            s = s.replace("(", "");
            s = s.replace(")", "");
            s = s.replace("]", "");
            s = s.replace("[", "");

            if (y == 0) {
                word3.add(s);
                y = 1;
                suxnothta3.add(1);
            } else {
                for (i = 0; i < word3.size(); i++) {
                    if (word3.get(i).equals(s)) {
                        suxnothta3.add(i, suxnothta3.get(i) + 1);
                        k = 1;
                        break;
                    }
                }
                if (k == 0) {
                    word3.add(s);
                    suxnothta3.add(1);
                } else {
                    k = 0;
                }
            }
            Node node = new Node(s);
            if (root == null) {
                root = node;
            } else {
                node.insert(root, s);
            }
        }
        /* End of Third Page */

 /* Fourth Page */
        Scanner sc4 = new Scanner(new File("src/gr/epp/mhxmath/files/www.page4"));
        k = 0;
        y = 0;
        while (sc4.hasNext()) {
            String s = sc4.next();
            s = s.replaceAll(",", "");
            s = s.replace(".", "");
            s = s.replace("!", "");
            s = s.replace(";", "");
            s = s.replace("?", "");
            s = s.replace(":", "");
            s = s.replace("}", "");
            s = s.replace("{", "");
            s = s.replace("}", "");
            s = s.replace("(", "");
            s = s.replace(")", "");
            s = s.replace("]", "");
            s = s.replace("[", "");

            if (y == 0) {
                word4.add(s);
                y = 1;
                suxnothta4.add(1);
            } else {
                for (i = 0; i < word4.size(); i++) {
                    if (word4.get(i).equals(s)) {
                        suxnothta4.add(i, suxnothta4.get(i) + 1);
                        k = 1;
                        break;
                    }
                }
                if (k == 0) {
                    word4.add(s);
                    suxnothta4.add(1);
                } else {
                    k = 0;
                }
            }
            Node node = new Node(s);
            if (root == null) {
                root = node;
            } else {
                node.insert(root, s);
            }
        }
        /* End of Fourth Page */

 /* Fifth Page */
        Scanner sc5 = new Scanner(new File("src/gr/epp/mhxmath/files/www.page5"));
        k = 0;
        y = 0;
        while (sc5.hasNext()) {
            String s = sc5.next();
            s = s.replaceAll(",", "");
            s = s.replace(".", "");
            s = s.replace("!", "");
            s = s.replace(";", "");
            s = s.replace("?", "");
            s = s.replace(":", "");
            s = s.replace("}", "");
            s = s.replace("{", "");
            s = s.replace("}", "");
            s = s.replace("(", "");
            s = s.replace(")", "");
            s = s.replace("]", "");
            s = s.replace("[", "");

            if (y == 0) {
                word5.add(s);
                y = 1;
                suxnothta5.add(1);
            } else {
                for (i = 0; i < word5.size(); i++) {
                    if (word5.get(i).equals(s)) {
                        suxnothta5.add(i, suxnothta5.get(i) + 1);
                        k = 1;
                        break;
                    }
                }
                if (k == 0) {
                    word4.add(s);
                    suxnothta4.add(1);
                } else {
                    k = 0;
                }
            }
            Node node = new Node(s);
            if (root == null) {
                root = node;
            } else {
                node.insert(root, s);
            }
        }
        /* End of Fifth Page */

        btBut0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textUser = tfText0.getText();
                panel01.removeAll();
                if (textUser.equals("")) {
                    panel01.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Error, Please type again!");
                } else if (textUser.equals(" ")) {
                    panel01.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Error, Please type again!");
                } else {
                    Scanner sc2 = new Scanner(textUser);
                    y = 0;
                    k = 0;
                    while (sc2.hasNext()) {
                        String s = sc2.next();
                        s = s.replaceAll(",", "");
                        s = s.replace(".", "");
                        s = s.replace("!", "");
                        s = s.replace(";", "");
                        s = s.replace("?", "");
                        s = s.replace(":", "");
                        s = s.replace("}", "");
                        s = s.replace("{", "");
                        s = s.replace("}", "");
                        s = s.replace("(", "");
                        s = s.replace(")", "");
                        s = s.replace("]", "");
                        s = s.replace("[", "");

                        if (y == 0) {
                            wordTextUser.add(s);
                            y = 1;
                        } else {
                            for (i = 0; i < wordTextUser.size(); i++) {
                                if (wordTextUser.get(i).equals(s)) {
                                    k = 1;
                                    break;
                                }
                            }
                            if (k == 0) {
                                wordTextUser.add(s);
                                suxnothta.add(1);
                            } else {
                                k = 0;
                            }
                        }
                    }

                    for (i = 0; i < wordTextUser.size(); i++) {
                        suxnothtaWordUser1.add(0);
                        suxnothtaWordUser2.add(0);
                        suxnothtaWordUser3.add(0);
                        suxnothtaWordUser4.add(0);
                        suxnothtaWordUser5.add(0);
                    }

                    for (i = 0; i < wordTextUser.size(); i++) {
                        for (j = 0; j < word.size(); j++) {
                            if (wordTextUser.get(i).equals(word.get(j))) {
                                pos1 = j;
                                r = 1;
                                break;
                            }
                        }
                        if (r == 1) {
                            suxnothtaWordUser1.set(i, suxnothta.get(pos1));
                            r = 0;
                        }
                    }

                    for (i = 0; i < wordTextUser.size(); i++) {
                        for (j = 0; j < word2.size(); j++) {
                            if (wordTextUser.get(i).equals(word2.get(j))) {
                                pos2 = j;
                                r = 1;
                                break;
                            }
                        }
                        if (r == 1) {
                            suxnothtaWordUser2.set(i, suxnothta2.get(pos2));
                            r = 0;
                        }
                    }

                    for (i = 0; i < wordTextUser.size(); i++) {
                        for (j = 0; j < word3.size(); j++) {
                            if (wordTextUser.get(i).equals(word3.get(j))) {
                                pos3 = j;
                                r = 1;
                            }
                        }
                        if (r == 1) {
                            suxnothtaWordUser3.set(i, suxnothta3.get(pos3));
                            r = 0;
                        }
                    }

                    for (i = 0; i < wordTextUser.size(); i++) {
                        for (j = 0; j < word4.size(); j++) {
                            if (wordTextUser.get(i).equals(word4.get(j))) {
                                pos4 = j;
                                int r = 1;
                            }
                        }
                        if (r == 1) {
                            suxnothtaWordUser4.set(i, suxnothta4.get(pos4));
                            r = 0;
                        }
                    }

                    for (i = 0; i < wordTextUser.size(); i++) {
                        for (j = 0; j < word5.size(); j++) {
                            if (wordTextUser.get(i).equals(word5.get(j))) {
                                pos5 = j;
                                r = 1;
                            }
                        }

                        if (r == 1) {
                            suxnothtaWordUser5.set(i, suxnothta5.get(pos5));
                            r = 0;
                        }
                    }

                    for (i = 0; i < suxnothtaWordUser1.size(); i++) {
                        sum1 = sum1 + suxnothtaWordUser1.get(i);

                    }
                    for (i = 0; i < suxnothtaWordUser2.size(); i++) {
                        sum2 = sum2 + suxnothtaWordUser2.get(i);

                    }
                    for (i = 0; i < suxnothtaWordUser3.size(); i++) {
                        sum3 = sum3 + suxnothtaWordUser3.get(i);

                    }
                    for (i = 0; i < suxnothtaWordUser4.size(); i++) {
                        sum4 = sum4 + suxnothtaWordUser4.get(i);

                    }
                    for (i = 0; i < suxnothtaWordUser5.size(); i++) {
                        sum5 = sum5 + suxnothtaWordUser5.get(i);

                    }

                    max.add(sum1);
                    max.add(sum2);
                    max.add(sum3);
                    max.add(sum4);
                    max.add(sum5);

                    for (i = 1; i <= 5; i++) {
                        pagesort.add("www.page" + i);
                    }

                    for (int i = 0; i < max.size(); i++) {
                        for (int j = 1; j < (max.size() - i); j++) {
                            if (max.get(j - 1) > max.get(j)) {
                                temp = max.get(j - 1);
                                max.set(j - 1, max.get(j));
                                max.set(j, temp);
                                temp2 = pagesort.get(j - 1);
                                pagesort.set(j - 1, pagesort.get(j));
                                pagesort.set(j, temp2);
                            }
                        }
                    }

                    for (i = pagesort.size(); i > 0; i--) {
                        label = new JButton(pagesort.get(i - 1));
                        panel01.add(label);
                        panel01.setVisible(true);
                    }

                    pack();
                    max.clear();
                    wordTextUser.clear();

                    suxnothtaWordUser1.clear();
                    suxnothtaWordUser2.clear();
                    suxnothtaWordUser3.clear();
                    suxnothtaWordUser4.clear();
                    suxnothtaWordUser5.clear();
                    pagesort.clear();
                    tfText0.setText("");
                    temp = 0;
                    temp2 = "";
                    sum1 = 0;
                    sum2 = 0;
                    sum3 = 0;
                    sum4 = 0;
                    sum5 = 0;
                }
            }
        }
        );
    }
}
