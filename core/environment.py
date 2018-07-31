import numpy as np

class CoupEnvironment(object):
    """
    An abstraction of the card game "coup", the rules of which can be found here
    http://upload.snakesandlattes.com/rules/c/CoupTheResistance.pdf.
    """
    def __init__(self, numplayers=5):
        if numplayers < 3 or numplayers > 6:
            raise ValueError("numplayers must be between 3 and 6")

        self.cards = np.zeros((numplayers, 2))
        self.deck = np.zeros((15 - numplayers * 2))
    
    def reset(self):
        shuffleddeck = np.array([1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5])
        shuffleddeck = np.random.shuffle(shuffleddeck)

        j = 0

        for i in range(len(self.cards)):
            self.cards[i][0] = shuffleddeck[j]
            j+=1
            self.cards[i][1] = shuffleddeck[j]
            j+=1
        
        self.deck = shuffleddeck[j:]

    def step(self, action):
        raise NotImplementedError

    def close(self):
        pass

    def seed(self):
        pass

    def state_spaces(self):
        pass

    def action_spaces(self):
        pass

    def render(self):
        raise NotImplementedError