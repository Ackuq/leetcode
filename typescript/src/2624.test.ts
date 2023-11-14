import "./2624";

describe("2622. Cache With Time Limit", () => {
  it("example 1", () => {
    const nums = [
      19, 10, 3, 7, 9, 8, 5, 2, 1, 17, 16, 14, 12, 18, 6, 13, 11, 20, 4, 15,
    ];
    const rowsCount = 5;
    const colsCount = 4;
    const actual = nums.snail(rowsCount, colsCount);
    const expected = [
      [19, 17, 16, 15],
      [10, 1, 14, 4],
      [3, 2, 12, 20],
      [7, 5, 18, 11],
      [9, 8, 6, 13],
    ];
    expect(actual).toEqual(expected);
  });

  it("example 2", () => {
    const nums = [1, 2, 3, 4];
    const rowsCount = 1;
    const colsCount = 4;
    const actual = nums.snail(rowsCount, colsCount);
    const expected = [[1, 2, 3, 4]];
    expect(actual).toEqual(expected);
  });

  it("example 3", () => {
    const nums = [1, 2];
    const rowsCount = 2;
    const colsCount = 2;
    const actual = nums.snail(rowsCount, colsCount);
    const expected: number[][] = [];
    expect(actual).toEqual(expected);
  });
});
