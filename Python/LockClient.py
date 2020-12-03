from ConfigurableLock import ConfigurableLock

myLock1 = ConfigurableLock()

# new locks are unlocked and have a default combination of 0, 0, 0
assert myLock1.is_unlocked()
assert myLock1.get_combo() == [0, 0, 0]

# tries to set an invalid combo
myLock1.set_combo(-4, 15, 2.4)
assert myLock1.get_combo() == [0, 0, 0]

# sets a valid combo
myLock1.set_combo(2, 7, 4)
assert myLock1.get_combo() == [2, 7, 4]

# toString(or str()) when unlocked
print()
print(myLock1.__str__())
print()

# locks the lock and tries the other methods again
myLock1.lock()
assert myLock1.get_combo().__eq__(None)
assert not myLock1.is_unlocked()

# toString(or str()) when locked
print()
print(myLock1.__str__())
print()

# unlock using bad combination
assert not myLock1.unlock(1, 2, 3)
assert myLock1.unlock(2, 7, 4)
assert myLock1.is_unlocked()

# using class method
assert ConfigurableLock.get_number_of_locks() == 1
myLock2 = ConfigurableLock()
myLock3 = ConfigurableLock()
assert ConfigurableLock.get_number_of_locks() == 3

# passing values to the constructor
myLock4 = ConfigurableLock(3, 5, 6)
myLock4.lock()
assert myLock4.unlock(3, 5, 6)
