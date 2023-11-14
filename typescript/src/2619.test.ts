import "./2619";

describe("2619. Array Prototype Last", () => {
  it("example 1", () => {
    const nums = [null, {}, 3];
    const actual = nums.last();
    const expected = 3;
    expect(actual).toEqual(expected);
  });

  it("example 2", () => {
    const nums: any[] = [];
    const actual = nums.last();
    const expected = -1;
    expect(actual).toEqual(expected);
  });
});
