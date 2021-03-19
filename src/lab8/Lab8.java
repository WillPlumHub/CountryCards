//C0490418
//William Plummer
//Comp 132, section 1B
//2019-11-
/*This program will fill an array with 'Country Cards' before asking the user
if they want to play the game. If the user enters no the program will cancel,
if the user says yes, the program will randomly pick an object from the array,
display the name of the country stored in the object to the user and ask for
the name of the capitol stored in the object. Whatever the user types in will
be converted to uppercase and compared against the correct answer, if it is
correct the program will congradulate the user and ask them if they want to
play again. If the user's answer is incorrect, the program will display the
correct answer and ask the user if they want to play again. Ecery time the
program picks a card that card is marked as 'used' and will not be picked
again. If the program runs out of cards, it will automatically cancel.*/
package lab8;

import java.util.Scanner;

public class Lab8 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        CountryCard[] countries = new CountryCard[15];
        /*array full of country names*/
        char repeat;
        /*a variable to store whether or not the user wants to play*/
        String answer; //a string to store the users answer
        int counter = 0; //the number of cards used

        createCountries(countries); //activate the method that fills the array

        System.out.print("Want to play a game? [Y][N]:  ");
        /*asking the user if they want to play the game*/

        repeat = input.next().toUpperCase().charAt(0);
        /*checking the users answer*/

        while (repeat == 'Y' && counter < CountryCard.getNumOfInstances()) {
            /*repeat so long as the users agrees to and they have cards left*/
            counter++; //increase counter whenever a card is used
            int cardNum = getCard(countries, counter);
            /*get told which card has been picked by a method*/
            countries[cardNum].setUsed(true);
            /*set the selected card as 'used'*/

            System.out.println("What is the capital of: "
                    + countries[cardNum].getCountry());
            /*ask the user for the capitol of the selected country*/
            answer = input.next().toUpperCase();
            /*make the answer uppercase so the program can read and compare
            it*/

            if (answer.equals(countries[cardNum].getCapital())) {
                /*if the users answer is correct...*/
                System.out.println("Correct\n"); //tell them
            } else { //if not...
                System.out.println("Sorry, the capitol is: "
                        + countries[cardNum].getCapital() + "\n");
                /*tell them and display the correct capitol*/
            }
            System.out.print("Want to play again? [Y][N]:  ");
            /*asking the user if they want to play the game*/
            repeat = input.next().toUpperCase().charAt(0);
            /*checking the users answer*/
        }
        System.out.println("Ok, thanks for playing.");
        /*thank the user for playing the game if they choose to stop plaing
        it or run out of cards*/
    }

    /*Fills the countries array with newly created objects that have a country
    and a capitol
    *Receives the data from the countries array
    *Returns the nothing
     */
    public static void createCountries(CountryCard[] countries) {
        /*generate the country card objects*/
        CountryCard russia = new CountryCard("Russia", "MOSCOW");
        CountryCard usa = new CountryCard("USA", "WASHINGTON");
        CountryCard canada = new CountryCard("Canada", "OTTAWA");
        CountryCard england = new CountryCard("England", "LONDON");
        CountryCard india = new CountryCard("India", "NEW DELHI");
        CountryCard spain = new CountryCard("Spain", "MADRID");
        CountryCard brazil = new CountryCard("Brazil", "BRASILIA");
        CountryCard china = new CountryCard("China", "BEIJING");
        CountryCard japan = new CountryCard("Japan", "TOKYO");
        CountryCard turkey = new CountryCard("Turkey", "ANKARA");
        CountryCard argentina = new CountryCard("Argentina", "BUENOS AIRES");
        CountryCard australia = new CountryCard("Australia", "CANBERRA");
        CountryCard egypt = new CountryCard("Egypt", "CAIRO");
        CountryCard greece = new CountryCard("Greece", "ATHENS");
        CountryCard france = new CountryCard("France", "PARIS");
        /*all the country card objects*/

 /*place all objects in the array*/
        countries[0] = russia;
        countries[1] = usa;
        countries[2] = canada;
        countries[3] = england;
        countries[4] = india;
        countries[5] = spain;
        countries[6] = brazil;
        countries[7] = china;
        countries[8] = japan;
        countries[9] = turkey;
        countries[10] = argentina;
        countries[11] = australia;
        countries[12] = egypt;
        countries[13] = greece;
        countries[14] = france;
    }

    /*Picks a random card and checks if it has been used yet, if it has it
    picks a new card
    *Receives the data from the countries array, and the amount of card that
    have been used so far
    *Returns the number of a random card to be displayed to the user
     */
    public static int getCard(CountryCard[] countries, int counter) {
        int r = 0; //random number value
        do {
            r = (int) (Math.random() * countries.length);
            /*generate a random number from 0-15*/
        } while (countries[r].getUsed() == true && counter
                < CountryCard.getNumOfInstances() + 1);
        /*as long as the number generated hasn't already been picked and there
        are still cards left to pick*/
        return r; //return the random number
    }
}

class CountryCard {

    private static int numOfInstances; //number of cards created
    private String country; //the country the card represents
    private String capital; //the capitol if the country the card represents
    private boolean used; //whether or not the card has been usde or not

    /*
    *
    *
     */
    public CountryCard(String country, String capital) {
        this.country = country; //set the country variable to parameter
        this.capital = capital; //set the capitol variable to parameter
        this.used = false; //set used to false by default
        numOfInstances++; //add increase the number of instances
    }

    /**/
    public void setCountry(String newCountry) {
        country = newCountry; //change the country variable
    }

    /**/
    public void setCapital(String newCapital) {
        capital = newCapital; //change the capitol variable
    }

    /**/
    public void setUsed(boolean newUsedValue) {
        used = newUsedValue; //change if the cards been used or not
    }

    /**/
    public String getCountry() {
        return country; //reutrn the country
    }

    /**/
    public String getCapital() {
        return capital; //reutrn the capitol
    }

    /**/
    public boolean getUsed() {
        return used; //reutrn if the cards been used or not
    }

    /**/
    public static int getNumOfInstances() {
        return numOfInstances; //reutrn the number of instances
    }
}
