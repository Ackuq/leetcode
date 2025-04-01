from threading import Semaphore
from typing import Callable

second_semaphore = Semaphore(0)
third_semaphore = Semaphore(0)


class Foo:
    def __init__(self) -> None:
        pass

    def first(self, printFirst: "Callable[[], None]") -> None:

        # printFirst() outputs "first". Do not change or remove this line.
        printFirst()

        second_semaphore.release()

    def second(self, printSecond: "Callable[[], None]") -> None:

        second_semaphore.acquire()

        # printSecond() outputs "second". Do not change or remove this line.
        printSecond()

        third_semaphore.release()

    def third(self, printThird: "Callable[[], None]") -> None:
        third_semaphore.acquire()

        # printThird() outputs "third". Do not change or remove this line.
        printThird()
