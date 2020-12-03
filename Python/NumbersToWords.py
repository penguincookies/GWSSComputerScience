# in Python, the functions have to be declared before you can use them
# they literally have to be above the function call
# functions are initialized with 'def' followed by the name and parameters
# functions are names using lowercase_with_underscores


# functions don't have a specified return type, nor do they always have to return something
def hundreds_string(hundred_multiple):
    """This function takes the hundreds value and returns the word for it"""
    # there are no case/switch statements in Python
    if hundred_multiple == 1:
        return "one-hundred "
    if hundred_multiple == 2:
        return "two-hundred "
    if hundred_multiple == 3:
        return "three-hundred "
    if hundred_multiple == 4:
        return "four-hundred "
    if hundred_multiple == 5:
        return "five-hundred "
    if hundred_multiple == 6:
        return "six-hundred "
    if hundred_multiple == 7:
        return "seven-hundred "
    if hundred_multiple == 8:
        return "eight-hundred "
    if hundred_multiple == 9:
        return "nine-hundred "


def tens_string(ten_multiple):
    """This function takes the tens value and returns the word for it"""
    if ten_multiple == 1:
        return "ten "
    if ten_multiple == 2:
        return "twenty "
    if ten_multiple == 3:
        return "thirty "
    if ten_multiple == 4:
        return "forty "
    if ten_multiple == 5:
        return "fifty "
    if ten_multiple == 6:
        return "sixty "
    if ten_multiple == 7:
        return "seventy "
    if ten_multiple == 8:
        return "eighty "
    if ten_multiple == 9:
        return "ninety "


def ones_string(one_multiple):
    """This function takes the ones value and returns the word for it"""
    if one_multiple == 1:
        return "one"
    if one_multiple == 2:
        return "two"
    if one_multiple == 3:
        return "three"
    if one_multiple == 4:
        return "four"
    if one_multiple == 5:
        return "five"
    if one_multiple == 6:
        return "six"
    if one_multiple == 7:
        return "seven"
    if one_multiple == 8:
        return "eight"
    if one_multiple == 9:
        return "nine"


def teens_string(teen_multiple):
    """This function takes the tens value and returns the word for it"""
    if teen_multiple == 11:
        return "eleven"
    if teen_multiple == 12:
        return "twelve"
    if teen_multiple == 13:
        return "thirteen"
    if teen_multiple == 14:
        return "fourteen"
    if teen_multiple == 15:
        return "fifteen"
    if teen_multiple == 16:
        return "sixteen"
    if teen_multiple == 17:
        return "seventeen"
    if teen_multiple == 18:
        return "eighteen"
    if teen_multiple == 19:
        return "nineteen"


# I never actually made this program in grade 11 so this is
# what I think it would've looked like
output = ""
num = eval(input("Enter a number between 1 and 999: "))
output = output + hundreds_string(int(num/100))
num = num - int(num/100) * 100
if 10 < num < 20:
    output = output + teens_string(num)
else:
    output = output + tens_string(int(num/10))
    num = num - int(num/10) * 10
    output = output + ones_string(num)
print(output)
