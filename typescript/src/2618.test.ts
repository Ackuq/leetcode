import { checkIfInstanceOf } from "./2618";

describe("2617. Check If Object Instance of Class", () => {
  it("example 1", () => {
    const actual = checkIfInstanceOf(new Date(), Date);
    const expected = true;
    expect(actual).toEqual(expected);
  });

  it("example 2", () => {
    class Animal {}
    class Dog extends Animal {}
    const actual = checkIfInstanceOf(new Dog(), Animal);
    const expected = true;
    expect(actual).toEqual(expected);
  });

  it("example 3", () => {
    const actual = checkIfInstanceOf(Date, Date);
    const expected = false;
    expect(actual).toEqual(expected);
  });

  it("example 4", () => {
    const actual = checkIfInstanceOf(5, Number);
    const expected = true;
    expect(actual).toEqual(expected);
  });

  it("example 5", () => {
    const actual = checkIfInstanceOf(undefined, undefined);
    const expected = false;
    expect(actual).toEqual(expected);
  });

  it("example 6", () => {
    const actual = checkIfInstanceOf(null, null);
    const expected = false;
    expect(actual).toEqual(expected);
  });

  it("example 7", () => {
    const actual = checkIfInstanceOf(1, null);
    const expected = false;
    expect(actual).toEqual(expected);
  });

  it("example 8", () => {
    const actual = checkIfInstanceOf(1, undefined);
    const expected = false;
    expect(actual).toEqual(expected);
  });

  it("example 9", () => {
    function Container(this: any, value: any) {
      this.value = value;
    }
    function Box(this: any, value: any) {
      this.value = value;
    }
    const b = new (Box as any)(1) as any;

    const expected = false;
    const actual = checkIfInstanceOf(b, Container);
    expect(actual).toEqual(expected);
  });

  it("example 10", () => {
    const expected = true;
    const actual = checkIfInstanceOf(5n, Object);
    expect(actual).toEqual(expected);
  });
});
