# showing off the while loop

# variables don't use camel style
addend = 1
power = 0
sum_total = 0
counter = 1

while sum_total < 2:
    # no need for the math class in python to do exponents
    power = 2**counter
    power = 1.0/power
    sum_total = addend + power
    # can't do string addition with floats and strs by using "+"
    # you have to use "'" or floats must be cast to str
    print(addend, " + ", power, " = " + str(sum_total))
    counter += 1
    addend = sum_total
