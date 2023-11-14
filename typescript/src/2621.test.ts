import { sleep } from "./2621";

describe("2621. Sleep", () => {
  it("example 1", async () => {
    const millis = 100;
    const t = Date.now();
    await sleep(millis);
    const actual = Date.now() - t;
    expect(actual).toBeGreaterThanOrEqual(millis);
  });

  it("example 2", async () => {
    const millis = 200;
    const t = Date.now();
    await sleep(millis);
    const actual = Date.now() - t;
    expect(actual).toBeGreaterThanOrEqual(millis);
  });
});
