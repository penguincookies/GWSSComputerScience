class ConfigurableLock:
    # docstring
    """Blueprint for a lock object that can be configured"""
    # all variables are "name-mangled", due to their name they can't be accessed directly and the user is forced
    # to use getters and setters(much like private variables in Java)
    # attempting to do something like 'ConfigurableLock.__num_of_locks = -3' will now result in an error
    # class variable
    __num_of_locks = 0

    # constructor
    # Python only allows for 1 constructor, so you can assign default values in the parameter list
    # 'self' in the parameter denotes that it's an instance method and will need to use the instance variables
    # any instance variable will need 'self' as a parameter
    def __init__(self, digit1=0, digit2=0, digit3=0):
        # all the instance variables declared in the constructor
        # "self." refers to the instance that called the method
        self.__unlocked = True
        self.__digit1 = digit1
        self.__digit2 = digit2
        self.__digit3 = digit3
        ConfigurableLock.__num_of_locks += 1

    def lock(self):
        self.__unlocked = False
        print("Locked")

    def unlock(self, digit1, digit2, digit3):
        if digit1 == self.__digit1 and digit2 == self.__digit2 and digit3 == self.__digit3:
            self.__unlocked = True
            print("Unlocked")
            return True
        else:
            print("Incorrect combination")
            return False

    def is_unlocked(self):
        return self.__unlocked

    def set_combo(self, digit1, digit2, digit3):
        if self.__unlocked:
            if -1 < digit1 < 10 and -1 < digit2 < 10 and -1 < digit3 < 10:
                self.__digit1 = digit1
                self.__digit2 = digit2
                self.__digit3 = digit3
                print("Combination set successfully")
            else:
                print("Invalid values, combination not set")
        else:
            print("Can't set the combination while the lock is locked")

    def get_combo(self):
        if self.__unlocked:
            return [self.__digit1, self.__digit2, self.__digit3]
        else:
            print("Can't get the combination while the lock is locked")

    # Python's equivalent of a toString()
    def __str__(self):
        if self.__unlocked:
            return "This is a configurable lock object. It is currently unlocked. Its current combination is: " + str(self.get_combo())
        else:
            return "This is a configurable lock object. It is currently locked."

    # class method
    # instead of 'self' as a parameter, now 'cls' is a parameter denoting that something from the class will be accessed
    @classmethod
    def get_number_of_locks(cls):
        return cls.__num_of_locks
