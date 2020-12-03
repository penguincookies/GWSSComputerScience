# showing off the for loop

print("Ounces | Grams")
# the for loop uses a sequence to 'count'
# here, range() returns a sequence of numbers from 1-15 inclusive
# the used sequence doesn't always have to be all numeric values
for i in range(1, 16):
    grams = 28.35 * i
    # this is Python's version of System.out.format
    # the > means right-justified
    # numbers mean the how many spaces are given to format
    # numbers preceded by a period are how many decimal places a number can have
    txt = "{:>6} | {:>6.2f}"
    print(txt.format(i, grams))
