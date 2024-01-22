import random
from graphics import*


def main():
    choice = "y"
    while choice.lower() == "y":
        print("play the H A N G M A N game" )
        print("--------------------------------------------")
        #make word list
        wordDictionary = [
            'dent', 'market', 'knock', 'smite', 'windy', 'coin', 'throw', 'silence', 'bluff', 'downfall', 'climb', 'lying',
            'weaver', 'snob', 'kickoff', 'match', 'quaker', 'foreman', 'excite',
            'thinking', 'mend', 'allergen', 'pruning', 'coat', 'emerald', 'coherent', 'manic', 'multiple', 'square',
            'funded', 'funnel', 'sailing', 'dream', 'mutation', 'strict', 'mystic', 'film',
            'guide', 'strain', 'bishop', 'settle', 'plateau', 'emigrate', 'marching', 'optimal', 'medley', 'endanger',
            'wick', 'condone', 'schema', 'rage', 'figure', 'plague', 'aloof', 'there', 'reusable',
            'refinery', 'suffer', 'affirm', 'captive', 'flipping', 'prolong', 'main', 'coral', 'dinner', 'rabbit', 'chill',
            'seed', 'born', 'shampoo',
            'italian', 'giggle', 'roost', 'palm', 'globe', 'wise', 'grandson', 'running', 'sunlight', 'spending', 'crunch',
            'tangle', 'forego', 'tailor', 'divinity', 'probe', 'bearded', 'premium', 'featured', 'serve', 'borrower',
            'examine', 'legal',
            'outlive', 'unnamed', 'unending', 'snow', 'whisper', 'bundle', 'bracket', 'deny', 'blurred', 'pentagon',
            'reformed', 'polarity', 'jumping', 'gain',
            'laundry', 'hobble', 'culture', 'whittle', 'docket', 'mayhem', 'build', 'peel', 'board', 'keen', 'glorious',
            'singular', 'cavalry', 'present', 'cold', 'hook',
            'salted', 'just', 'dumpling', 'glimmer', 'drowning', 'admiral', 'sketch', 'subject', 'upright', 'sunshine',
            'slide', 'calamity', 'gurney', 'adult', 'adore', 'weld', 'masking', 'print',
            'wishful', 'foyer', 'tofu', 'machete', 'diced', 'behemoth', 'rout', 'midwife', 'neglect', 'mass', 'game',
            'stocking', 'folly', 'action', 'bubbling', 'scented', 'sprinter', 'bingo', 'egyptian',
            'comedy', 'rung', 'outdated', 'radical', 'escalate', 'mutter', 'desert', 'memento', 'kayak', 'talon', 'portion',
            'affirm', 'dashing', 'fare', 'battle', 'pupil', 'rite', 'smash', 'true', 'entrance',
            'counting', 'peruse', 'dioxide', 'hermit', 'carving', 'backyard', 'homeless', 'medley', 'packet', 'tickle',
            'coming', 'leave', 'swing', 'thicket', 'reserve', 'murder', 'costly', 'corduroy', 'bump',
            'oncology', 'swatch', 'rundown', 'steal', 'teller', 'cable', 'oily', 'official', 'abyss', 'schism', 'failing',
            'guru', 'trim', 'alfalfa', 'doubt', 'booming', 'bruised', 'playful', 'kicker', 'jockey',
            'handmade', 'landfall', 'rhythm', 'keep', 'reassure', 'garland', 'sauna', 'idiom', 'fluent', 'lope', 'gland',
            'amend', 'fashion', 'treaty', 'standing', 'current', 'sharpen', 'cinder', 'idealist', 'festive',
            'frame', 'molten', 'sill', 'glisten', 'fearful', 'basement', 'minutia', 'coin', 'stick', 'featured', 'soot',
            'static']
        #draw the starting hangman
        win = GraphWin("Hangman", 800, 800)
        win.setBackground("white")
        message = Text(Point (200 , 50) , "Play the Hangman Game(Click here to start) ")
        message.setSize(20)
        line1 = Line(Point(75,75), Point(200,75))
        line2 = Line(Point(200, 75), Point(200,200))
        message.draw(win)
        line1.draw(win)
        line2.draw(win)
        win.getMouse()

        #choose a random word
        word = random.choice(wordDictionary)
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
        print("\u203E", end=" ")

def playgame(word, win):
    word_length = len(word)
    wrong = 0
    guess_index = 0
    current_letters_guessed = []
    current_letters_right = 0
    right = 0
    guesses = 0

    while wrong != 7 and right < word_length:
        print("Guesses: ", guesses, "Wrong: ", wrong, "Tried: ", end= " ")

        for letter in current_letters_guessed:
            print(letter, end=" ")

        # Prompt user for input
        while True:
            letterGuessed = input("\nEnter a letter: ")
            if len(letterGuessed) !=1 or not letterGuessed.isalpha():
                print("Invalid Input! Please enter a single letter")
            else:
                break

        #user enters same letter
        if letterGuessed in current_letters_guessed:
            print("You already guessed that letter.")
            continue

        #user is right
        if letterGuessed in word:
            # Print word
            guess_index+=1
            right += word.count(letterGuessed)
            current_letters_guessed.append(letterGuessed)
            current_letters_right = printWord(current_letters_guessed, word)
            printLine(word)
        # User was wrong
        else:
            wrong += 1
            current_letters_guessed.append(letterGuessed)
            # Update the drawing
            hangman(wrong, win)
            # Print word
            current_letters_right = printWord(current_letters_guessed, word)
            printLine(word)
        guesses +=1

    #user wins or looses
    if right == word_length:
        print("Congratulations! You guessed the word correctly.")
    else:
        print("Sorry, you lost. The word was:", word)

    #ask user for choice
    choice = input("Would you like to play again (y/n): ")
    return choice


main()

