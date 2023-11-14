declare global {
  interface Array<T> {
    snail(rowsCount: number, colsCount: number): number[][];
  }
}

Array.prototype.snail = function (
  rowsCount: number,
  colsCount: number
): number[][] {
  if (rowsCount * colsCount !== this.length) return [];
  const result: number[][] = [];

  let i = 0;
  let direction = 1;
  let row = 0;
  while (i < this.length) {
    if (!result[row]) result[row] = [];
    result[row].push(this[i]);
    row += direction;
    if (row === rowsCount || row === -1) {
      direction *= -1;
      row += direction;
    }
    i++;
  }
  return result;
};

/**
 * const arr = [1,2,3,4];
 * arr.snail(1,4); // [[1,2,3,4]]
 */

export {};
