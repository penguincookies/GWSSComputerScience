# comments use pound

ACID_THRESHOLD = 6.4
ALKALINE_THRESHOLD = 7.4

print("This program will take the pH of a body of water and")
print("determine if it's habitable to the fish living there.")
print()

pH = eval(input("Enter the water's pH: "))

# instead of "else if", Python uses "elif
# Python also relies on colons and spacing rather than brackets to denote what's in the if statement
if pH > 14 or pH < 0:
    print("Not a valid pH.")
elif pH > 7:
    if pH < ALKALINE_THRESHOLD:
        print("Alkaline, the fish will survive in this water.")
    else:
        print("Too alkaline, the fish will not survive in this water.")
elif pH < 7:
    if pH > ACID_THRESHOLD:
        print("Acidic, the fish will survive in this water.")
    else:
        print("Too acidic, the fish will not survive in this water.")
else:
    print("Neutral, the fish will survive in this water.")
