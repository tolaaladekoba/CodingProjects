
import random
from graphics import *

def main():
    print("Play the HANGMAN game")
    play_game()

def play_game():
    words = ["apple", "banana", "orange", "strawberry", "pineapple", "watermelon"]  # Add more words to the list
    word = random.choice(words)
    guessed_letters = []
    wrong_count = 0

    while True:
        draw_hangman(wrong_count)

        if check_win(word, guessed_letters):
            print("You win!")
            play_again()
            break

        if wrong_count == 7:
            print("Game Over")
            play_again()
            break

        guess = get_letter()

        if guess in guessed_letters:
            print("You already guessed that letter.")
        elif guess in word:
            print("Correct guess!")
            guessed_letters.append(guess)
        else:
            print("Incorrect guess.")
            wrong_count += 1

        print("Word:", get_current_word(word, guessed_letters))

def get_letter():
    while True:
        guess = input("Guess a letter: ").lower()
        if guess.isalpha() and len(guess) == 1:
            return guess
        else:
            print("Invalid input. Please enter a single letter.")

def get_current_word(word, guessed_letters):
    current_word = ""
    for letter in word:
        if letter in guessed_letters:
            current_word += letter
        else:
            current_word += "_"
    return current_word

def check_win(word, guessed_letters):
    for letter in word:
        if letter not in guessed_letters:
            return False
    return True

def draw_hangman(wrong_count):
    # Use the graphics.py library to draw the hangman board
    win = GraphWin("Hangman", 300, 300)
    # Implement the drawing of the hangman parts based on the wrong_count
    # You can use lines, circles, and other shapes from the graphics library
    win.getMouse()
    win.close()

def play_again():
    choice = input("Do you want to play again? (y/n): ")
    if choice.lower() == "y":
        play_game()
    else:
        print("Thanks for playing!")

if __name__ == "__main__":
    main()

