/*
Blackjack.java
CIS 365 Dr.Tong Final Presentation
By: Mike Greene, Gavin Hamilton, Jonathan Shady
*/

//imports
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Collections;



public class Blackjack extends JFrame {
    //properties
    JButton hitButton, standButton, dealButton, exitButton;
    JLabel dealerLabel, playerLabel, dealerValueLabel, playerValueLabel;
    JPanel dealerPanel, playerPanel;

    ArrayList<String> deck;
    ArrayList<String> dealerCards, playerCards;

    //constructor
    public Blackjack() {
        super("Blackjack Game");
        setSize(640, 640);
        setLayout(null);
        getContentPane().setBackground(Color.GREEN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        init();
    }

    //methods
    private void init() {
        //Add the deck of cards to init so the deck is created every time on launch
        createDeck();

        //Create lists to hold dealer and player card
        dealerCards = new ArrayList<>();
        playerCards = new ArrayList<>();

        //Jpanels one to hold dealer cards, one for player
        dealerPanel = new JPanel();
        dealerPanel.setBounds(10, 10, 620, 240); 
        dealerPanel.setBackground(Color.GREEN);

        playerPanel = new JPanel();
        playerPanel.setBounds(10, 320, 620, 240); 
        playerPanel.setBackground(Color.GREEN);

        //Buttons and labels
        //Buttons and labels
        hitButton = new JButton("Hit");
        hitButton.setBounds(10, 570, 160, 40); 

        standButton = new JButton("Stand");
        standButton.setBounds(470, 570, 160, 40); 

        dealButton = new JButton("Deal");
        dealButton.setBounds(10, 520, 160, 40); 

        exitButton = new JButton("Exit");
        exitButton.setBounds(470, 520, 160, 40);

        dealerLabel = new JLabel("Dealer:");
        dealerLabel.setBounds(10, 60, 160, 30); 

        playerLabel = new JLabel("Player:");
        playerLabel.setBounds(10, 380, 160, 30); 

        dealerValueLabel = new JLabel("Dealer value: 0");
        dealerValueLabel.setBounds(480, 60, 160, 30); 

        playerValueLabel = new JLabel("Player value: 0");
        playerValueLabel.setBounds(480, 380, 160, 30);
      
        //add components to the frame
        add(hitButton);
        add(standButton);
        add(dealButton);
        add(exitButton);
        add(dealerLabel);
        add(playerLabel);
        add(dealerValueLabel);
        add(playerValueLabel);
        add(dealerPanel);
        add(playerPanel);

        //add action listeners
        dealButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deal();
            }
        });

        hitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hit();
            }
        });

        standButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stand();
            }
        });
  
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }


  
    //create deck function, modified version from old card game to support png AND face cards
    public void createDeck() {
        deck = new ArrayList<>();
        String[] suits = {"clubs", "spades", "hearts", "diamonds"};
        //First loop to cycle through suits
        for (int j = 0; j < suits.length; j++) {
            String suit = suits[j];
            //Second loop to cycyle through card numbers/facecards and makes them png names
            for (int i = 2; i <= 14; i++) {
                String cardName;
                if (i <= 10) {
                    cardName = i + "_of_" + suit + ".png";
                } else {
                    String faceCard = "";
                    if (i == 11) {
                        faceCard = "jack";
                    } else if (i == 12) {
                        faceCard = "queen";
                    } else if (i == 13) {
                        faceCard = "king";
                    } else if (i == 14) {
                        faceCard = "ace";
                    }
                    cardName = faceCard + "_of_" + suit + ".png";
                }
              //add the created card png name to deck
              deck.add(cardName);
            }
        }
      //shuffle the deck
      Collections.shuffle(deck);
    }


    //removes the top card, draws a card essentially
    public String drawCard() {
        return deck.remove(0);
    }
  

    public void deal() {
    //DEAL FUNCTION TO BE USED W DEAL BUTTON
      
        //clear the hands and panels (mainly for starting new games)
        dealerCards.clear();
        playerCards.clear();
        dealerPanel.removeAll();
        playerPanel.removeAll();

        //deal ONE card to the dealer and the TWO to the player (easier than hiding dealer card)
        dealerCards.add(drawCard());
        playerCards.add(drawCard());
        playerCards.add(drawCard());


        //update the panels to display the dealed cards
        updatePanel(dealerPanel, dealerCards);
        updatePanel(playerPanel, playerCards);
    }



    public void hit() {
    //HIT FUNCTION TO BE USED W HIT BUTTON
  
        //draw a card and add it to the player hand
        playerCards.add(drawCard());

        //update the player to display drew card
        updatePanel(playerPanel, playerCards);

        //check if the player is busted AND stand if player hits 21
        if (calculateHandValue(playerCards) > 21) {
            JOptionPane.showMessageDialog(this, "Busted (You lose)");
        //start new game if busted
            deal();
        }else if (calculateHandValue(playerCards) == 21){
            stand();
        }
        
        
    }


  
    public void stand() {
    //STAND FUNCTION TO BE USED W STAND BUTTON
      
        //when dealers cards are below 17, dealer will always take card
        while (calculateHandValue(dealerCards) < 17) {
            dealerCards.add(drawCard());
        }
      
        //update the dealer panel
        updatePanel(dealerPanel, dealerCards);

        //determine the winner
        int playerValue = calculateHandValue(playerCards);
        int dealerValue = calculateHandValue(dealerCards);

        if (dealerValue > 21 || playerValue > dealerValue) {
            JOptionPane.showMessageDialog(this, "You win! (:");
        } else if (dealerValue == playerValue) {
            JOptionPane.showMessageDialog(this, "Push (tie)");
        } else {
            JOptionPane.showMessageDialog(this, "Dealer wins ):");
        }

        //start a new round
        deal();
    }

  
  
    public void updatePanel(JPanel panel, ArrayList<String> cards) {
        //clear the panel (specified panel will be mentioned when this method is called)
        panel.removeAll();
      
        int xPos = 0;
        //loop to cycle through player or dealer cards, display the card at a width and height divided by 6
        for (int i = 0; i < cards.size(); i++) {
            String card = cards.get(i);
            ImageIcon originalCardImage = new ImageIcon(getClass().getResource("PNG-cards-1.3/" + card));
          
            int cardWidth = originalCardImage.getIconWidth() / 7;
            int cardHeight = originalCardImage.getIconHeight() / 7;

            Image scaledCard = originalCardImage.getImage().getScaledInstance(cardWidth, cardHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledCardd = new ImageIcon(scaledCard);

            //create a jlabel to display each card
            JLabel cardLabel = new JLabel(scaledCardd);
            cardLabel.setBounds(xPos, 0, cardWidth, cardHeight);
            panel.add(cardLabel);
            panel.repaint();
            xPos += 80; //shift the position of the next card
        }
        // update displayed hand labels after placing the cards on the panel
        int dealerValue = calculateHandValue(dealerCards);
        int playerValue = calculateHandValue(playerCards);

        dealerValueLabel.setText("Dealer value: " + dealerValue);
        playerValueLabel.setText("Player value: " + playerValue);
    }
  

    public int calculateHandValue(ArrayList<String> cards) {
    //TAKES THE PNG NAME OF EACH CARD AND MAKES IT A NUMBER VALUE
        int handValue = 0;
        int numAces = 0;

        //loop to cycle through player or dealer cards
        for (int i = 0; i < cards.size(); i++) {
            
            //split the card name by _ and take the first part, next parts converts this string to an int    
            String card = cards.get(i);
            String cardValue = card.split("_")[0];
            int value;

            try {
                value = Integer.parseInt(cardValue);
            } catch (NumberFormatException e) {
                if ("jack".equals(cardValue) || "queen".equals(cardValue) || "king".equals(cardValue)) {
                    value = 10;
                } else if ("ace".equals(cardValue)) {
                    value = 11;
                    numAces++;
                } else {
                    throw new IllegalStateException("Unexpected card value: " + cardValue);
                }
            }
            handValue += value;
        }

        //handle aces as 1 if the hand value is over 21
        while (handValue > 21 && numAces > 0) {
            handValue -= 10;
            numAces--;
        }

        return handValue;
    }


//main method
public static void main(String[] args) {
    Blackjack blackjack = new Blackjack();
  }
}