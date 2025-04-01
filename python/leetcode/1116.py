import threading
from threading import Semaphore
from typing import Callable


class ZeroEvenOdd:
    def __init__(self, n: int) -> None:
        self.n = n
        self.zero_sem = Semaphore()
        self.even_sem = Semaphore(0)
        self.odd_sem = Semaphore(0)

    # printNumber(x) outputs "x", where x is an integer.
    def zero(self, printNumber: "Callable[[int], None]") -> None:
        for _ in range(self.n):
            self.zero_sem.acquire()
            printNumber(0)
            self.even_sem.release()

    def even(self, printNumber: "Callable[[int], None]") -> None:
        for i in range(self.n):
            self.even_sem.acquire()
            if i % 2 == 0:
                printNumber(i + 1)
            self.odd_sem.release()

    def odd(self, printNumber: "Callable[[int], None]") -> None:
        for i in range(self.n):
            self.odd_sem.acquire()
            if i % 2 == 1:
                printNumber(i + 1)
            self.zero_sem.release()


zeo = ZeroEvenOdd(2)


def printNumber(x: int) -> None:
    print(x, end="")


threading.Thread(target=zeo.zero, args=[printNumber]).start()
threading.Thread(target=zeo.even, args=[printNumber]).start()
threading.Thread(target=zeo.odd, args=[printNumber]).start()
