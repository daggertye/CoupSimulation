import numpy as np

class CoupEnvironment(object):
    """
    An abstraction of the card game "coup", the rules of which can be found here
    http://upload.snakesandlattes.com/rules/c/CoupTheResistance.pdf.
    """
    def __init__(self, numplayers=5):
        pass
    
    def reset(self):
        pass

    def step(self, action):
        pass

    def close(self):
        pass

    def seed(self):
        pass

    def render(self):
        raise NotImplementedError