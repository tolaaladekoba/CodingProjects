#Name:Adetola Aladekoba
#Class:CSCI 180- W
#Instructor's name: Rhonda Anderson
#Program name: AdetolaAladekobaProgram1
#Date: July 13th 2023

import random
from graphics import*


def main():
    choice = "y"
    while choice.lower() == "y":
        print("play the H A N G M A N game" )
        print("-"*500)
#word list with 250 differenet words 
        words=["mouse","keyboard","laptop","computer","technology","windows","monitor","camera","speaker","joystick","pizza","avocado","peach","orange","grape","tangerine",
                        "lemon","lime","apple","banana","pineapple","watermelon","pear","mango","grapefruit","dragonfruit","kiwi","cherry","papaya","apricot","strawberry","dates","fig",
                        "plum","guava","pomegranate","coconut","jackfruit","melon","raspberry","redcurrant","tomato","pumpkin","olive","plantain","zucchini","cucumber","lettuce",
                        "cauliflower","pea","spinach","cabbage","carrot","ginger","garlic","turmeric","clove","glove","document","fish","gorilla","dog","cat","whale","elephant","lion",
                        "giraffe","rhinosaurus","tiger","leopard","hyena","crocodile","alligator","snake","bear","coyote","cavity","shark","scorpion","ant","antelope","lizard","vulture",
                        "ostrich","eagle","hen","dinosaur","salmon","jellyfish","squid","octopus","shrimp","lobster","crawfish","crayfish","oysters","gut","hurt","dictioinary","tea",
                        "three","threw","life","pie","pocket","money","woman","personal","blue","green","aqua","whine","preach","tree","cocoa","sheabutter","marinate","law","pastor",
                        "bishop","preacher","church","bible","songs","lyrics","choir","worship","praise","thanksgiving","testimony","miracles","flute","recorder","piano","pluto","neptune",
                        "venus","earth","mercury","mars","jupiter","saturn","violin","cello","organ","heart","skin","trumpet","saxophone","tambourine","drum","harp","clarinet","trombone",
                        "oboe","banjo","tuba","harmonica","viola","accordion","woodwind","bassoon","xylophone","french horn","double bass","triangle","ukelele","maraca","square","circle",
                        "rectangle","polygon","hexagon","heptagon","octagon","nonagon","pentagon","rhombus","cube","cuboid","cupboard","paralellogram","parallel","perpendicular","diamond",
                        "quadilateral","decagon","cylinder","sphere","oval","round","flat","trapezoid","crescent","moon","star","rain","cloud","rainbow","thunder","lightning","hurricane",
                        "tsunami","flood","drought","famine","earthquake","volcano","lava","magma","hail","storm","cyclone","avalanche","tornado","wildfire","pandemic","cough","flu",
                        "global","local","input","output","smartwatch","phone","door","handle","television","radio","closet","shower","sink","kitchen","room","blanket","bedsheet",
                        "comforter","duvet","carpet","rug","vacuum","sponge","soap","fork","plate","spoon","exercise","workout","shoe","shelf"]

#draw the starting hangman
        win = GraphWin("Hangman", 800, 800)
        win.setBackground("white")
        message = Text(Point (200 , 50) , "Play the HANGMAN Game(Click here to start) ")
        message.setSize(20)
        line1 = Line(Point(75,75), Point(200,75))
        line2 = Line(Point(200, 75), Point(200,200))
        message.draw(win)
        line1.draw(win)
        line2.draw(win)
        win.getMouse()

#Allows the selection of random words 
        word = random.choice(words)
        
        for x in word:
            print("_", end= " ")


        choice = playgame(word, win)


    print("The Game had ended, Bye!")

def printWord(guessedletter, word):
    counter = 0
    for char in word:
        if char in guessedletter:
            print(word[counter], end =" ")
        else:
            print(" ", end=" ")
        counter +=1
#draw the body of the hangman starting with the head
def hangman(wrong, win):
    if wrong ==1:
        circle = Circle(Point(200,300), 100)
        circle.draw(win)
    if wrong == 2:
        line3 = Line(Point(200,400), Point(200,500))
        line3.draw(win)
    if wrong ==3:
        line4 = Line(Point(200,500), Point(200,600))
        line4.draw(win)
    if wrong == 4:
        line5 = Line(Point(200,500), Point(150, 400))
        line5.draw(win)
    if wrong == 5:
        line6 = Line(Point(200,500), Point(250, 400))
        line6.draw(win)
    if wrong == 6:
        line7 = Line(Point(200,600), Point(150,700))
        line7.draw(win)
    if wrong ==7:
        line8 = Line(Point(200,600), Point(250,700))
        line8.draw(win)
        
def printLine(word):
    print("\r")
    for char in word:
        print("-", end=" ")

def playgame(word, win):
    word_length = len(word)
    wrong = 0
    guess_index = 0
    current_letters_guessed = []
    current_letters_right = 0
    right = 0
    guesses = 0

    while wrong !=7 and right < word_length:
        print("Guesses: ", guesses, "Wrong: ", wrong, "Tried: ", end= " ")

        for letter in current_letters_guessed:
            print(letter.upper(), end=" ")

#Ask user to input a letter
        while True:
            letterGuessed = input("\nEnter a lowercase letter:")
            if len(letterGuessed) !=1 or not letterGuessed.isalpha():
                print("Invalid Input! Please enter a single letter")
            else:
                break

        #user enters same letter
        if letterGuessed in current_letters_guessed:
            print("You already guessed that letter.")
            continue

#if user's guess is right
        if letterGuessed in word:
            # Print word
            guess_index+=1
            right += word.count(letterGuessed)
            current_letters_guessed.append(letterGuessed)
            current_letters_right = printWord(current_letters_guessed, word)
            printLine(word)
#else user's guess is wrong
        else:
            wrong += 1
            current_letters_guessed.append(letterGuessed)
            # Update the drawing
            hangman(wrong, win)
            # Print word
            current_letters_right = printWord(current_letters_guessed, word)
            printLine(word)
        guesses +=1

#if user wins game 
    if right == word_length:
        winmessage=Text(Point (200 , 750) , "You Won ")
        winmessage.draw(win)
        winmessage.setSize(20)
        print()
        print("Congratulations! You guessed the word correctly.")
#else user loses game
    else:
        losemessage=Text(Point(200,750), "Game Over")
        losemessage.draw(win)
        losemessage.setSize(20)
        print()
        print("Sorry, you lost."+ "\nThe word was:", word.upper())

#ask user if they want to play again or not 
    choice = input("Do you want to play again (y/n)?: ")
    return choice


main()