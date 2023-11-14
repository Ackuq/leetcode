import { TimeLimitedCache } from "./2622";

jest.useFakeTimers();

describe("2622. Cache With Time Limit", () => {
  let timeLimitedCache: TimeLimitedCache;

  beforeEach(() => {
    timeLimitedCache = new TimeLimitedCache();
  });

  it("example 1", async () => {
    const hit = timeLimitedCache.set(1, 42, 100);
    expect(hit).toBe(false);

    jest.advanceTimersByTime(50);

    const value = timeLimitedCache.get(1);
    expect(value).toBe(42);

    const count = timeLimitedCache.count();
    expect(count).toBe(1);

    jest.advanceTimersByTime(100);

    const value2 = timeLimitedCache.get(1);
    expect(value2).toBe(-1);
  });

  it("example 2", async () => {
    const hit = timeLimitedCache.set(1, 42, 50);
    expect(hit).toBe(false);

    jest.advanceTimersByTime(40);

    const hit2 = timeLimitedCache.set(1, 50, 100);
    expect(hit2).toBe(true);

    jest.advanceTimersByTime(10);

    const value = timeLimitedCache.get(1);
    expect(value).toBe(50);

    jest.advanceTimersByTime(70);

    const value2 = timeLimitedCache.get(1);
    expect(value2).toBe(50);

    jest.advanceTimersByTime(80);

    const value3 = timeLimitedCache.get(1);
    expect(value3).toBe(-1);

    jest.advanceTimersByTime(50);

    const count = timeLimitedCache.count();
    expect(count).toBe(0);
  });
});
