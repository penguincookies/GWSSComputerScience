# Python does support more traditional, static arrays however they are not built-in and must be imported
# I chose to use lists since that's is what Python probably wanted me to use anyways seeing how they're built-in
# although not shown here, Python lists can store different types of variables(and other lists as well)
# Python also supports other data structures such as tuples and sets, none of which are applicable here
# note how an initial list size is not required
scores = []
number_pl = 0

for i in range(1, 19):
    txt = "Enter the score for hole #" + str(i) + "(-1 to finish): "
    number_pl = eval(input(txt))
    # Python lists are dynamic, so you can append new items to them at will
    # they function more similarly to ArrayLists than anything
    if number_pl > -1:
        scores.append(number_pl)
    else:
        break

number_pl = 0
for i in range(0, len(scores)):
    # the syntax for accessing list items remains the same as Java
    number_pl += scores[i]
print("\nTotal score: ", number_pl)

number_pl = scores[0]
for i in range(0, len(scores)):
    if scores[i] > number_pl:
        number_pl = scores[i]
print("Highest score: ", number_pl)

number_pl = scores[0]
for i in range(0, len(scores)):
    if scores[i] < number_pl:
        number_pl = scores[i]
print("Lowest score: ", number_pl)

for i in range(0, len(scores)):
    txt = "Hole {:>2}: {:>3}"
    print(txt.format(i+1, scores[i]))
