package JGT190002;

import java.lang.*;
import java.util.*;


public class Main {
    // Main driver for the project
    public static void main(String[] args) {
        // object for SinglyLinkedList class
        SinglyLinkedList objectSinglyLinkedList = new SinglyLinkedList();
        int userInput = 0;
        int validInput = 0;
        Scanner getUserInput = new Scanner(System.in); // object for scanner class

        while (validInput != 7) { // loops till user enters 7
            try {
                do { // loops till user enters value between 1 and 7
                    System.out.println("Operations on List");
                    System.out.println("1. Make Empty");
                    System.out.println("2. Find ID");
                    System.out.println("3. Insert At Front ");
                    System.out.println("4. Delete From Front");
                    System.out.println("5. Delete ID");
                    System.out.println("6. Print All Records");
                    System.out.println("7. Done");
                    System.out.println("-----------------------------------------------------------------------------------------------");

                    System.out.print("Enter the integer associated with the operations on the list (1 - 7): ");
                    userInput = getUserInput.nextInt();
                    System.out.println();
                } while (userInput > 7 || userInput < 1);
                System.out.println("Your Choice: " + userInput);
                System.out.println("-----------------------------------------------------------------------------------------------");

            } catch (Exception e) { // execption used if user enters invalid input like letters
                System.out.println("-----------------------------------------------------------------------------------------------");
                System.out.println(e + " : The entered value must be an integer. Please try again");
                System.out.println("-----------------------------------------------------------------------------------------------");
                getUserInput.next();

            }

            switch (userInput) { // switch case to select code for user select menu choice
                case 1: // set list to empty
                    objectSinglyLinkedList.makeEmpty(); // call .makeEmpty that emptys the list
                    System.out.println("The list has been emptied");
                    System.out.println("-----------------------------------------------------------------------------------------------");
                    break;
                case 2: // find the id user entered in list
                    try {
                        // get user input for the ID user wants to search for in list
                        int userInputtedID;
                        System.out.print("Enter The ID of the product you want to find: ");
                        userInputtedID = getUserInput.nextInt();
                        System.out.println();
                        // if list is empty / return null state list empty
                        if (objectSinglyLinkedList.findID(userInputtedID) == null) {
                            System.out.println("The Inputted ID is not on the list");
                            System.out.println("-----------------------------------------------------------------------------------------------");
                        } else {
                            objectSinglyLinkedList.findID(userInputtedID).printID(); // if not null displays the product using ID which contain id name and supplier
                            System.out.println("-----------------------------------------------------------------------------------------------");
                        }

                    } catch (Exception e) { // input validation for non integers
                        System.out.println("-----------------------------------------------------------------------------------------------");
                        System.out.println(e + " : Invalid entry, input must be integer ID");
                        System.out.println("-----------------------------------------------------------------------------------------------");
                        getUserInput.next();
                    }
                    break;
                case 3: // Input the product in the list if it already exsists dont add but let user know
                    try {
                        // get product ID
                        int userInputtedID;
                        System.out.print("Enter the product ID: ");
                        userInputtedID = getUserInput.nextInt();
                        System.out.println();
                        getUserInput.nextLine();
                        // get Product name
                        String userInputtedProductName;
                        System.out.print("Enter the product name: ");
                        userInputtedProductName = getUserInput.nextLine();
                        System.out.println();
                        // get product supplier
                        String userInputtedSupplierName;
                        System.out.print("Enter the supplier name: ");
                        userInputtedSupplierName = getUserInput.nextLine();
                        System.out.println();
                        // new object of product pass ID, product name and supplier to create a product object
                        Product objectOfProduct = new Product(userInputtedID, userInputtedProductName, userInputtedSupplierName);
                        // call the .insertAtfront that returns null if id already exists if not addes it to the list
                        if(objectSinglyLinkedList.insertAtFront(objectOfProduct)){
                            System.out.println("The product is added to the list");
                            System.out.println("-----------------------------------------------------------------------------------------------");
                        }
                        else{// states product is already in list
                            System.out.println("The product is already in the list");
                            System.out.println("-----------------------------------------------------------------------------------------------");
                        }

                    }catch(Exception e){ // input validation for type differences
                        System.out.println("-----------------------------------------------------------------------------------------------");
                        System.out.println(e + " : Invalid input, ID must be integer, Product name ");
                        System.out.println("must be string, and supplier name must be string");
                        System.out.println("-----------------------------------------------------------------------------------------------");
                        getUserInput.next();
                    }
                    break;
                case 4: // deletes the first item in the list
                    if(objectSinglyLinkedList.isListEmpty()){ // if list is empty states its already empty else delete first item
                        System.out.println("The list is already empty, no product to delete");
                    }else{
                        System.out.println("The first product is: ");
                        System.out.println();
                        objectSinglyLinkedList.deleteFromFront().printID(); // call .deletefromFront that returns the item to be deleted and deletes it form the list
                        System.out.println();
                        System.out.println("The first product is deleted");
                        System.out.println("-----------------------------------------------------------------------------------------------");
                    }
                    break;
                case 5:// deletes a selected product from the list
                    try{
                        if(objectSinglyLinkedList.isListEmpty()) { // if list is empty cant delete let use know
                            System.out.println("The list is already empty, no product to delete");
                            System.out.println("-----------------------------------------------------------------------------------------------");
                        }else{
                            // get user input for the id to be deleted
                            System.out.print("Enter the ID of the product you want to delete: ");
                            int userInputtedID = getUserInput.nextInt();
                            // if user inputed id is not on the list
                            if(objectSinglyLinkedList.findID(userInputtedID) == null){ // uses .findID to see if the product exists or not
                                System.out.println("The product ID is not in the list");
                            }else { // if the element does exsist in the list call .delete(ID) to be deleted
                                System.out.println("The product you want to delete is: ");
                                System.out.println();
                                objectSinglyLinkedList.delete(userInputtedID).printID(); // call .delete which return the item to be deleted and deletes it from the list
                                System.out.println();
                                System.out.println("The product ID " + " has been deleted");
                                System.out.println("-----------------------------------------------------------------------------------------------");
                            }
                        }
                    }catch(Exception e){// input validation for valid userID
                        System.out.println(e + " : Invalid input entered, ID must be type integer");
                        getUserInput.next();
                    }
                    break;
                case 6: // prints all the elements in the list
                    System.out.println();
                    objectSinglyLinkedList.printAllRecords(); // call the .printAllRecords to print the elements if it is empty it says its
                    System.out.println();
                    System.out.println("-----------------------------------------------------------------------------------------------");
                    break;
                case 7: // exit program if user enters 7
                    System.out.println("Done");
                    System.out.println("-----------------------------------------------------------------------------------------------");
                    validInput = 7;
                    break;
            }
        }
    }
}