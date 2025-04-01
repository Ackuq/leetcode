from threading import Semaphore
from typing import Callable

foo_sem = Semaphore(1)
bar_sem = Semaphore(0)


class FooBar:
    def __init__(self, n: int) -> None:
        self.n = n

    def foo(self, printFoo: "Callable[[], None]") -> None:

        for _ in range(self.n):
            foo_sem.acquire()
            # printFoo() outputs "foo". Do not change or remove this line.
            printFoo()
            bar_sem.release()

    def bar(self, printBar: "Callable[[], None]") -> None:

        for _ in range(self.n):
            bar_sem.acquire()
            # printBar() outputs "bar". Do not change or remove this line.
            printBar()
            foo_sem.release()
