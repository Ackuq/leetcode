import { createCounter } from "./2620";

describe("2620. Counter", () => {
  it("example 1", () => {
    const count = createCounter(10);
    const actual = [count(), count(), count()];
    const expected = [10, 11, 12];
    expect(actual).toEqual(expected);
  });

  it("example 2", () => {
    const count = createCounter(-2);
    const actual = [count(), count(), count(), count(), count()];
    const expected = [-2, -1, 0, 1, 2];
    expect(actual).toEqual(expected);
  });
});
